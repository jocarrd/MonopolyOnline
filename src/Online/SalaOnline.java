package Online;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

import Monopoly.Jugador;
import Monopoly.Partida;

public class SalaOnline extends Thread {
	private Partida partida;
	private static int turno = 0;
	private ArrayList<Socket> jugadores;

	private CyclicBarrier barrera = new CyclicBarrier(3);

	public void run() {
		
		
		System.out.println("Esperando al menos 2 jugadores");
		try {
			this.barrera.await();
			this.Broadcast();
			
			while (true) {
				for(Socket d : jugadores) {
					
						DataInputStream ent = new DataInputStream(d.getInputStream());
						
						String lectura =ent.readLine();
						
						if(lectura.equals("pasoturno")) {
							System.out.println("Estoy aqui");
							ObjectInputStream s = new ObjectInputStream(d.getInputStream());
							Partida actualizada =(Partida) s.readObject();
							this.partida=actualizada;
							this.Broadcast();
							System.out.println("El servidor notifica cambio de turno");
							
							break;
						
		
						}
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

					
				 
				
			
			

	

	public SalaOnline(Partida p) {
		this.partida = p;
		this.jugadores = new ArrayList<>();

	}

	public void anadirJugador(Socket c, Jugador w) {
		this.jugadores.add(c);
		this.partida.nuevo_jugador(w);
		try {
			this.barrera.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		ObjectOutputStream s;
		for (Socket d : this.jugadores) {

			try {
				s = new ObjectOutputStream(d.getOutputStream());
				s.writeObject(partida);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
	}

}
