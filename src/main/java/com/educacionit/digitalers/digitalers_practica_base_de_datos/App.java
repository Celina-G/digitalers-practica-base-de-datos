package com.educacionit.digitalers.digitalers_practica_base_de_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.educacionit.digitalers.jdbc.implementaciones.ClienteImplementacion;

/**
 * Celina Gramajo
 *
 */

public class App {
	public static void main(String[] args) {

		Connection conexion = null;

		String url = "jdbc:mariadb://localhost:3306/digitalers_base_prueba";
		String usuario = "root";
		String clave = "";
		String driver = "org.mariadb.jdbc.Driver";

		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, usuario, clave);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		

	}
}
