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
		RegistrarJugador registro = null;
		DataOutputStream salida = null;
		ObjectInputStream s = null;

		try {
			Socket servidor = new Socket("localhost", 7777);
			salida = new DataOutputStream(servidor.getOutputStream());

			salida.writeBytes("inicio" + "\r\n");
			salida.flush();

			s = new ObjectInputStream(servidor.getInputStream());

			try {
				//carga la lisa de partidas que hay disponibles, las cuales recibe desde el server
				List<Partida> partidas = (List<Partida>) s.readObject();
				
				//se ejecuta la interfaz de registro del jugador
				registro = new RegistrarJugador();

				while (registro.isShowing()) {
					System.out.println();
				}
				Jugador jugador = registro.getJugador(); // Jugador Registrado
				
				//se selecciona a qué partida se quiere unir
				SelecionPartida seleccion = new SelecionPartida(partidas);

				while (seleccion.isShowing()) {
					System.out.println();
				}
				Partida jugar = seleccion.getPartida();
				jugar.nuevo_jugador(jugador);

				salida.writeBytes("unir a partida" + "\r\n");
				salida.writeBytes(jugar.getId() + "\r\n");
				salida.flush();
				
				//se manda el jugador al server para que sea aniadido a la partida
				ObjectOutputStream envioclases = new ObjectOutputStream(salida);
				envioclases.writeObject(jugador);
				envioclases.flush();

				
				
				
				//Espera hasta que el servidor inicie la partida
				s.readLine();
				System.out.println("avanzo");
				//recibe la partida actualizada con todos los jugadores y lista para empezar
				Partida definitiva = (Partida) s.readObject();
				System.out.println(definitiva.getJugadores());
				System.out.println(jugador);
				System.out.println("avanzo2");
				
				//se carga la interfaz donde se va a jugar la partida (la que contiene los metodos de lanzar dados,
				//comprar casillas, pasar turno ...
				TableroCliente interfaz = new TableroCliente(definitiva, jugador, servidor,s,envioclases,salida);
				

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

	}

}
