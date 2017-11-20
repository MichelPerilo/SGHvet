package br.sghvet.data;

import java.sql.Connection;

import br.sghvet.model.Usuario;

public interface IRepositorioUsuario {

	public Usuario buscaUsuario(String cpf) throws Exception; // Login
	public boolean cadastrarUsuario(Usuario user, String senha) throws Exception;
	public boolean atualizarUsuario(Usuario user) throws Exception;
	public boolean deletarUsuario(Usuario user) throws Exception;
	public void conectar(Connection conect);
	
}
