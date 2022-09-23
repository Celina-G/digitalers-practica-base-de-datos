package com.educacionit.digitalers.entidades;

public class CajaDeAhorro extends Cuenta {

	private double tipo_interes;

	public CajaDeAhorro() {
		super();
	}

	public CajaDeAhorro(double tipo_interes, String nro_cuenta, String nombre_sucursal) {
		super(nro_cuenta, nombre_sucursal);
		this.tipo_interes = tipo_interes;
	}

	public double getTipo_interes() {
		return tipo_interes;
	}

	public void setTipo_interes(double tipo_interes) {
		this.tipo_interes = tipo_interes;
	}

	@Override
	public String toString() {
		return "CajaDeAhorro [tipo_interes=" + tipo_interes + ", nroCuenta=" + nroCuenta + ", nombre_sucursal="
				+ nombre_sucursal + "]";
	}

}
