package com.educacionit.digitalers.entidades;

public abstract class Cuenta {

	protected String nroCuenta;
	protected String nombre_sucursal;

	public Cuenta() {
		super();
	}

	public Cuenta(String nroCuenta, String nombre_sucursal) {
		super();
		this.nroCuenta = nroCuenta;
		this.nombre_sucursal = nombre_sucursal;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public String getNombre_sucursal() {
		return nombre_sucursal;
	}

	public void setNombre_sucursal(String nombre_sucursal) {
		this.nombre_sucursal = nombre_sucursal;
	}

	@Override
	public String toString() {
		return "Cuenta [nroCuenta=" + nroCuenta + ", nombre_sucursal=" + nombre_sucursal + "]";
	}

}
