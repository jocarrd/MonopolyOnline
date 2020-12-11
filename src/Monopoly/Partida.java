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
	
	public boolean estaJugador(Jugador c) {
		for(Jugador jugador : this.jugadores) {
			if(jugador.getNombre().equals(c.getNombre())) {
				return true;
			}
		}
		return false;
	}
	
	public void setJugadores(List<Jugador> jugadores) {
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

	public List<Integer> getDados() {
		
		int d1 =(int) (1+ Math.random()*6);
		int d2 =(int) (1+ Math.random()*6);
		List<Integer> dados = new ArrayList<>();
		dados.add(d1);
		dados.add(d2);
		return dados;
	}

	

	public List<Jugador> getJugadores() {
		return this.jugadores;
	}

	public int numero_jugadores() {
		return this.jugadores.size();

	}

	public boolean nuevo_jugador(Jugador c) {

		this.jugadores.add(c);
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
