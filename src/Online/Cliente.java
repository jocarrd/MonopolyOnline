package Online;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import InterfazGrafica.RegistrarJugador;
import Monopoly.Partida;

public class Cliente {
	public static void main(String[] args) {
		//RegistrarJugador registro = new RegistrarJugador();
		
		try(Socket servidor = new Socket("localhost", 5555);) {
			DataOutputStream  salida =  new DataOutputStream (servidor.getOutputStream());
		
			
			salida.writeBytes("inicio"+"\r\n");
			salida.flush();
			
			ObjectInputStream  s=  new ObjectInputStream (servidor.getInputStream());
			try {
				List<Partida> partidas = (List<Partida>  )s.readObject();
				System.out.println(partidas.toString());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			
			
			
			
			
			//salida.write("unir"+" nombre_partida"+"\r\n");
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
