package com.educacionit.digitalers.entidades;

public class CuentaCorriente extends Cuenta {

	private double descubierto;

	public CuentaCorriente() {
		super();
	}

	public CuentaCorriente(double descubierto, String nro_cuenta, String nombre_sucursal) {
		super(nro_cuenta, nombre_sucursal);
		this.descubierto = descubierto;
	}

	public double getDescubierto() {
		return descubierto;
	}

	public void setDescubierto(double descubierto) {
		this.descubierto = descubierto;
	}

	@Override
	public String toString() {
		return "CuentaCorriente [descubierto=" + descubierto + ", nroCuenta=" + nroCuenta + ", nombre_sucursal="
				+ nombre_sucursal + "]";
	}

}
