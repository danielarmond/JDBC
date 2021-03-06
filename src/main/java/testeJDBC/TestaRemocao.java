package testeJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		
		PreparedStatement statement = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?", Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, 4);
		
		statement.execute();
		
		Integer linhasModificadas = statement.getUpdateCount();
	
	System.out.println("Quantidades de linhas modificadas: "+linhasModificadas);
	}
}
