package br.sghvet.controller;

import java.sql.Connection;
import java.util.List;

import br.sghvet.data.IRepositorioDisponibilidade;
import br.sghvet.data.RepositorioDisponibilidade;
import br.sghvet.model.Disponibilidade;

public class CadastroDisponibilidade {

	private IRepositorioDisponibilidade repo;

	public CadastroDisponibilidade() {
		this.repo = new RepositorioDisponibilidade();
	}
	
	public void conectar(Connection conect) {
		repo.conectar(conect);
	}
	
	public void cadastrarHorario(Disponibilidade disp) throws Exception {
		repo.cadastrarHorario(disp);
	}
	
	public List<Disponibilidade> buscaHorarios(String cpf_vet) throws Exception {
		return repo.buscaHorarios(cpf_vet);
	}
	
	public void atualizarHorario(Disponibilidade dispo) throws Exception{
		repo.atualizarHorario(dispo);
	}
	
	public void deletarHorario(Disponibilidade disp) throws Exception {
		repo.deletarHorario(disp);
	}

	public List<Disponibilidade> buscaDisponibilidade(String horario) throws Exception {
		return repo.buscaDisponibilidade(horario);
		
	}
}
