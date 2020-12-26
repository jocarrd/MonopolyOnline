package Online;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import Monopoly.Partida;

public class Sesion extends Thread {
	private ArrayList<Socket> players;
	private Socket cliente;
	private Partida partida;
	
	
	
	
	public void run() {
		
		while(true) {
			
			DataInputStream socketIn;
			try {
				socketIn = new DataInputStream(cliente.getInputStream());
				String lectura = socketIn.readLine();
				
				if (lectura.equals("pasoturno")) {
					
					ObjectInputStream s = new ObjectInputStream(cliente.getInputStream());
					Partida actualizada = (Partida) s.readObject();
					this.partida = actualizada;
					this.Broadcast();
					System.out.println("El servidor notifica cambio de turno");
				}
				 
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 
			
			
			
		}
		
		
		
	}
	
	
	
	
	public Sesion(Socket cliente , ArrayList<Socket> players ,Partida d) {
		this.cliente=cliente;
		this.players=players;
		this.partida=d;
		this.Broadcast();
	}
	
	
	
	
	
	
	public void Broadcast() {
		ObjectOutputStream s;
		for (Socket d : this.players) {

			
			try {
				s = new ObjectOutputStream(d.getOutputStream());
				s.writeObject(partida);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
	}
}
