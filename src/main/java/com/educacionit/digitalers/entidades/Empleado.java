package com.educacionit.digitalers.entidades;

import java.time.LocalDateTime;

public class Empleado {

	private String id_empleado;
	private String nombre;
	private LocalDateTime fecha_incorporacion;
	private String numero_telefono;

	public Empleado() {
		super();
	}

	public Empleado(String id_empleado, String nombre, LocalDateTime fecha_incorporacion, String numero_telefono) {
		super();
		this.id_empleado = id_empleado;
		this.nombre = nombre;
		this.fecha_incorporacion = fecha_incorporacion;
		this.numero_telefono = numero_telefono;
	}

	public String getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(String id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDateTime getFecha_incorporacion() {
		return fecha_incorporacion;
	}

	public void setFecha_incorporacion(LocalDateTime fecha_incorporacion) {
		this.fecha_incorporacion = fecha_incorporacion;
	}

	public String getNumero_telefono() {
		return numero_telefono;
	}

	public void setNumero_telefono(String numero_telefono) {
		this.numero_telefono = numero_telefono;
	}

	@Override
	public String toString() {
		return "Empleado [id_empleado=" + id_empleado + ", nombre=" + nombre + ", fecha_incorporacion="
				+ fecha_incorporacion + ", numero_telefono=" + numero_telefono + "]";
	}

}
