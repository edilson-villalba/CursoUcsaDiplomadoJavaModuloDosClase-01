package py.edu.ucsa.jdbc.conections;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * 	Este es el primer ejemplo de conectividad a una base de datos.
 * 	El alumno debe completar las indicaciones marcadas con "TODO", solucionando
 * los inconvenientes que vayan surgiendo.
 * 
 * @author Pablo
 * 
 */
public class Conexion {
	
	
	public static void main(String[] args) {

            //TODO: Cargar el Driver, por ejemplo:
			//String driverName = "PONER AQUI EL NOMBRE DE LA CLASE DEL DRIVER";
            // Class.forName(driverName);
            
            String url = "jdbc:postgresql://localhost:5432/persona-db";
            String uname = "postgres";
            String passwd = "inv";
            //TODO: Conectarse a la base de datos.
            
            try {
			Connection c = DriverManager.getConnection(url, uname, passwd);
			System.out.println( "Estamos conectados al: " 
    				+ c.getMetaData().getDatabaseProductName()
    				+ " "
    				+ c.getMetaData().getDatabaseProductVersion());
			c.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
          
	}

}
