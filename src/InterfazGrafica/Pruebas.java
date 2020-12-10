package InterfazGrafica;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Monopoly.Jugador;
import Monopoly.Partida;

public class Pruebas  {
	public static void main(String [] args) throws InterruptedException {
		Jugador v1 = new Jugador("Jorgito",Color.BLUE);
		Jugador v2 = new Jugador("Victor",Color.RED);
		Partida p = new Partida("Partida 1");
		
		p.nuevo_jugador(v1);
		p.nuevo_jugador(v2);
		List<Partida> partidas = new ArrayList<>();
		
		
		TableroCliente c = new TableroCliente(p,v1);
		

			
	}
}
