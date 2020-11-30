package Monopoly;

import java.awt.Color;
import java.awt.Image;

public class Calle extends Casilla {
	private Color color;
	private double precio_compra;
	private double alquiler;
	private boolean tienePropietario ;
	


	public Calle(int numero, String nombre, Color c, double compra, double venta, boolean tienePropietario) {
		super(numero, nombre, TipoCasilla.calle);
		this.color = c;
		this.precio_compra = compra;
		this.alquiler = venta;
		this.tienePropietario = tienePropietario;
		

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
	
	public boolean getTienePropietario() {
		return tienePropietario;
	}

	public void setTienePropietario(boolean tienePropietario) {
		this.tienePropietario = tienePropietario;
	}
	

//	public double getPrecio_venta() {
//		return precio_venta;
//	}
//
//	public void setPrecio_venta(double precio_venta) {
//		this.precio_venta = precio_venta;
//	}

}
