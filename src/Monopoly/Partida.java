package Monopoly;

import java.io.Serializable;
import java.util.ArrayList;

public class Partida implements Serializable {
	/**
	 * 
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private int id_partida;
	private int turno;
	private Tablero tablero;
	private ArrayList<Jugador> jugadores;
	private static final int MAXJUGADORES = 8;

	public Partida(int id) {
		this.id_partida = id;
		this.turno = 0;
		this.tablero = new Tablero();
		this.jugadores = new ArrayList<>();

	}
	
	public  int getId() {
		return this.id_partida;
	}

	public int getDados() {

		return 0;
	}

	public boolean dadosIguales() {

		return true;
	}

	public ArrayList<Jugador> getJugadores() {
		return this.jugadores;
	}

	public int numero_jugadores() {
		return this.jugadores.size();

	}

	public boolean nuevo_jugador(Jugador c) {

		this.jugadores.add(c);
		this.tablero.getCasilla(0).anadir_jugador_casilla(c); // Poenmos en la casilla de salida al jugador que a�adimos
		return true;

	}

	public int getTurno() {
		return this.turno;
	}

	public void setTurno(int c) {
		this.turno = c;
	}

	public void pasarTurno() {
		if (this.turno == this.jugadores.size() - 1) {
			this.turno = 0;
		} else {
			this.turno++;
		}
	}

	public Tablero getTablero() {
		return this.tablero;
	}

}
