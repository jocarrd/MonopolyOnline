package InterfazGrafica;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Monopoly.Jugador;
import Monopoly.Partida;
import javax.swing.JLabel;

public class Pruebas  {
	public static void main(String [] args) throws InterruptedException {
		Jugador v1 = new Jugador("Jorgito",Color.BLUE);
		Jugador v2 = new Jugador("Victor",Color.RED);
		Partida p = new Partida("Partida 1");
		 
		p.nuevo_jugador(v1); 
		p.nuevo_jugador(v2);
		List<Partida> partidas = new ArrayList<>();
		
		 
		TableroCliente c = new TableroCliente(p,v1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(104, 368, 46, 14);
		c.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(635, 117, 46, 14);
		c.getContentPane().add(lblNewLabel_1);
		

			
	}
}
