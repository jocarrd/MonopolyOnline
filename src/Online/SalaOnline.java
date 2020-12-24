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
	

	private List<Socket> jugadores;

	public void run() {
		
		
		while (true) {
			for(Socket d : jugadores) {
				try {
					DataInputStream ent = new DataInputStream(d.getInputStream());

					String lectura =ent.readLine();
					if(lectura.equals("pasoturno")) {
						ObjectInputStream s = new ObjectInputStream(d.getInputStream());
						Partida actualizada =(Partida) s.readObject();
						this.partida=actualizada;
						this.Broadcast();
						
						break;
					}
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}catch(NullPointerException e) {
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

	}

	public SalaOnline(Partida p) {
		this.partida = p;
		this.jugadores = new ArrayList<>();
		
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

	public void setJugadores(List<Socket> jugadores) {
		this.jugadores = jugadores;
	}

	public void anadirJugador(Socket d,Jugador c) {
		this.jugadores.add(d);
		this.partida.nuevo_jugador(c);
	}
	
	public void Broadcast() {
		for(Socket d : this.jugadores) {
			
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
