package br.sghvet.controller;

import java.sql.Connection;
import java.util.List;

import br.sghvet.data.IRepositorioAnimal;
import br.sghvet.data.RepositorioAnimal;
import br.sghvet.model.Animal;


public class CadastroAnimal implements ICadastroAnimal {

	private IRepositorioAnimal repo;
	
	public CadastroAnimal(){
		this.repo = new RepositorioAnimal();
	}
	
	@Override
	public void conectar(Connection conect) {
		repo.conectar(conect);
	}

	@Override
	public boolean cadastrarAnimal(Animal a) throws Exception {
		return repo.cadastrarAnimal(a);
	}

	@Override
	public boolean atualizarAnimal(Animal a) throws Exception {
		return repo.atualizarAnimal(a);
	}

	@Override
	public boolean deletarAnimal(Animal a) throws Exception {
		return repo.deletarAnimal(a);
	}

	@Override
	public List buscarAnimal(String cpfTutor) throws Exception {
		return repo.buscarAnimal(cpfTutor);
	}

	@Override
	public Animal buscaAnimal(int prontuario) throws Exception {
		return repo.buscarAnimalProntuario(prontuario);
	}
	
	
	
}
