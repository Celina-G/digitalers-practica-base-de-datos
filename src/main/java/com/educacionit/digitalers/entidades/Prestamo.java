package com.educacionit.digitalers.entidades;

public class Prestamo {

	private String numero_prestamo;
	private double importe;
	private String nombre_sucursal;

	public Prestamo() {
		super();
	}

	public Prestamo(String numero_prestamo, double importe, String nombre_sucursal) {
		super();
		this.numero_prestamo = numero_prestamo;
		this.importe = importe;
		this.nombre_sucursal = nombre_sucursal;
	}

	public String getNumero_prestamo() {
		return numero_prestamo;
	}

	public void setNumero_prestamo(String numero_prestamo) {
		this.numero_prestamo = numero_prestamo;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getNombre_sucursal() {
		return nombre_sucursal;
	}

	public void setNombre_sucursal(String nombre_sucursal) {
		this.nombre_sucursal = nombre_sucursal;
	}

	@Override
	public String toString() {
		return "Prestamo [numero_prestamo=" + numero_prestamo + ", importe=" + importe + ", nombre_sucursal="
				+ nombre_sucursal + "]";
	}

}
