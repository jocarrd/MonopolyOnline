package Monopoly;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
	private String nombre;
	private List<Casa> propiedades;
	private double dinero;
	private int posicion_tablero;

	public Jugador(String nom) {
		this.nombre = nom;
		this.propiedades = new ArrayList<>();
		this.dinero = 0;
		this.posicion_tablero = 0;
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

	public void ingresar_dinero(int din) {
		this.dinero = this.dinero + din;
	}

	public void sacar_dinero(int din) {
		this.dinero = this.dinero - din;
	}

	public void movimiento_tablero(int c) {
		this.posicion_tablero = this.posicion_tablero + c;
	}

	public boolean anadir_propiedad(Casa c) {

		if (this.propiedades.contains(c) == false) {
			this.propiedades.add(c);
			return true;
		}
		return false;

	}

	public boolean eliminar_propiedad(Casa c) {

		if (this.propiedades.contains(c) == true) {
			this.propiedades.remove(c);
			return true;
		}
		return false;

	}

}
