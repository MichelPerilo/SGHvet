package br.sghvet.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private String projeto = "jdbc:mysql://localhost:3306/sghvet";

	public Connection getConexao(String usuario, String senha) throws Exception {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(projeto, usuario, senha);

		} catch (SQLException | ClassNotFoundException e) {
			throw e;
		}
}
}
