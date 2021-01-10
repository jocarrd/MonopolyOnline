package Monopoly;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Tablero implements Serializable {

	static final int tam = 39;

	private Casilla[] casillas = new Casilla[40];
//	private Map<String,Integer> baraja_comunidad = new HashMap<>();
//	private Map<String ,Integer> baraja_sorpresa = new HashMap<>();
	
	private  List<Integer> baraja_comunidad = new ArrayList<>();
	private  List<Integer> baraja_sorpresa = new ArrayList<>();

	
	
	public Casilla getCasilla(int c) {
		return this.casillas[c];
	}
	
	public  List<Integer> getBarajaComunidad(){
		return baraja_comunidad;
	}
	 
	public List<Integer> getBarajaSorpresa(){
		return baraja_sorpresa;
	}
	
	public Tablero() {

		// Aqui deberiamos inicializar el tablero añadiendo todas las casillas en la
		// posiciones correspondientes
		List<String> nombres_calles = new ArrayList<>();
		List<Color> colores_calles = new ArrayList<>();
		
		
		colores_calles.add(Color.BLUE); nombres_calles.add("Calvo Sotelo");
		colores_calles.add(Color.BLUE); nombres_calles.add("Capitán Cortés");
		colores_calles.add(Color.BLUE);	nombres_calles.add("Coronel Innerarity");
		colores_calles.add(Color.RED);	nombres_calles.add("Defensores de Villarrea");
		colores_calles.add(Color.RED);	nombres_calles.add("Miguel Escalona");
		colores_calles.add(Color.RED);	nombres_calles.add("Avenida Burgos");
		colores_calles.add(Color.YELLOW);nombres_calles.add("Calle Caballero de La Rosa");
		colores_calles.add(Color.YELLOW);nombres_calles.add("Calle Candado");
		colores_calles.add(Color.YELLOW);nombres_calles.add("Calle Emilia Pardo Bazan");
		colores_calles.add(Color.PINK);nombres_calles.add("Avenida España");
		colores_calles.add(Color.PINK);nombres_calles.add("Calle General Espartero");
		colores_calles.add(Color.PINK);nombres_calles.add("Calle Huesca");
		colores_calles.add(Color.GREEN);nombres_calles.add("La Cava");
		colores_calles.add(Color.GREEN);nombres_calles.add("Calle Muro del Carmen");
		colores_calles.add(Color.GREEN);nombres_calles.add("Calle Portalada");
		colores_calles.add(Color.ORANGE);nombres_calles.add("Espolon");
		colores_calles.add(Color.ORANGE);nombres_calles.add("Avenida Madrid");
		colores_calles.add(Color.ORANGE);nombres_calles.add("Gran Vía");
		colores_calles.add(Color.WHITE);nombres_calles.add("Murrieta");
		colores_calles.add(Color.WHITE);nombres_calles.add("Avenida de Portugal");
		colores_calles.add(Color.WHITE);nombres_calles.add("Portales");
		colores_calles.add(Color.ORANGE);nombres_calles.add("Club Deportivo");
		colores_calles.add(Color.ORANGE);nombres_calles.add("Republica Argentina"); 
		colores_calles.add(Color.ORANGE);nombres_calles.add("Lobete");
		
		colores_calles.add(Color.black);nombres_calles.add("Marques de la Ensenada");
		colores_calles.add(Color.black);nombres_calles.add("Avenida de la Paz");
		colores_calles.add(Color.black);nombres_calles.add("Pradoviejo");
		colores_calles.add(Color.black);nombres_calles.add("Alcampo");
		
		colores_calles.add(Color.GREEN);nombres_calles.add("Mercadona");
		colores_calles.add(Color.ORANGE);nombres_calles.add("Aldi");
		colores_calles.add(Color.ORANGE);nombres_calles.add("Edeka");
		colores_calles.add(Color.ORANGE);nombres_calles.add("Eroski");
		colores_calles.add(Color.ORANGE);nombres_calles.add("MacFit");
		
		
//		baraja_comunidad.put("Hacienda te quita ", 500);
//		baraja_comunidad.put("Hacienda te quita ", 300);
//		baraja_comunidad.put("Hacienda te quita ", 550);
//		baraja_comunidad.put("Hacienda te quita ", 400);
//		baraja_comunidad.put("Hacienda te quita ", 200);
//		baraja_comunidad.put("Hacienda te quita ", 100);
//		baraja_comunidad.put("Hacienda te quita ", 150);
//		baraja_comunidad.put("Hacienda te quita ", 220);
//		baraja_comunidad.put("Hacienda te quita ", 440);
//		baraja_comunidad.put("Hacienda te quita ", 50);
//		
//			
//		baraja_sorpresa.put("Se te ha concedido ", 200);
//		baraja_sorpresa.put("Se te ha concedido ", 100);
//		baraja_sorpresa.put("Se te ha concedido ", 120);
//		baraja_sorpresa.put("Se te ha concedido ", 140);
//		baraja_sorpresa.put("Se te ha concedido ", 20);
//		baraja_sorpresa.put("Se te ha concedido ", 50);
//		baraja_sorpresa.put("Se te ha concedido ", 250);
//		baraja_sorpresa.put("Se te ha concedido ", 300);
//		baraja_sorpresa.put("Se te ha concedido ", 70);
//		baraja_sorpresa.put("Se te ha concedido ", 30);
		
		
		baraja_comunidad.add(500);
		baraja_comunidad.add(300);
		baraja_comunidad.add(550);
		baraja_comunidad.add(400);
		baraja_comunidad.add(200);
		baraja_comunidad.add(100);
		baraja_comunidad.add(150);
		baraja_comunidad.add(220);
		baraja_comunidad.add(440);
		baraja_comunidad.add(50);
		
		
		baraja_sorpresa.add(200);
		baraja_sorpresa.add(100);
		baraja_sorpresa.add(120);
		baraja_sorpresa.add(140);
		baraja_sorpresa.add(20);
		baraja_sorpresa.add(50);
		baraja_sorpresa.add(250);
		baraja_sorpresa.add(300);
		baraja_sorpresa.add(70);
		baraja_sorpresa.add(30);
				

		int cont = 0;
		int contBC = 0;
		int contBS = 0;
		
		for (int i = 0; i <= Tablero.tam; i++) {
			if (i == 0) {
				Casilla c = new Casilla(i, "Salida", TipoCasilla.salida);  
				this.casillas[i] = c;
			} 

			else if ((i  == 2) ||(i ==17) || (i ==33)) {
				//Casilla c = new Casilla(i, "Comunidad", TipoCasilla.comunidad);
				Casilla c = new Comunidad(i, "Tienes que pagar a la banca ", baraja_comunidad, null);
				this.casillas[i] = c;
				contBC++;
			}

			else if ((i == 10)||(i == 30))  {
				Casilla c = new Casilla(i, "Carcel", TipoCasilla.carcel); 
				this.casillas[i] = c;

			} else if ((i == 7) || (i == 22)|| (i == 36)) {
				//Casilla c = new Casilla(i, "Sorpresa", TipoCasilla.sorpresa); 
				Casilla c = new Sorpresa(i, "Se te ha concedido ", baraja_sorpresa, null);
				this.casillas[i] = c;
				contBS++;
				
			} else if (i == 20) {
				Casilla c = new Casilla(i, "Parking", TipoCasilla.parking); 
				this.casillas[i] = c;

			}
			else if((i==3)||(i==38) ) {
				Casilla c = new Casilla(i, "Impuesto", TipoCasilla.impuesto); 
				this.casillas[i] = c;
			}

			else {
				Casilla c = new Calle(i,nombres_calles.get(cont) ,colores_calles.get(cont),Math.random()*1000,Math.random()*(100-15)*15); 
				this.casillas[i] = c;
				cont++;

		}
			
		//System.out.println(this.casillas[i].getTipoCasilla());	
	}

}


}
