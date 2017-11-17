package br.sghvet.controller;

import java.sql.Connection;

import br.sghvet.data.IRepositorioTutor;
import br.sghvet.data.RepositorioTutor;
import br.sghvet.model.Tutor;



public class CadastroTutor implements ICadastroTutor {
	
private IRepositorioTutor repo;
	
	
	public CadastroTutor(){
		this.repo = new RepositorioTutor();
	}
	
	@Override
	public void conectar(Connection conect) {
		repo.conectar(conect);
	}
	
	@Override
	public Tutor buscaTutor(String cpf) throws Exception {
		return repo.buscaTutor(cpf);
	}

	@Override
	public boolean cadastraTutor(Tutor tutor) throws Exception {
		return repo.cadastraTutor(tutor);
	}

	@Override
	public boolean atualizaTutor(Tutor tutor) throws Exception {
		return repo.atualizaTutor(tutor);
	}

	@Override
	public boolean deletarTutor(Tutor tutor) throws Exception {
		return repo.deletarTutor(tutor);
	}

	
	
}
