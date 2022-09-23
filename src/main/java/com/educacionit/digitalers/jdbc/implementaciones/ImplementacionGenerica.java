package com.educacionit.digitalers.jdbc.implementaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.educacionit.digitalers.excepciones.JDBCException;
import com.educacionit.digitalers.jdbc.DAO;

public abstract class ImplementacionGenerica<E, K> implements DAO<E, K> {

	protected PreparedStatement preparedStatementBuscarPorClavePrimaria;
	protected PreparedStatement preparedStatementInsertar;
	protected PreparedStatement preparedStatementEliminar;
	protected PreparedStatement preparedStatementActualizar;
	protected PreparedStatement preparedStatementListar;
	protected Connection conexion;

	public ImplementacionGenerica(Connection conexion) throws JDBCException {
		if (conexion == null) {
			throw new JDBCException("No puedes implementar sin una conexion");
		}
		this.conexion = conexion;
	}

	protected abstract boolean insertar(E e);

	protected abstract boolean modificar(E e);

}
