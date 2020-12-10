package Online;

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
	public static void main(String[] args) {

		try (ServerSocket c = new ServerSocket(5555)) {
			ExecutorService sesiones = Executors.newCachedThreadPool();
			// NO METAS MAS DE 5 PARTIDAS sino F
			List<Partida> partidas = new ArrayList<>();
			Partida v1 = new Partida("Partida 1");
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

					DataInputStream ent = new DataInputStream(cliente.getInputStream());

					if (ent.readLine().equals("inicio")) {
						ObjectOutputStream s = new ObjectOutputStream(cliente.getOutputStream());
						s.writeObject(partidas);
						s.flush();
					}

					if (ent.readLine().equals("unir a partida")) {
						String id_partida = ent.readLine();
						int i = 0;
						int indice = 0;
						for (Partida p : partidas) {
							if (p.getId().equals(id_partida)) {
								indice = i;
							}
							i++;
						}
						ObjectInputStream s = new ObjectInputStream(ent);
						Jugador unir = null;
						try {
							unir = (Jugador) s.readObject();
						} catch (ClassNotFoundException e) {

							e.printStackTrace();
						}
						if(partidas.get(indice).numero_jugadores()>=partidas.get(indice).maxJugadores()) {
							//No se puede unir a la partida
						}else {
							partidas.get(indice).nuevo_jugador(unir); //Jugador en la partida
						}
						
						
						
						

					}

				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
