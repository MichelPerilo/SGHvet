package br.sghvet.controller;

import java.sql.Connection;
import java.util.List;

import br.sghvet.data.IRepositorioCirurgia;
import br.sghvet.data.RepositorioCirurgia;
import br.sghvet.model.Cirurgia;


public class CadastroCirurgia implements ICadastroCirurgia {

private IRepositorioCirurgia repo;
	
	public CadastroCirurgia() {
		this.repo = new RepositorioCirurgia();
	}
	
	@Override
	public boolean cadastrarCirurgia(Cirurgia cirugia) throws Exception{
		return repo.cadastrarCirurgia(cirugia);
	}

	@Override
	public void conectar(Connection conect){
		repo.conectar(conect);
	}

	@Override
	public boolean removerCirurgia(Cirurgia cirurgia) throws Exception{
		return repo.removerCirurgia(cirurgia);
	}

	@Override
	public boolean atualizarCirurgia(Cirurgia cirurgia) throws Exception{
		return repo.atualizarCirurgia(cirurgia);
	}

	@Override
	public List<Cirurgia> buscarCirurgias(int prontuario_id) throws Exception{
		return repo.buscarCirurgias(prontuario_id);
	}

	@Override
	public List<Cirurgia> buscarALLCirurgia() throws Exception{
		return repo.buscarALLCirurgia();
	}

}
