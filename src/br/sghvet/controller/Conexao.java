package br.sghvet.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exceptions.ConectionException;

public class Conexao {

	private String projeto = "jdbc:mysql://localhost:3306/sghvet";

	public Connection getConexao(String usuario, String senha) throws ConectionException {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			return DriverManager.getConnection(projeto, usuario, senha);

		} catch (Exception e) {
			throw new ConectionException();
		}
}
}
