package br.sghvet.data;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.sghvet.controller.Conexao;
import br.sghvet.model.CargoAdm;
import br.sghvet.model.TipoUsuario;
import br.sghvet.model.Usuario;

public class RepositorioUsuario implements IRepositorioUsuario {

	private static Connection connection;

	@Override
	public void conectar(Connection conect) {
			RepositorioUsuario.connection = conect;
	}

	@Override
	public Usuario buscaUsuario(String cpf) throws Exception {
		String query = "SELECT * FROM usuario WHERE cpf='" + cpf + "';";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		rs.next();
		if (rs.getString("tipo").equals("VETERINARIO")) {
			return new Usuario(rs.getString("cpf"), TipoUsuario.VETERINARIO);
		} else if (rs.getString("tipo").equals("ADMINISTRATIVO")) {
						
			return new Usuario(rs.getString("cpf"), TipoUsuario.ADMINISTRATIVO);

		} else {
			return new Usuario(rs.getString("cpf"), TipoUsuario.AUXILIAR);
		}
	}

	@Override
	public boolean cadastrarUsuario(Usuario user, String senha) throws Exception {
		String query = "INSERT INTO usuario (cpf, tipo) values ('"+user.getCpf()+"','"+user.getTipo().toString()+"');";
		PreparedStatement ps = connection.prepareStatement(query);
		if (!executar(ps)) {
			query = "CREATE USER IF NOT EXISTS '" + user.getCpf() + "'@'" + new Conexao().getHost()
					+ "' IDENTIFIED BY '" + encrypt(senha) + "';";
			ps = connection.prepareStatement(query);
			return !executar(ps);
		}

		// falha no cadastro
		return false;
	}

	@Override
	public boolean atualizarUsuario(Usuario user) throws Exception {
		String query = "UPDATE usuario SET tipo = '" + user.getTipo().toString() + "' WHERE cpf = '" + user.getCpf()
				+ "';";

		PreparedStatement ps = connection.prepareStatement(query);
		return !executar(ps);
	}

	@Override
	public boolean deletarUsuario(Usuario user) throws Exception {
		String query = "DELETE FROM usuario WHERE cpf = '" + user.getCpf() + "';";

		PreparedStatement ps = connection.prepareStatement(query);
		if(!executar(ps)) {
			query = "DROP USER '"+user.getCpf()+"'@'"+new Conexao().getHost()+"';";
			ps = connection.prepareStatement(query);
			return !executar(ps);
		}
		return false;
	}

	private boolean executar(PreparedStatement ps) throws Exception {
		boolean result;

		if (ps.execute())
			result = true;
		else
			result = false;

		ps.close();
		return result;
	}

	// encriptar em MD5
	private String encrypt(String senha) throws NoSuchAlgorithmException {
		String encrypted = null;
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(senha.getBytes(), 0, senha.length());
		encrypted = new BigInteger(1, md.digest()).toString();

		return encrypted;
	}

}
