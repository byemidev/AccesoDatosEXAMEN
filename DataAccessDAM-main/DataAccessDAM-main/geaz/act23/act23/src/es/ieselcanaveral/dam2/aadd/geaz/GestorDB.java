package es.ieselcanaveral.dam2.aadd.geaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorDB {

	private String url = "jdbc:mysql://localhost:3306/"; 
	private String user = "root"; 
	private String psw = "123";
	
	
	private Connection  getConn() {
		try(Connection conn = DriverManager.getConnection(url, user, psw)){
			return conn;
		}catch(SQLException sqle) {
			System.err.println("error en obteneer la conexion \n" + sqle.getMessage());
		}
		return null;
	}
	
	public void listarPaisesAmericanos() {
		String query = "SELECT * FROM T_PAIS WHERE NOMBRE_PAIS LIKE 'Sa%' and cod_continente = '02';";
		try{
			Statement  st = this.getConn().createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				String codContinente = rs.getString(0);
				String codPais = rs.getString(1);
				String nombrePais= rs.getString(2);
				String capital = rs.getString(3);
				System.out.printf("codigo_continente:%d\n cod_pais:%d\n nombre_pais:%d\n capital:%d\n" , codContinente, codPais, nombrePais, capital);
			}
			st.close();
			rs.close();
			this.getConn().close();
		}catch(SQLException sqle) {
			System.err.println("Error en la conexion en el metodo listar paisesAmericanos" + sqle.getMessage());
		}
	}

	public void addContinenteNuevo() {
		String query = "INSERT INTO T_CONTINENTE (cod_continente , nombre_continente) VALUES ('06', 'Antártida');";
		try {
			Statement st = this.getConn().createStatement();
			st.executeUpdate(query);
			st.close();
		}catch(SQLException sqle) {
			System.err.println("Error en la conexion de AddContinenete nuevo" + sqle.getMessage());
		}
	}

	public void actualizarNombrePais() {
		String query = "UPDATE T_PAIS SET nombre_pais = 'Capital City' WHERE cod_pais = '107';";
		try {
			Statement st = this.getConn().createStatement();
			st.executeUpdate(query);
			st.close();
		} catch (SQLException sqle) {
			System.err.println("Erro en actualizarPais()" + sqle.getMessage());
		}
		
	}

	public void eliminarContinente() {
			String query = "DELETE T_CONTINENTE WHERE cod_continente = '06';";
			try {
				Statement st = this.getConn().createStatement();
				st.executeUpdate(query);
				st.close();
			}catch(SQLException sqle) {
				System.err.println("Error en eliminarContinente()");
			}
	}
	
}
