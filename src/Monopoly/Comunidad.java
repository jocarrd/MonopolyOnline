package Monopoly;

import java.awt.Color;
import java.util.List;

public class Comunidad extends Casilla{
	String s;
	List<Integer> l;
	Color col;
	
	public Comunidad(int numero, String nombre, List<Integer> l, Color c ) {
		super(numero, nombre, TipoCasilla.comunidad);
		this.col = c;
		this.l = l;
	}
	
	public String getText(){
		return this.s;
	}
	
	public List<Integer> getListaCantidades(){
		return this.l;
	}

}
