package py.edu.ucsa.jdbc.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.edu.ucsa.jdbc.conections.DBConnector;

public class FuncionarioDAO {
	public void crearTabla() {
		try {
			Connection c = DBConnector.getConexion();
			Statement s = c.createStatement();
			String createStmt = "create table funcionarios " +  
					"( legajo    integer, " +
					"nombre    varchar(50), " +
					"  direccion varchar(200) , " +
					"  cedula integer , " +
					"  celular varchar(50) , " +
					"  email    varchar(50) " +
					" ) ";
			s.executeUpdate(createStmt);
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listarFuncionarios() {
		String query = "SELECT * FROM funcionarios";
		List<Funcionario> lista = new ArrayList<>();
		Connection c;
		try {
			c = DBConnector.getConexion();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(query);
			Funcionario f = null;
			while(rs.next()) {
				f = new Funcionario();
				f.setApellido(rs.getString("apellido"));
				f.setNombre(rs.getString("nombre"));
				lista.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return lista;
	}
	
	public static void main(String[] args) {
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.crearTabla();
	}
}
