package Monopoly;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Tablero {

	static final int tam = 39;

	private Casilla[] casillas = new Casilla[40];
	private ArrayList<String> baraja_comunidad = new ArrayList<String>();
	private ArrayList<String> baraja_sorpresa = new ArrayList<String>();

	
	
	
	
	
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
		colores_calles.add(Color.ORANGE);nombres_calles.add("Jorge Vigon");
		
		
		

		int cont = 0;

		for (int i = 0; i <= Tablero.tam; i++) {
			if (i == 0) {
				Casilla c = new Casilla(i, "Salida", TipoCasilla.carcel);  
				this.casillas[i] = c;
			}

			else if ((i % 9 == 0) && (i > 8)) {
				Casilla c = new Casilla(i, "Comunidad", TipoCasilla.comunidad); 
				this.casillas[i] = c;
			}

			else if (i == 14) {
				Casilla c = new Casilla(i, "Carcel", TipoCasilla.carcel); 
				this.casillas[i] = c;

			} else if ((i % 10 == 0) && (i > 9)) {
				Casilla c = new Casilla(i, "Sorpresa", TipoCasilla.sorpresa); 
				this.casillas[i] = c;
			} else if (i == 17) {
				Casilla c = new Casilla(i, "Parking", TipoCasilla.parking); 
				this.casillas[i] = c;

			}
			else if((i==4)||(i==12) ||(i==19)||(i==25) ||(i==35)) {
				Casilla c = new Casilla(i, "Impuesto", TipoCasilla.impuesto); 
				this.casillas[i] = c;
			}

			else {
				Casilla c = new Calle(i,nombres_calles.get(cont) ,colores_calles.get(cont),Math.random()*(1000-500)*500,Math.random()*(100-15)*15, false); 
				this.casillas[i] = c;
				cont++;

		}
	}

}
	







}
