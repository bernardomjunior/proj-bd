package connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ConnectionFactory {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/celular";
	private static final String USER = "root";
	private static final String PASS = "";
	
	public static Connection getConnection (){
		//Connection --> tutorial
			
			try {
				Class.forName(DRIVER);
				//return DriverManager.getConnection(URL, USER, PASS); --> tutorial
				return (Connection) DriverManager.getConnection(URL, USER, PASS); //--> meu jeito
						
			} catch (ClassNotFoundException | SQLException ex) {
				throw new RuntimeException("Erro na conex�o: ",ex);
			}
	}
	
	
	public static void closeConnection(Connection connection){
		
		try {
			if (connection != null){
				connection.close();
			}	
		}catch (SQLException ex) {
			throw new RuntimeException("N�o foi poss�vel encerrar a conex�o - ",ex);
		}
		
	}
	
	
	//verificar se o PreparedStatement � do jdbc ou do java
	public static void closeConnection(java.sql.Connection connection, java.sql.PreparedStatement stmt){
			closeConnection((Connection) connection);
			
			try {
				if (stmt != null){
					stmt.close();
				}	
			}catch (SQLException ex) {
				throw new RuntimeException("N�o foi poss�vel encerrar a conex�o - ",ex);
			}
			
		}
	
	
	public static void closeConnection(Connection connection, PreparedStatement stmt, ResultSet resultset){
		closeConnection(connection, stmt);
		
		try {
			if (resultset != null){
				resultset.close();
			}	
		}catch (SQLException ex) {
			throw new RuntimeException("N�o foi poss�vel encerrar a conex�o - ",ex);
		}
		
	}
	
	
}
