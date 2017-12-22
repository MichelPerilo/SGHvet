package br.sghvet.controller;

import java.sql.Connection;

import br.sghvet.model.TipoUsuario;
import br.sghvet.model.Usuario;

public interface IControleLogin {
	
	public Usuario loginUsuario(String cpf, String senha) throws Exception;
	public Connection getConexao();

}
