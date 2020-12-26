package Online;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import Monopoly.Jugador;
import Monopoly.Partida;

public class SalaOnline extends Thread {
	private Partida partida;

	private ArrayList<Socket> jugadores;

	public void run() {

		this.alguienseUnio();
		
		}

	

	public SalaOnline(Partida p) {
		this.partida = p;
		this.jugadores = new ArrayList<>();

	}

	public void alguienseUnio() {
		Thread hilo = new Thread(new Runnable() {

			@Override
			public void run() {
				
				int c = SalaOnline.this.jugadores.size();
				while (true) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
					System.out.println("Antes"+ c);
					System.out.println("Despues"+SalaOnline.this.jugadores.size());
					if (SalaOnline.this.jugadores.size() != c) {
						
						Sesion ss = new Sesion(jugadores.get(jugadores.size()-1), jugadores ,SalaOnline.this.partida);
						ss.start();
						System.out.println("El jugador : " + SalaOnline.this.partida.getJugadores().get(SalaOnline.this.partida.getJugadores().size()-1).getNombre()+ " Se unio");

					} 

					c = SalaOnline.this.jugadores.size();
					
					

				}

			}

		});

		hilo.start();
	}
	
	public void anadirJugador(Socket c,Jugador w) {
		this.jugadores.add(c);
		this.partida.nuevo_jugador(w);
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
		for (Socket d : this.jugadores) {

			ObjectOutputStream s;
			try {
				s = new ObjectOutputStream(d.getOutputStream());
				s.writeObject(partida);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}

}
