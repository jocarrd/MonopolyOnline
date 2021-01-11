package Online;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

import Monopoly.Jugador;
import Monopoly.Partida;

//Dado que el programa es multipartida, se crea una sala online para cada una de ellas, donde se alojan los jugadores
public class SalaOnline extends Thread {
	private Partida partida;
	private ArrayList<Socket> jugadores;
	private ArrayList<ObjectOutputStream> salidas;
	private ArrayList<ObjectInputStream> entradas;
	//creamos una barrera para que se vayan uniendo jugadores a la partida, y hasta que no estan todos
	//no se empieza, en este caso, vamos a ser 2
	private CountDownLatch barrera = new CountDownLatch(2);

	public void run() {

		System.out.println("Esperando al menos 2 jugadores");
		try {
			System.out.println("antes");
			System.out.println(this.partida.getJugadores());
			this.barrera.await();
			System.out.println("despues");
			System.out.println(this.partida.getJugadores());
			
			//manda a cada cliente el mensaje de que se empieza
			for (ObjectOutputStream lanza : this.salidas) {

				lanza.writeBytes("empezamos" + "\r\n");
				lanza.flush();
				lanza.reset();
			}
			//envia la partida actualizada a todos los jugadores
			this.Broadcast();

			while (true) {
				//va leyendo los cambios de turno, que son notificados a esta clase desde TableroCliente
				//para que actualice el estado de la partida y se la mande de nuevo a cada jugador
				for (ObjectInputStream d : entradas) {

					//DataInputStream ent = new DataInputStream(d.getInputStream());

					String lectura = d.readLine();

					if (lectura.equals("pasoturno")) {

						Partida actualizada = (Partida) d.readObject();
								//this.entradas.get(jugadores.indexOf(d)).readObject();
						this.partida = actualizada;
						this.Broadcast();
						System.out.println("El servidor notifica cambio de turno");

						break;

					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//constructor de la sala
	public SalaOnline(Partida p) {
		this.partida = p;
		this.jugadores = new ArrayList<>();
		this.salidas = new ArrayList<>();
		this.entradas = new ArrayList<>();

	}
	
	//aniade un jugador a la partida, lo hemos hecho synchronized cuando buscabamos maneras de solucionar el error
	//de que una partida tenia un jugador y la otra tenia dos
	public synchronized  void anadirJugador(Socket c, Jugador w, ObjectOutputStream sal, ObjectInputStream en) {
		this.jugadores.add(c);
		this.partida.nuevo_jugador(w);
		this.salidas.add(sal);
		this.entradas.add(en);
		this.barrera.countDown();

	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public List<Socket> getJugadores() {
		return jugadores;
	}
	
	//manda a cada jugador la partida actualizada para que todos vean en todo momento las acciones 
	//que han realizado los demas
	public void Broadcast() {
		//"salidas" es una lista de objectOutputStream, asi que cada uno hace referencia a un cliente
		for (ObjectOutputStream s : this.salidas) {

			try {
				System.out.println("Envio");
				System.out.println(this.partida.getJugadores());
				s.writeObject(this.getPartida());
				s.flush();
				s.reset();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
	}

}
