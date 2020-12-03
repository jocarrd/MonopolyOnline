package Monopoly;

import java.util.ArrayList;

public class Partida {
	private int id_partida;
	private int turno;
	private Tablero tablero;
	private ArrayList<Jugador> jugadores;
	private static final int MAXJUGADORES = 8;

	
	public Partida() {
		this.turno=0;
		this.tablero= new Tablero();
		this.jugadores= new ArrayList<>();
		
		
	}
		
	
	public int getDados() {
		
		return 0;
	}

	public boolean dadosIguales() {

		return true;
	}
	
	public ArrayList<Jugador> getJugadores(){
		return this.jugadores;
	}
	public int numero_jugadores() {
		return this.jugadores.size();
	}
	
	public boolean nuevo_jugador(Jugador c) {
		
			this.jugadores.add(c);
			return true;
		
		
	}

}
