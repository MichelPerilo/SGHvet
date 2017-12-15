package br.sghvet.controller;

import java.sql.Connection;

import br.sghvet.model.TipoUsuario;

public interface IControleLogin {
	
	public TipoUsuario loginUsuario(String cpf, String senha) throws Exception;
	public Connection getConexao();

}
