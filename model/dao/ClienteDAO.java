package model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.bean.Cliente;
import connection.ConnectionFactory;


public class ClienteDAO {

	public void create(Cliente cliente){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("INSERT INTO Cliente (cpf, telefone, nomeCli, email)VALUES(?,?,?,?)");
			stmt.setInt(1, cliente.getCpf());
			stmt.setInt(2, cliente.getTelefone());
			stmt.setString(3, cliente.getNomeCli());
			stmt.setString(4, cliente.getEmail());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao salvar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
	
}
