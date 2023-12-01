package es.iescanaveral.dam2.aadd.geaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.SQLException;

public class SGBD {
	protected int menuOpciones() {
		Scanner sc = new Scanner(System.in);
		// el error puede estar aqui revisar Scanner sc
		System.out.println("Introduzca el SGBD para el que va a crear la base de datos:\n" + "\n1 - MySQL" + "\n2 - MariaDB"
				+ "\nPulse ' 0 ' para omitir y crear una base de datos Postgre por defecto");

		int elegido = 0;
		if ((elegido = sc.nextInt()) == 1) {
			// CODE to mysql
			System.out.println("has elegido MySQL");
			return elegido;
		} else if (elegido == 2) {
			// CODE to MariaDB
			System.out.println("has elegido MariaDB");
			return elegido;
		} else if (elegido == 0) {
			// CODE to postgreSQL
			System.out.println("has elegido postgreSQL");
			return elegido;
		}
		sc.close();
		return -1;
	}

	protected Connection getConexion(int opcionConecxion) {
		Connection con = null;
		
		String driver = null;
		String port = "://localhost:3306/";
		String user = "root";// verificar en practica de instalacion
		String password = "1234";// esto tambien
		try {
			String url = "";
			switch (opcionConecxion) {
			case 1:
				driver = "jdbc:mysql";
				url = driver + port;
				
				con = DriverManager.getConnection(url, user, password);
				return con;
			case 2:
				driver = "jdbc:mariadb";
				url = driver + port;
				con = DriverManager.getConnection(url, user, password);
				return con; 
			case 0:
				driver = "jdbc:postgresql";
				port = "://localhost:5432/";
				url = driver + port;
				con = DriverManager.getConnection(url, user, password);
				return con;
				case -1:
				System.out.println("Tienes que elegir alguna de las anteriores opciones");
				break;
			}
		} catch (SQLException e) {
			System.err.println("Error en la conexion a la base de datos " + e.getMessage());
		}
		return null;
	}
}
