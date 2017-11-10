package br.sghvet.controller;

import java.sql.Connection;

import br.sghvet.data.IRepositorioUsuario;
import br.sghvet.data.RepositorioUsuario;
import br.sghvet.model.Usuario;

public class CadastroUsuario implements ICadastroUsuario {

	private IRepositorioUsuario repo;

	public CadastroUsuario() {
		this.repo = new RepositorioUsuario();
	}

	public void conectar(Connection conect) {
		repo.conectar(conect);
	}

	@Override
	public Usuario buscarUsuario(String cpf, String senha) throws Exception {
		return repo.buscaUsuario(cpf, senha);
	}

	@Override
	public boolean cadastrarUsuario(Usuario user) throws Exception {
		return repo.cadastrarUsuario(user);
	}

	@Override
	public boolean atualizarUsuario(Usuario user) throws Exception {
		return repo.atualizarUsuario(user);
	}

	@Override
	public boolean deletarUsuario(Usuario user) throws Exception {
		return repo.deletarUsuario(user);
	}

}
