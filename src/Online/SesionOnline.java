package Online;

import java.io.Serializable;
import java.net.Socket;
import java.util.List;

import InterfazGrafica.PanelPartida;
import Monopoly.Jugador;
import Monopoly.Partida;

public class SesionOnline extends Thread implements Serializable {
	private Partida partida;
	private PanelPartida panel;
	private Jugador j;
	
	
	
	public SesionOnline(Partida d , Jugador j) {
		this.partida=d;
		this.j=j;
	}
	
	public void run() {
		
		PanelPartida panel= new PanelPartida(partida , j);
		
		
		
		
	}
	
	
	
	
	
	
}
