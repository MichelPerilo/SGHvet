package br.sghvet.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import br.sghvet.data.IRepositorioUsuario;
import br.sghvet.data.RepositorioUsuario;
import br.sghvet.model.TipoUsuario;

public class ControleLogin implements IControleLogin{

	private IRepositorioUsuario repo;

	public ControleLogin() {
		this.repo = new RepositorioUsuario();
	}

	private Connection conect = null;

	// encriptar em MD5
	private String encrypt(String senha) throws NoSuchAlgorithmException {
		String encrypted = null;
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(senha.getBytes(), 0, senha.length());
		encrypted = new BigInteger(1, md.digest()).toString();

		return encrypted;
	}

	// recebe login e senha, manda iniciar a conexao
	private void fazerConexao(String CPF, String senha) throws Exception {
		String senhaCrypt = encrypt(senha);
		conect = new Conexao().getConexao(CPF, senhaCrypt);
	}

	// processo de login e recuperar tipo para interface de usuario
	public TipoUsuario loginUsuario(String cpf, String senha) throws Exception {
		fazerConexao(cpf, senha);
		repo.conectar(conect);
		return repo.buscaUsuario(cpf).getTipo();
	}
	
	//Connection a ser passada entre os controles durante a sessao do usuario
	public Connection getConexao() {
		return conect;
	}

}
