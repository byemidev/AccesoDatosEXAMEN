package es.iescanaveral.dam2.aadd.geaz;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class AppMain {
	public static void main(String[] args) {
		String nombreBBDD = "MAPAMUNDI";
		String query = "CREATE DATABASE " + nombreBBDD + ";";
		SGBD gestorDB = new SGBD();
		// TODO
		// Segun la opcion del menu devuelta
		int opcion = gestorDB.menuOpciones();
		Connection conexion = null;
		try {
			conexion = gestorDB.getConexion(opcion);
			Statement stm = conexion.createStatement();
			stm.executeUpdate(query);
			stm.close();
		} catch (SQLException e) {
			System.err.println("Error en main SQLConecition" + e.getMessage());
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
