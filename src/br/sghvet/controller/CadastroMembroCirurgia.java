package br.sghvet.controller;

import java.sql.Connection;
import java.util.List;

import br.sghvet.data.IRepositorioCirurgia;
import br.sghvet.data.IRepositorioMembroCirurgia;
import br.sghvet.data.RepositorioCirurgia;
import br.sghvet.data.RepositorioMembroCirurgia;
import br.sghvet.model.Cirurgia;
import br.sghvet.model.MembroCirurgia;


public class CadastroMembroCirurgia implements ICadastroMembroCirurgia {

private IRepositorioMembroCirurgia repo;
	
	public CadastroMembroCirurgia() {
		this.repo = new RepositorioMembroCirurgia();
	}
	
	@Override
	public boolean cadastrarMembroCirurgia(MembroCirurgia membro) throws Exception{
		return repo.cadastrarMembroCirurgia(membro);
	}

	@Override
	public void conectar(Connection conect){
		repo.conectar(conect);
	}

	@Override
	public boolean removerMembroCirurgia(MembroCirurgia membro) throws Exception{
		return repo.removerMembroCirurgia(membro);
	}

	@Override
	public boolean atualizarMembroCirurgia(MembroCirurgia membro) throws Exception{
		return repo.atualizarMembroCirurgia(membro);
	}

	@Override
	public List<MembroCirurgia> buscarMembros(int cirurgia_id) throws Exception{
		return repo.buscarMembros(cirurgia_id);
	}

	@Override
	public List<MembroCirurgia> buscarCirurgias(String cpf_membro) throws Exception{
		return repo.buscarCirurgias(cpf_membro);
	}

}
