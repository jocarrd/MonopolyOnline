package Online;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Monopoly.Jugador;
import Monopoly.Partida;

public class Servidor {
	public static void main(String[] args) {

		try (ServerSocket c = new ServerSocket(5555)) {
			ExecutorService sesiones = Executors.newCachedThreadPool();
			HashMap<String,Partida> partidas = new HashMap<>();
			Partida v1 = new Partida("1");
			partidas.put(v1.getId(), v1);

			while (true) {

				try {

					Socket cliente = c.accept();
					DataInputStream entrada = new DataInputStream(cliente.getInputStream());
					ObjectOutputStream  salida =  new ObjectOutputStream (cliente.getOutputStream());
					salida.writeObject(partidas);//Enviando estado de las salas
					
					Jugador j;
					
					String id =entrada.readLine(); //Obtenemos el id de la sala para unirnos
					
					//sesiones.execute(new SesionOnline(partidas.get(id),j));
					
					
					
					
					

				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
