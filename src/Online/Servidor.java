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

	private static List<SalaOnline> partidas = new ArrayList<>();

	public static void main(String[] args) {

		try (ServerSocket c = new ServerSocket(7777)) {
			System.out.println("Servidor en marcha");
			ExecutorService sesiones = Executors.newCachedThreadPool();
			

			SalaOnline v1 = new SalaOnline( new Partida("Partida 1"));
			SalaOnline v2 = new SalaOnline( new Partida("Partida 2"));
			SalaOnline v3 = new SalaOnline( new Partida("Partida 3"));
		

			partidas.add(v1);
			partidas.add(v2);
			partidas.add(v3);
			

			while (true) {

				try {

					Socket cliente = c.accept();
					System.out.println("Nuevo cliente");
					DataInputStream ent = new DataInputStream(cliente.getInputStream());

					String evaluar = ent.readLine();
					
					
					
					if (evaluar.equals("inicio")) {
						ObjectOutputStream s = new ObjectOutputStream(cliente.getOutputStream());
						s.writeObject(Servidor.getPartidas());
						s.flush();
						System.out.println("Hola");
						evaluar = ent.readLine();
					}

					if (evaluar.equals("unir a partida")) {
						String id_partida = ent.readLine();
						System.out.println("añade");
						ObjectInputStream s = new ObjectInputStream(cliente.getInputStream());
						Jugador unir = null;
						try {
							unir = (Jugador) s.readObject();
							Partida encontrada = Servidor.buscaPartida(id_partida);
							System.out.println(encontrada.getJugadores());
							if (encontrada.numero_jugadores() >= encontrada.maxJugadores()) {
					

							} else {

								Servidor.buscaSalaPartida(id_partida).anadirJugador(cliente, unir);
								Servidor.buscaSalaPartida(id_partida).start();
								System.out.println("añade");
								System.out.println(encontrada.getJugadores());
							}
						} catch (ClassNotFoundException e) {

							e.printStackTrace();
						}

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

		for (SalaOnline p : Servidor.partidas) {
			if (p.getPartida().getId().equals(id)) {
				return p.getPartida();
			}

		}

		return null;
	}
	
	public static SalaOnline buscaSalaPartida(String id) {

		for (SalaOnline p : Servidor.partidas) {
			if (p.getPartida().getId().equals(id)) {
				return p;
			}

		}

		return null;
	}
	
	
	public static List<Partida> getPartidas(){
		List<Partida> partidas = new ArrayList<>();
		
		for(SalaOnline p : Servidor.partidas) {
			partidas.add(p.getPartida());
		}
		return partidas;
	}

}
