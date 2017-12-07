package br.sghvet.controller;

import java.sql.Connection;
import java.util.List;

import br.sghvet.data.IRepositorioTutor;
import br.sghvet.data.RepositorioTutor;
import br.sghvet.model.Endereco;
import br.sghvet.model.Tutor;

public class CadastroTutor implements ICadastroTutor {

	private IRepositorioTutor repo;

	public CadastroTutor() {
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
	public List buscarALLTutor()throws Exception{
		return repo.buscarALLTutor();
	}

	@Override
	public boolean cadastrarTutor(Tutor tutor) throws Exception {
		return repo.cadastrarTutor(tutor);
	}

	@Override
	public boolean atualizaTutor(Tutor tutor) throws Exception {
		return repo.atualizaTutor(tutor);
	}

	@Override
	public boolean deletarTutor(Tutor tutor) throws Exception {
		return repo.deletarTutor(tutor);
	}

	@Override
	public boolean cadastraEndereco(Endereco e1) throws Exception {
		return repo.cadastrarEndereco(e1);
	}

	@Override
	public boolean atualizarEndereco(Endereco e1) throws Exception {
		return repo.atualizarEndereco(e1);
	}

	@Override
	public Endereco buscaEndereco(String cpf) throws Exception {
		return repo.buscaEndereco(cpf);
	}

	@Override
	public boolean deletarEndereco(Endereco e1) throws Exception {
		return repo.deletarEndereco(e1);
	}

}
