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
			List<SalaOnline> SalasOnline = new ArrayList<>();
			
			SalasOnline.add(new SalaOnline(new Partida(1),"China"));

			while (true) {

				try {

					Socket cliente = c.accept();
					InputStream entrada = cliente.getInputStream();
					ObjectOutputStream  salida =  new ObjectOutputStream (cliente.getOutputStream());
					salida.writeObject(SalasOnline);
					
					
					

				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
