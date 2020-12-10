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
import Monopoly.Jugador;
import Monopoly.Partida;

public class Cliente {
	public static void main(String[] args) {
		RegistrarJugador registro;

		try (Socket servidor = new Socket("localhost", 5555);) {
			DataOutputStream salida = new DataOutputStream(servidor.getOutputStream());

			salida.writeBytes("inicio" + "\r\n");
			salida.flush();

			ObjectInputStream s = new ObjectInputStream(servidor.getInputStream());
			try {
				List<Partida> partidas = (List<Partida>) s.readObject();
				registro = new RegistrarJugador();

				while(registro.isShowing()) {
					
				}
				Jugador registrado = registro.getJugador(); //Jugador Registrado
				SelecionPartida seleccion = new SelecionPartida(partidas);
				
				while(seleccion.isShowing()) {
					
				}
				Partida jugar = seleccion.getPartida();
				System.out.println(registrado.getNombre()+ registrado.getPosicion_tablero() + registrado.getColor());
				System.out.println(jugar.getId());
				
				
				
				
				
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			// salida.write("unir"+" nombre_partida"+"\r\n");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
