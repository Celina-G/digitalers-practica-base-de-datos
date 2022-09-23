package com.educacionit.digitalers.jdbc.implementaciones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.digitalers.entidades.Cliente;
import com.educacionit.digitalers.excepciones.JDBCException;
import com.octaviorobleto.commons.utilities.text.StringUtils;

public class ClienteImplementacion extends ImplementacionGenerica<Cliente, String> {

	public ClienteImplementacion(Connection conexion) throws JDBCException {
		super(conexion);
	}

	@Override
	public Cliente buscarPorClavePrimaria(String id) {
		if (StringUtils.isEmpty(id)) {
			return null;
		}
		String query = "select nombre, ciudad, calle from clientes where id = ?";

		try {
			if (preparedStatementBuscarPorClavePrimaria == null) {
				preparedStatementBuscarPorClavePrimaria = conexion.prepareStatement(query);
			}
			preparedStatementBuscarPorClavePrimaria.setString(1, id);

			ResultSet resultado = preparedStatementBuscarPorClavePrimaria.executeQuery();
			if (resultado.next()) {
				String nombre = resultado.getString("nombre");
				String ciudad = resultado.getString("ciudad");
				String calle = resultado.getString("calle");
				Cliente cliente = new Cliente(id, nombre, ciudad, calle);
				return cliente;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean guardar(Cliente cliente) {
		if (buscarPorClavePrimaria(cliente.getId_cliente()) == null) {
			return insertar(cliente);
		}
		return false;
	}

	@Override
	public boolean eliminar(Cliente cliente) {
		if (cliente == null) {
			return false;
		}

		String query = "delete from clientes where id = ?";

		try {
			if (preparedStatementEliminar == null) {
				preparedStatementEliminar = conexion.prepareStatement(query);
			}

			preparedStatementEliminar.setString(1, cliente.getId_cliente());

			return preparedStatementEliminar.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Cliente> listar() {
		List<Cliente> clientes = new ArrayList<>();
		String query = "select id, nombre, ciudad, calle from clientes";

		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = conexion.prepareStatement(query);
			}

			ResultSet resultado = preparedStatementListar.executeQuery();

			while (resultado.next()) {
				Cliente cliente = new Cliente();
				cliente.setId_cliente(resultado.getString("id"));
				cliente.setNombre(resultado.getString("nombre"));
				cliente.setCiudad(resultado.getString("ciudad"));
				cliente.setCalle(resultado.getString("calle"));

				clientes.add(cliente);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clientes;
	}

	@Override
	protected boolean insertar(Cliente cliente) {

		if (cliente == null) {
			return false;
		}

		String query = "insert into clientes (id,nombre,ciudad,calle) values (?,?,?,?)";

		try {
			if (preparedStatementInsertar == null) {
				preparedStatementInsertar = conexion.prepareStatement(query);
			}

			preparedStatementInsertar.setString(1, cliente.getId_cliente());
			preparedStatementInsertar.setString(2, cliente.getNombre());
			preparedStatementInsertar.setString(3, cliente.getCiudad());
			preparedStatementInsertar.setString(4, cliente.getCalle());

			return preparedStatementInsertar.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	protected boolean modificar(Cliente cliente) {

		if (cliente == null) {
			return false;
		}

		String query = "update clientes set nombre = ?, ciudad = ?, calle = ? where id = ?";

		try {
			if (preparedStatementActualizar == null) {
				preparedStatementActualizar = conexion.prepareStatement(query);
			}

			preparedStatementActualizar.setString(1, cliente.getId_cliente());
			preparedStatementActualizar.setString(2, cliente.getNombre());
			preparedStatementActualizar.setString(3, cliente.getCiudad());
			preparedStatementActualizar.setString(4, cliente.getCalle());

			return preparedStatementActualizar.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
