package com.educacionit.digitalers.jdbc.implementaciones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.digitalers.entidades.Prestamo;
import com.educacionit.digitalers.excepciones.JDBCException;
import com.octaviorobleto.commons.utilities.text.StringUtils;

public class PrestamoImplementacion extends ImplementacionGenerica<Prestamo, String> {

	public PrestamoImplementacion(Connection conexion) throws JDBCException {
		super(conexion);
	}

	@Override
	public Prestamo buscarPorClavePrimaria(String numero_prestamo) {
		if (StringUtils.isEmpty(numero_prestamo)) {
			return null;
		}
		String query = "select importe,nombre_sucursal from Prestamo where numero_prestamo = ?";

		try {
			if (preparedStatementBuscarPorClavePrimaria == null) {
				preparedStatementBuscarPorClavePrimaria = conexion.prepareStatement(query);
			}
			preparedStatementBuscarPorClavePrimaria.setString(1, numero_prestamo);

			ResultSet resultado = preparedStatementBuscarPorClavePrimaria.executeQuery();
			if (resultado.next()) {
				double importe = resultado.getDouble("importe");
				String nombre_sucursal = resultado.getString("nombre_sucursal");

				Prestamo prestamo = new Prestamo(numero_prestamo, importe, nombre_sucursal);
				return prestamo;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean guardar(Prestamo prestamo) {
		if (buscarPorClavePrimaria(prestamo.getNumero_prestamo()) == null) {
			return insertar(prestamo);
		}
		return false;
	}

	@Override
	public boolean eliminar(Prestamo prestamo) {
		if (prestamo == null) {
			return false;
		}

		String query = "delete from Prestamos where numero_prestamo = ?";

		try {
			if (preparedStatementEliminar == null) {
				preparedStatementEliminar = conexion.prepareStatement(query);
			}

			preparedStatementEliminar.setString(1, prestamo.getNumero_prestamo());

			return preparedStatementEliminar.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Prestamo> listar() {
		List<Prestamo> prestamos = new ArrayList<>();
		String query = "select numero_prestamos, importe, nombre_sucursal from Prestamos";

		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = conexion.prepareStatement(query);
			}

			ResultSet resultado = preparedStatementListar.executeQuery();

			while (resultado.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setNumero_prestamo(resultado.getString("numero_prestamo"));
				prestamo.setImporte(resultado.getDouble("importe"));
				prestamo.setNombre_sucursal(resultado.getString("nombre_sucursal"));
				;

				prestamos.add(prestamo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prestamos;
	}

	@Override
	protected boolean insertar(Prestamo prestamo) {

		if (prestamo == null) {
			return false;
		}

		String query = "insert into prestamo (numero_prestamo,importe,nombre_sucursal) values (?,?,?)";

		try {
			if (preparedStatementInsertar == null) {
				preparedStatementInsertar = conexion.prepareStatement(query);
			}

			preparedStatementInsertar.setString(1, prestamo.getNumero_prestamo());
			preparedStatementInsertar.setString(2, String.valueOf(prestamo.getImporte()));
			preparedStatementInsertar.setString(3, prestamo.getNombre_sucursal());

			return preparedStatementInsertar.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	protected boolean modificar(Prestamo prestamo) {

		if (prestamo == null) {
			return false;
		}

		String query = "update Prestamos set importe = ?, nombre_sucursal = ? where numero_prestamo = ?";

		try {
			if (preparedStatementActualizar == null) {
				preparedStatementActualizar = conexion.prepareStatement(query);
			}

			preparedStatementActualizar.setString(1, prestamo.getNumero_prestamo());
			preparedStatementActualizar.setString(2, String.valueOf(prestamo.getImporte()));
			preparedStatementActualizar.setString(3, prestamo.getNombre_sucursal());

			return preparedStatementActualizar.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
