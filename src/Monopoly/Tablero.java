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

			else {
					//Aqui añadimos las calles , hay que buscar la manera de añadir calles y colores
			}

		}
	}

}
