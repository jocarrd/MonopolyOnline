package Online;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Monopoly.Partida;

public class Servidor {
	public static void main(String[] args) {

		try (ServerSocket c = new ServerSocket(5555)) {
			ExecutorService pool = Executors.newCachedThreadPool();
			List<Partida> partidas = new ArrayList<>();
			partidas.add(new Partida(1));
			partidas.add(new Partida(2));
			partidas.add(new Partida(3));
			partidas.add(new Partida(4));

			while (true) {

				try {

					Socket cliente = c.accept();
					InputStream entrada = cliente.getInputStream();
					ObjectOutputStream  salida =  new ObjectOutputStream (cliente.getOutputStream());
					
					salida.writeObject(partidas);//enviamos el estado de las partidas del servidor
					
					

				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
