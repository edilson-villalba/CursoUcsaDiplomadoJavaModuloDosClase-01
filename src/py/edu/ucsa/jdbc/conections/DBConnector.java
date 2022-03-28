package py.edu.ucsa.jdbc.conections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public abstract class DBConnector {
	private static String currentDB = "postgres";
	public static Connection getConexion(String archivo) throws SQLException {
		Connection c = null;
		ResourceBundle bundle = ResourceBundle.getBundle(archivo);
		try {
			c = DriverManager.getConnection(
						bundle.getString("jdbcURL"), 
						bundle.getString("user"), 
						bundle.getString("pwd")
					);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw e;
		}
		return c;
	}
	
	public static Connection getConexionORCL() throws SQLException {
		return getConexion("oracle");
	}
	
	public static Connection getConexionPG() throws SQLException {
		return getConexion("postgres");
	}
	
	/**
	 * Método que devuelve una conexión a la base de datos estipulada en la 
	 * variable currentDB
	 * @return Una conexión a la base de datos seteada por defecto en currentDB
	 * @throws SQLException
	 */
	public static Connection getConexion() throws SQLException {
		return getConexion(currentDB);
	}
	
	/**
	 * Método que recibe el nombre del archivo .properties y setea la variable
	 * que contiene la base de datos a la cual me quiero conectar desde la aplicación
	 * @param database
	 */
	public static void setCurrentDB(String database) {
		currentDB = database;
	}
}
