package Online;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import Monopoly.Jugador;
import Monopoly.Partida;

public class SalaOnline extends Thread {
	private Partida partida;

	private List<Socket> jugadores;

	public void run() {

		while (true) {
			
		}

	}

	public SalaOnline(Partida p) {
		this.partida = p;
		this.jugadores = new ArrayList<>();
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public List<Socket> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Socket> jugadores) {
		this.jugadores = jugadores;
	}

	public void anadirJugador(Socket d,Jugador c) {
		this.jugadores.add(d);
		this.partida.nuevo_jugador(c);
	}

}
