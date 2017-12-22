package br.sghvet.controller;

import java.sql.Connection;

import br.sghvet.data.IRepositorioAuxiliar;
import br.sghvet.data.RepositorioAuxiliar;
import br.sghvet.model.Auxiliar;

public class CadastroAuxiliar implements ICadastroAuxiliar{

	private IRepositorioAuxiliar repo;
	
	public CadastroAuxiliar(){
		this.repo = new RepositorioAuxiliar();
	}
	
	@Override
	public void conectar(Connection conect) {
		repo.conectar(conect);
	}
	
	@Override
	public Auxiliar buscaAuxiliar(String cpf) throws Exception {
		return repo.buscaAuxiliar(cpf);
	}

	@Override
	public boolean cadastrarAuxiliar(Auxiliar aux) throws Exception {
		return repo.cadastrarAuxiliar(aux);
	}

	@Override
	public boolean atualizarAuxiliar(Auxiliar aux) throws Exception {
		return repo.atualizarAuxiliar(aux);
	}

	@Override
	public boolean deletarAuxiliar(Auxiliar aux) throws Exception {
		return repo.deletarAuxiliar(aux);
	}


	
}
