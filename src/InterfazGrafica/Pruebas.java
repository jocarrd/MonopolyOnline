package InterfazGrafica;

import java.awt.Color;

import Monopoly.Jugador;
import Monopoly.Partida;

public class Pruebas {
	public static void main(String [] args) {
		Jugador v = new Jugador("Jorge",Color.BLUE);
		Partida p = new Partida();
		p.nuevo_jugador(v);
		PanelPartida c = new PanelPartida(p,v);
		
		
	}
}
