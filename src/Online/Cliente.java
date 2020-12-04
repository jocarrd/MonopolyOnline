package Online;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import Monopoly.Partida;

public class Cliente {
	public static void main(String[] args) {

		try {
			Socket servidor = new Socket("localhost", 5555);
			ObjectInputStream  entrada =  new ObjectInputStream (servidor.getInputStream());
			try {
				List<Partida> partidas =(List<Partida>) entrada.readObject(); //Obtenemos las partidas en curso en el servidor
				for(Partida c : partidas) {
					System.out.println(c.getId());
				}
				
				
				
				
				
				
				
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
