package Monopoly;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Casilla {
	private int numero;
	private String nombre;
	private List<Jugador> estan;
	private Image fondo;
	
	public Casilla(int numero , String nombre , Image fondo) {
		this.numero=numero;
		this.nombre=nombre;
		this.fondo=fondo;
		this.estan= new ArrayList<>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Image getFondo() {
		return fondo;
	}
	public void setFondo(Image fondo) {
		this.fondo = fondo;
	}
	
	public boolean anadir_jugador_casilla(Jugador c) {
		if(!this.estan.contains(c)) {
				this.estan.add(c);
				return true;
				
				
		}
		return false;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
