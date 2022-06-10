package testeJDBC;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory criaconexao = new ConnectionFactory();
		Connection connection = criaconexao.recuperarConexao();
		
		System.out.println("Fechando conexão");
		
		connection.close();
	}
	
}
