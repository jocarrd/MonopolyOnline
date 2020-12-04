package InterfazGrafica;

import java.awt.Color;

import Monopoly.Jugador;
import Monopoly.Partida;

public class Pruebas {
	public static void main(String [] args) {
		Jugador v1 = new Jugador("Jorge",Color.BLUE);
		Jugador v2 = new Jugador("Adrian",Color.BLUE);
		Partida p = new Partida();
		
		p.nuevo_jugador(v1);
		p.nuevo_jugador(v2);
		
		PanelPartida c = new PanelPartida(p,v1);
		
		
	}
}
