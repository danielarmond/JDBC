package testeJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {

			connection.setAutoCommit(false);

			try (PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
				adicionarVariavel("SmarTV", "45 polegadas", statement);
				adicionarVariavel("Radio", "Radio de bateria", statement);

				connection.commit();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
		}

	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement statement)
			throws SQLException {
		statement.setString(1, nome);
		statement.setString(2, descricao);

		statement.execute();

		try (ResultSet result = statement.getGeneratedKeys()) {
			while (result.next()) {
				Integer id = result.getInt(1);
				System.out.println("O id criado foi: " + id);
			}
		}

	}

}
