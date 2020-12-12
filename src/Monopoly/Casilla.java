package Monopoly;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Casilla implements Serializable {
	private int numero;
	private String nombre;
	private TipoCasilla tipoCasilla;
	
 
	
	public boolean esunaCalle() {
		return tipoCasilla==TipoCasilla.calle;
			 
		
	}
	
	public Casilla(int numero, String nombre, TipoCasilla t) {
		this.numero = numero;
		this.nombre = nombre;
		this.tipoCasilla = t;
		
	}
	
	 

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public TipoCasilla getTipoCasilla() {
		return this.tipoCasilla;
	}
	
	public void setTipoCasilla(TipoCasilla t) {
		this.tipoCasilla = t;
	}
	
	

}
