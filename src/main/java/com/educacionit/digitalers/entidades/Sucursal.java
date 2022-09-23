package com.educacionit.digitalers.entidades;

public class Sucursal {

	private String nombre;
	private String ciudad;

	public Sucursal() {
		super();
	}

	public Sucursal(String nombre, String ciudad) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Sucursal [nombre=" + nombre + ", ciudad=" + ciudad + "]";
	}

}
