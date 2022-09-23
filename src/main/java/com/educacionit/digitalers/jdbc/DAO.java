package com.educacionit.digitalers.jdbc;

import java.util.List;

import com.educacionit.digitalers.entidades.Cliente;

public interface DAO<E, K> {

	E buscarPorClavePrimaria(K k);

	boolean guardar(E e);

	boolean eliminar(E e);

	List<E> listar();

}
