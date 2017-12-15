package br.sghvet.controller;

import java.sql.Connection;

import br.sghvet.data.IRepositorioAdm;
import br.sghvet.data.RepositorioAdm;
import br.sghvet.model.Administrativo;

public class CadastroAdm implements ICadastroAdm{

	private IRepositorioAdm repo;
	
	
	public CadastroAdm(){
		this.repo = new RepositorioAdm();
	}
	
	@Override
	public void conectar(Connection conect) {
		repo.conectar(conect);
	}
	
	@Override
	public Administrativo buscaAdm(String cpf) throws Exception {
		return repo.buscaAdm(cpf);
	}

	@Override
	public boolean cadastraAdm(Administrativo adm) throws Exception {
		return repo.cadastraAdm(adm);
	}

	@Override
	public boolean atualizaAdm(Administrativo adm) throws Exception {
		return repo.atualizaAdm(adm);
	}

	@Override
	public boolean deletarAdm(Administrativo adm) throws Exception {
		return repo.deletarAdm(adm);
	}


}
