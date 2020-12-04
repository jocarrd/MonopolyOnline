package Online;

import java.io.Serializable;

import Monopoly.Partida;

public class SalaOnline extends Thread implements Serializable {
	private Partida partida;
	private int jugadores_actuales;
	private static  int max;
	private String area;
	
	
	public SalaOnline(Partida c,String area) {
		this.partida=c;
		max=c.maxJugadores();
		this.area=area;
	}
	public void run() {
		
		
		while(true) {
			
			
			
			
			
			
		}
		
		
		
	}
	
	
	
	
}
