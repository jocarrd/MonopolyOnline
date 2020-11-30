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
	
	public void jugar_partida() {
		
		
		//Aqui deberiamos empezar a mostar las diferentes interfaces graficas de la partida
		
		
		
	}
	
	
	
	
	public int getDados() {
		
		return 0;
	}

	public boolean dadosIguales() {

		return true;
	}

}
