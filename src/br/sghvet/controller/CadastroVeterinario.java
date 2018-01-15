package br.sghvet.controller;

import java.sql.Connection;
import java.util.List;

import br.sghvet.data.IRepositorioVeterinario;
import br.sghvet.data.RepositorioVeterinario;
import br.sghvet.model.Veterinario;

public class CadastroVeterinario implements ICadastroVeterinario {

	private IRepositorioVeterinario repo;

	public CadastroVeterinario() {
		this.repo = new RepositorioVeterinario();
	}

	@Override
	public void conectar(Connection conect) {
		repo.conectar(conect);
	}

	@Override
	public Veterinario buscaVeterinario(String cpf) throws Exception {
		return repo.buscaVeterinario(cpf);
	}

	@Override
	public boolean cadastrarVeterinario(Veterinario vet) throws Exception {
		return repo.cadastrarVeterinario(vet);
	}

	@Override
	public boolean atualizarVeterinario(Veterinario vet) throws Exception {
		return repo.atualizarVeterinario(vet);
	}

	@Override
	public boolean deletarVeterinario(Veterinario vet) throws Exception {
		return repo.deletarVeterinario(vet);
	}

	@Override
	public List<Veterinario> buscaTodosVeterinario() throws Exception {
		return repo.buscaTodosVeterinario();
	}

}
