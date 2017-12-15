package br.sghvet.controller;

import java.sql.Connection;

import br.sghvet.model.Administrativo;

public interface ICadastroAdm {

	public Administrativo buscaAdm(String cpf) throws Exception;
	public boolean cadastraAdm(Administrativo adm) throws Exception;
	public boolean atualizaAdm(Administrativo adm) throws Exception;
	public boolean deletarAdm(Administrativo adm) throws Exception;
	public void conectar(Connection conect);
}
