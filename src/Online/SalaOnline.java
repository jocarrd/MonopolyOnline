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

public class SalaOnline extends Thread {
	private Partida partida;
	private ArrayList<Socket> jugadores;
	private ArrayList<ObjectOutputStream> salidas;
	private ArrayList<ObjectInputStream> entradas;
	private CountDownLatch barrera = new CountDownLatch(2);

	public void run() {

		System.out.println("Esperando al menos 2 jugadores");
		try {
			System.out.println("antes");
			System.out.println(this.partida.getJugadores());
			this.barrera.await();
			System.out.println("despues");
			System.out.println(this.partida.getJugadores());

			for (ObjectOutputStream lanza : this.salidas) {

				lanza.writeBytes("empezamos" + "\r\n");
			}

			this.Broadcast();

			while (true) {

				for (Socket d : jugadores) {

					DataInputStream ent = new DataInputStream(d.getInputStream());

					String lectura = ent.readLine();

					if (lectura.equals("pasoturno")) {

						Partida actualizada = (Partida) this.entradas.get(jugadores.indexOf(d)).readObject();
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

	public SalaOnline(Partida p) {
		this.partida = p;
		this.jugadores = new ArrayList<>();
		this.salidas = new ArrayList<>();
		this.entradas = new ArrayList<>();

	}

	public void anadirJugador(Socket c, Jugador w, ObjectOutputStream sal, ObjectInputStream en) {
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

	public void Broadcast() {

		for (ObjectOutputStream s : this.salidas) {

			try {
				System.out.println("Envio");
				System.out.println(this.partida.getJugadores());
				s.writeObject(partida);
				s.flush();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
	}

}
