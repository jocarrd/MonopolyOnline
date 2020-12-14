package Online;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Monopoly.Jugador;
import Monopoly.Partida;

public class Servidor {

	private static List<Partida> partidas = new ArrayList<>();

	public static void main(String[] args) {

		try (ServerSocket c = new ServerSocket(7777)) {
			System.out.println("Servidor en marcha");
			ExecutorService sesiones = Executors.newCachedThreadPool();
			// NO METAS MAS DE 5 PARTIDAS sino F

			Partida v1 = new Partida("Partida 1");
			
			v1.nuevo_jugador( new Jugador("joselito", Color.BLUE));
			Partida v2 = new Partida("Partida 2");
			Partida v3 = new Partida("Partida 3");
			Partida v4 = new Partida("Partida 4");
			Partida v5 = new Partida("Partida 5");

			partidas.add(v1);
			partidas.add(v2);
			partidas.add(v3);
			partidas.add(v4);
			partidas.add(v5);

			while (true) {

				try {

					Socket cliente = c.accept();
					System.out.println("Nuevo cliente");
					DataInputStream ent = new DataInputStream(cliente.getInputStream());

					if (ent.readLine().equals("inicio")) {
						ObjectOutputStream s = new ObjectOutputStream(cliente.getOutputStream());
						s.writeObject(partidas);
						s.flush();
					}
					

					if (ent.readLine().equals("unir a partida")) {
						String id_partida = ent.readLine();

						ObjectInputStream s = new ObjectInputStream(cliente.getInputStream());
						Jugador unir = null;
						try {
							unir = (Jugador) s.readObject();
							Partida encontrada = Servidor.buscaPartida(id_partida);
							System.out.println(encontrada.getJugadores());
							if (encontrada.numero_jugadores() >= encontrada.maxJugadores()) {
								// No se puede unir a la partida

							} else {
								List<Jugador> jugadores = encontrada.getJugadores();
								jugadores.add(unir); //Añadimos el jugador al principio

								encontrada.setJugadores(jugadores);

								// Jugador en la partida
								System.out.println("añade");
								System.out.println(encontrada.getJugadores());
							}
						} catch (ClassNotFoundException e) {

							e.printStackTrace();
						}

					}

					
					//Null pointer exception en el servidor ... buscar solucion...
					  if(ent.readLine().equals("cambiar turno")) {
					  
					  String id_partida = ent.readLine(); 
					  Partida cambiar =Servidor.buscaPartida(id_partida); 
					  cambiar.pasarTurno();
					  
					  System.out.println("He cambiado de turno");
					  
					  
					  }
					  
					  
					  
					 

				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		} catch (IOException e1) {

			e1.printStackTrace();
		}
	}

	public static Partida buscaPartida(String id) {

		for (Partida p : Servidor.partidas) {
			if (p.getId().equals(id)) {
				return p;
			}

		}

		return null;
	}

}
