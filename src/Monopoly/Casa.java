package Monopoly;

import java.awt.Color;
import java.awt.Image;

public class Casa extends Casilla {
	private Color color;
	private double precio_compra;
	private double precio_venta;

	public Casa(int numero, String nombre, Image fondo, Color c, double compra, double venta) {
		super(numero, nombre, fondo);
		this.color = c;
		this.precio_compra = compra;
		this.precio_venta = venta;

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

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

}
