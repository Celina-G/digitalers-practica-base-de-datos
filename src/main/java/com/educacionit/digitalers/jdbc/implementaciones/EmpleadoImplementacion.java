package com.educacionit.digitalers.jdbc.implementaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.digitalers.entidades.Cliente;
import com.educacionit.digitalers.entidades.Empleado;
import com.educacionit.digitalers.excepciones.JDBCException;
import com.educacionit.digitalers.jdbc.DAO;
import com.octaviorobleto.commons.utilities.text.StringUtils;
import com.octaviorobleto.commons.utilities.time.DateUtils;

public class EmpleadoImplementacion extends ImplementacionGenerica<Empleado, String> {

	public EmpleadoImplementacion(Connection conexion) throws JDBCException {
		super(conexion);
	}

	@Override
	public Empleado buscarPorClavePrimaria(String id) {
		if (StringUtils.isEmpty(id)) {
			return null;
		}
		String query = "select nombre, numero_telefono, fecha_incorporacion from Empleados where id = ?";

		try {
			if (preparedStatementBuscarPorClavePrimaria == null) {
				preparedStatementBuscarPorClavePrimaria = conexion.prepareStatement(query);
			}
			preparedStatementBuscarPorClavePrimaria.setString(1, id);

			ResultSet resultado = preparedStatementBuscarPorClavePrimaria.executeQuery();
			if (resultado.next()) {
				String nombre = resultado.getString("nombre");
				String numero_telefono = resultado.getString("numero_telefono");
				LocalDateTime fecha_incorporacion = DateUtils
						.getLocalDateTime(resultado.getString("fecha_incorporacion"), "yyyy-MM-dd HH:mm:ss");

				Empleado empleado = new Empleado(id, nombre, fecha_incorporacion, numero_telefono);
				return empleado;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean guardar(Empleado empleado) {
		if (buscarPorClavePrimaria(empleado.getId_empleado()) == null) {
			return insertar(empleado);
		}
		return false;
	}

	@Override
	public boolean eliminar(Empleado empleado) {
		if (empleado == null) {
			return false;
		}

		String query = "delete from EMpleados where id = ?";

		try {
			if (preparedStatementEliminar == null) {
				preparedStatementEliminar = conexion.prepareStatement(query);
			}

			preparedStatementEliminar.setString(1, empleado.getId_empleado());

			return preparedStatementEliminar.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Empleado> listar() {
		List<Empleado> empleados = new ArrayList<>();
		String query = "select id, nombre, numero_telefono, fecha_incorporacion from Empleados";

		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = conexion.prepareStatement(query);
			}

			ResultSet resultado = preparedStatementListar.executeQuery();

			while (resultado.next()) {
				Empleado empleado = new Empleado();
				empleado.setId_empleado(resultado.getString("id"));
				empleado.setNombre(resultado.getString("nombre"));
				empleado.setNumero_telefono(resultado.getString("numero_telefono"));
				empleado.setFecha_incorporacion(
						DateUtils.getLocalDateTime(resultado.getString("fecha_incorporacion"), "yyyy-MM-dd HH:mm:ss"));

				empleados.add(empleado);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empleados;
	}

	@Override
	protected boolean insertar(Empleado empleado) {

		if (empleado == null) {
			return false;
		}

		String query = "insert into Empleados (id,nombre,numero_telefono,fecha_incorporacion) values (?,?,?,NOW())";

		try {
			if (preparedStatementInsertar == null) {
				preparedStatementInsertar = conexion.prepareStatement(query);
			}

			preparedStatementInsertar.setString(1, empleado.getId_empleado());
			preparedStatementInsertar.setString(2, empleado.getNombre());
			preparedStatementInsertar.setString(3, empleado.getNumero_telefono());

			return preparedStatementInsertar.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	protected boolean modificar(Empleado empleado) {

		if (empleado == null) {
			return false;
		}

		String query = "update Empelados set nombre = ?, nuemero_telefono = ?, fecha_incorporacion = ? where id = ?";

		try {
			if (preparedStatementActualizar == null) {
				preparedStatementActualizar = conexion.prepareStatement(query);
			}

			preparedStatementActualizar.setString(1, empleado.getId_empleado());
			preparedStatementActualizar.setString(2, empleado.getNombre());
			preparedStatementActualizar.setString(3, empleado.getNumero_telefono());
			preparedStatementActualizar.setString(4,
					DateUtils.getString(empleado.getFecha_incorporacion(), "yyyy-MM-dd HH:mm:ss"));

			return preparedStatementActualizar.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
