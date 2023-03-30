package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entities.Cliente;
import factories.ConnectionFactory;

public class ClienteRepository {

	//método para receber e cadastrar um cliente no banco de dados
	public void create(Cliente cliente) throws Exception {
		
		//abrindo conexão com o banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		//escrevendo um comando em linguagem SQL para inserir um cliente no banco de dados
		PreparedStatement statement = connection.prepareStatement("insert into cliente(nome, email, telefone, cpf) values(?,?,?,?)");
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getTelefone());
		statement.setString(4, cliente.getCpf());
		statement.execute();
		
		//fechando a conexão
		connection.close();
	}		
}
