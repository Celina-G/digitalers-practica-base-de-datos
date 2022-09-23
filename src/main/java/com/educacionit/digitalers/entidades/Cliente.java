package com.educacionit.digitalers.entidades;

public class Cliente {

	private String id;
	private String nombre;
	private String ciudad;
	private String calle;

	public Cliente() {
		super();
	}

	public Cliente(String id_cliente, String nombre, String ciudad, String calle) {
		super();
		this.id = id_cliente;
		this.calle = calle;
		this.ciudad = ciudad;
		this.nombre = nombre;
	}

	public String getId_cliente() {
		return id;
	}

	public void setId_cliente(String id_cliente) {
		this.id = id_cliente;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id + ", calle=" + calle + ", ciudad=" + ciudad + ", nombre=" + nombre + "]";
	}

}
