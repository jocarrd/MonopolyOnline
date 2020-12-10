package Monopoly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

	private String id_partida;
	private int turno;
	private Tablero tablero;
	private List<Jugador> jugadores;
	private static final int MAXJUGADORES = 8;

	public Partida(String id) {
		this.id_partida = id;
		this.turno = 0;
		this.tablero = new Tablero();
		this.jugadores = new ArrayList<>();

	}
	
	public void resetJugadores(List<Jugador> jugadores) {
		this.jugadores=jugadores;
	}
	
	public boolean fin()
	{
		return this.jugadores.size()==0;
	}
	public int maxJugadores() {
		return MAXJUGADORES;
		
	}
	
	public  String getId() {
		return this.id_partida;
	}

	public int getDados() {

		return 0;
	}

	public boolean dadosIguales() {

		return true;
	}

	public List<Jugador> getJugadores() {
		return this.jugadores;
	}

	public int numero_jugadores() {
		return this.jugadores.size();

	}

	public boolean nuevo_jugador(Jugador c) {

		this.jugadores.add(c);
		this.tablero.getCasilla(0).anadir_jugador_casilla(c); // Poenmos en la casilla de salida al jugador que añadimos
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
