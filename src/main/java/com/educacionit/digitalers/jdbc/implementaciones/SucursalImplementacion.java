package com.educacionit.digitalers.jdbc.implementaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.digitalers.entidades.Cliente;
import com.educacionit.digitalers.entidades.Sucursal;
import com.educacionit.digitalers.excepciones.JDBCException;
import com.educacionit.digitalers.jdbc.DAO;
import com.octaviorobleto.commons.utilities.text.StringUtils;

public class SucursalImplementacion extends ImplementacionGenerica<Sucursal, String> {

	public SucursalImplementacion(Connection conexion) throws JDBCException {
		super(conexion);
	}

	@Override
	public Sucursal buscarPorClavePrimaria(String nombre) {
		if (StringUtils.isEmpty(nombre)) {
			return null;
		}
		String query = "select ciudad from sucursales where nombre = ?";

		try {
			if (preparedStatementBuscarPorClavePrimaria == null) {
				preparedStatementBuscarPorClavePrimaria = conexion.prepareStatement(query);
			}
			preparedStatementBuscarPorClavePrimaria.setString(1, nombre);

			ResultSet resultado = preparedStatementBuscarPorClavePrimaria.executeQuery();
			if (resultado.next()) {

				String ciudad = resultado.getString("ciudad");
				Sucursal sucursal = new Sucursal(nombre, ciudad);
				return sucursal;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean guardar(Sucursal sucursal) {
		if (buscarPorClavePrimaria(sucursal.getNombre()) == null) {
			return insertar(sucursal);
		}
		return false;
	}

	@Override
	public boolean eliminar(Sucursal sucursal) {
		if (sucursal == null) {
			return false;
		}

		String query = "delete from sucursales where nombre = ?";

		try {
			if (preparedStatementEliminar == null) {
				preparedStatementEliminar = conexion.prepareStatement(query);
			}

			preparedStatementEliminar.setString(1, sucursal.getNombre());

			return preparedStatementEliminar.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Sucursal> listar() {
		List<Sucursal> sucursales = new ArrayList<>();
		String query = "select nombre, ciudad from sucursales";

		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = conexion.prepareStatement(query);
			}

			ResultSet resultado = preparedStatementListar.executeQuery();

			while (resultado.next()) {
				Sucursal sucursal = new Sucursal();
				sucursal.setNombre(resultado.getString("nombre"));
				sucursal.setCiudad(resultado.getString("ciudad"));

				sucursales.add(sucursal);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sucursales;
	}

	@Override
	protected boolean insertar(Sucursal sucursal) {

		if (sucursal == null) {
			return false;
		}

		String query = "insert into sucursales (nombre,ciudad) values (?,?)";

		try {
			if (preparedStatementInsertar == null) {
				preparedStatementInsertar = conexion.prepareStatement(query);
			}

			preparedStatementInsertar.setString(2, sucursal.getNombre());
			preparedStatementInsertar.setString(3, sucursal.getCiudad());

			return preparedStatementInsertar.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	protected boolean modificar(Sucursal sucursal) {

		if (sucursal == null) {
			return false;
		}

		String query = "update sucursales set ciudad = ? where nombre = ?";

		try {
			if (preparedStatementActualizar == null) {
				preparedStatementActualizar = conexion.prepareStatement(query);
			}

			preparedStatementActualizar.setString(1, sucursal.getNombre());
			preparedStatementActualizar.setString(2, sucursal.getCiudad());

			return preparedStatementActualizar.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
