package Monopoly;

import java.awt.Color;
import java.awt.Image;
import java.io.Serializable;

public class Calle extends Casilla implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color;
	private double precio_compra;
	private double alquiler;
	private Jugador Propietario ;
	


	public Calle(int numero, String nombre, Color c, double compra, double venta) {
		super(numero, nombre, TipoCasilla.calle);
		this.color = c;
		this.precio_compra = compra;
		this.alquiler = venta;
		this.Propietario = null;
		 

	}

	public Color getColor() { 
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}

	public double getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(double alquiler) {
		this.alquiler = alquiler;
	}
	
	public boolean TienePropietario() {
		return this.Propietario==null;
	}

	public void setPropietario(Jugador tienePropietario) {
		this.Propietario = tienePropietario;
	}
	

//	public double getPrecio_venta() {
//		return precio_venta;
//	}
//
//	public void setPrecio_venta(double precio_venta) {
//		this.precio_venta = precio_venta;
//	}

}
