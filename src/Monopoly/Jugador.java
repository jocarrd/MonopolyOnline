package Monopoly;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Jugador implements Serializable {
	private String nombre;
	private List<Calle> propiedades;
	private double dinero;
	private int posicion_tablero;
	private  Color c ;

	public Jugador(String nom,Color c) {
		//Se pone en la casilla de salida al jugador
		
		this.nombre = nom;
		this.propiedades = new ArrayList<>();
		this.dinero = 2000;
		this.posicion_tablero = 0;
		this.c=c;
	}
	
	public Color getColor() {
		return this.c;
	}

	public String getNombre() {
		return nombre;
	} 

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	public int getPosicion_tablero() {
		return posicion_tablero;
	}

	public void setPosicion_tablero(int posicion_tablero) {
		this.posicion_tablero = posicion_tablero;
	}
	
	public List<Calle> getPropiedades() {
		return this.propiedades;
	}

	public void ingresar_dinero(double din) {
		this.dinero = this.dinero + din;
	}

	public void sacar_dinero(double din) {
		this.dinero = this.dinero - din;
	}

	public void movimiento_tablero(int c) {
		if (this.posicion_tablero + c >= Tablero.tam) {
			this.posicion_tablero = (this.posicion_tablero + c) - Tablero.tam;
		}else {
			this.posicion_tablero = this.posicion_tablero + c;
		}

		
	}

	public boolean anadir_propiedad(Calle c) {

		if (this.propiedades.contains(c) == false) {
			this.propiedades.add(c);
			return true;
		}
		return false;

	}

	public boolean eliminar_propiedad(Calle c) {

		if (this.propiedades.contains(c) == true) {
			this.propiedades.remove(c);
			return true;
		}
		return false;

	}

}
