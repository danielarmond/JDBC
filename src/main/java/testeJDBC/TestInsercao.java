package testeJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsercao {
	
	public static void main(String[] args) throws SQLException {
		
	ConnectionFactory connectionFactory = new ConnectionFactory();
	Connection connection = connectionFactory.recuperarConexao();
	
	
	Statement statement = connection.createStatement();
	statement.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('Mouse','Mouse sem fio')", Statement.RETURN_GENERATED_KEYS);
	
	ResultSet result = statement.getGeneratedKeys();
	while(result.next()){
		Integer id = result.getInt(1);
		System.out.println("O id criado foi: "+id);
	}
	
	}
}
