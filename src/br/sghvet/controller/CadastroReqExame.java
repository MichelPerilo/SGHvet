package br.sghvet.controller;

import java.sql.Connection;
import java.util.List;

import br.sghvet.data.IRepositorioReqExame;
import br.sghvet.data.RepositorioReqExame;
import br.sghvet.model.RequisicaoExame;

public class CadastroReqExame {

	private IRepositorioReqExame repo;

	public CadastroReqExame() {
		this.repo = new RepositorioReqExame();
	}

	public void conectar(Connection conect) {
		repo.conectar(conect);
	}

	public RequisicaoExame buscaReqExame(int id) throws Exception {
		return repo.buscaReqExame(id);
	}

	public List<RequisicaoExame> buscaReqExameCPF(int prontuario) throws Exception {
		return repo.buscaReqExameCPF(prontuario);
	}

	public List<RequisicaoExame> buscaReqExameVet(String cpf_vet) throws Exception {
		return repo.buscaReqExameVet(cpf_vet);
	}

	public List<RequisicaoExame> buscaReqExameProntuario(int id) throws Exception {
		return repo.buscaReqExameProntuario(id);
	}

	public boolean cadastraReqExame(RequisicaoExame e) throws Exception {
		return repo.cadastraReqExame(e);
	}

	public boolean atualizaReqExame(RequisicaoExame e) throws Exception {
		return repo.atualizaReqExame(e);
	}

	public boolean deletarReqExame(RequisicaoExame r1) throws Exception {
		return repo.deletarReqExame(r1);
	}
	
	public List<RequisicaoExame> buscarALLExameLab() throws Exception{
		return repo.buscarALLExameLab();
	}
	
	public List<RequisicaoExame> buscarALLExameImagem() throws Exception{
		return repo.buscarALLExameImagem();
	}

}
