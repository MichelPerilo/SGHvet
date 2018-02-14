package br.sghvet.controller;

import java.sql.Connection;
import br.sghvet.data.RepositorioRequisicaoFarmaco;
import br.sghvet.model.RequisicoesFarmaco;
public class CadastroRequisicaoFarmaco {
	
	
	
	private RepositorioRequisicaoFarmaco repo;

	public CadastroRequisicaoFarmaco() {
		this.repo = new RepositorioRequisicaoFarmaco();
	}

	public void conectar(Connection conect) {
		repo.conectar(conect);
	}

	
	public boolean cadastraReqFarmaco(RequisicoesFarmaco rf) throws Exception {
		
	
		return repo.cadastraReqFarmaco(rf);
	}

	
	public RequisicoesFarmaco buscaReqFarmaco(int id) throws Exception {

	
		return repo.buscaReqFarmaco(id);
	}


	public boolean atualizaReqFarmaco(RequisicoesFarmaco req) throws Exception {
	
		return repo.atualizaReqFarmaco(req);
	}

	
	
	public boolean atualizaReqFarmacoJustificativa(RequisicoesFarmaco req) throws Exception {
		

		return repo.atualizaReqFarmacoJustificativa(req);
	}
	
	
	public boolean deletarReqFarmaco(int id) throws Exception {
		

		return repo.deletarReqFarmaco(id);
	}

}
