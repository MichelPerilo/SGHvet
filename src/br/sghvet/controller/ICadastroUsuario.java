package br.sghvet.controller;

import java.sql.Connection;

import br.sghvet.model.Usuario;

public interface ICadastroUsuario {

	public Usuario buscarUsuario(String cpf) throws Exception;
	public boolean cadastrarUsuario(Usuario user, String senha) throws Exception;
	public boolean atualizarUsuario(Usuario user) throws Exception;
	public boolean deletarUsuario(Usuario user) throws Exception;
	public void conectar(Connection conect);
}
