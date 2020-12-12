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
import InterfazGrafica.SelecionPartida;
import InterfazGrafica.TableroCliente;
import Monopoly.Jugador;
import Monopoly.Partida;

public class Cliente {
	public static void main(String[] args) {
		RegistrarJugador registro=null;
		DataOutputStream salida=null;
		ObjectInputStream s =null;

		try (Socket servidor = new Socket("localhost", 7777);) {
			salida = new DataOutputStream(servidor.getOutputStream());

			salida.writeBytes("inicio" + "\r\n");
			salida.flush();

			 s = new ObjectInputStream(servidor.getInputStream()); 
			
			try {
				List<Partida> partidas = (List<Partida>) s.readObject();
				registro = new RegistrarJugador();

				while(registro.isShowing()) {
					
				}
				Jugador jugador= registro.getJugador(); //Jugador Registrado
				SelecionPartida seleccion = new SelecionPartida(partidas);
				
				while(seleccion.isShowing()) {
					
				}
				Partida jugar = seleccion.getPartida();
				
				System.out.println("ey");
				//inicio proceso unirse a partida
				salida.writeBytes("unir a partida" +"\r\n");
				salida.writeBytes(jugar.getId() +"\r\n" );
				ObjectOutputStream envioclases = new ObjectOutputStream(salida);
				envioclases.writeObject(jugador);
				
				TableroCliente interfaz = new TableroCliente(jugar,jugador);
				
				
				
				
				
				
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			

		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(salida!=null)
				try {
					salida.close();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			
			if(s!=null)
				try {
					s.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}

	}

}
