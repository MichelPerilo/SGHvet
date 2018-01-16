package br.sghvet.controller;

import java.sql.Connection;
import java.util.List;

import br.sghvet.model.Administrativo;

public interface ICadastroAdm {

	public Administrativo buscaAdm(String cpf) throws Exception;
	public boolean cadastraAdm(Administrativo adm) throws Exception;
	public boolean atualizaAdm(Administrativo adm) throws Exception;
	public boolean deletarAdm(Administrativo adm) throws Exception;
	public void conectar(Connection conect);
	public List<Administrativo> buscaTodosAdm()throws Exception;
}
