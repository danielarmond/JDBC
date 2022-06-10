package testeJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory criaconexao = new ConnectionFactory();
		Connection connection = criaconexao.recuperarConexao();
		
		PreparedStatement statement = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		statement.execute();
		
		ResultSet result = statement.getResultSet();
		
		while(result.next()) {
			Integer id = result.getInt("id");
			System.out.println(id);
			String nome = result.getString("nome");
			System.out.println(nome);
			String descricao = result.getString("descricao");
			System.out.println(descricao);
		}
		
	
		connection.close();

	}

}
