package br.sghvet.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

import br.sghvet.data.IRepositorioConsulta;
import br.sghvet.data.RepositorioConsulta;
import br.sghvet.model.Consulta;

public class CadastroConsulta implements ICadastroConsulta{

	private IRepositorioConsulta repo;
	
	public CadastroConsulta() {
		this.repo = new RepositorioConsulta();
	}
	
	@Override
	public void conectar(Connection conect) {
		this.repo.conectar(conect);
	}
	
	@Override
	public boolean cadastrarConsulta(Consulta consulta) throws Exception {
		return repo.cadastrarConsulta(consulta);
	}

	@Override
	public boolean removerConsulta(Consulta consulta) throws Exception {
		return repo.removerConsulta(consulta);
	}

	@Override
	public boolean atualizarConsulta(Consulta consulta) throws Exception {
		return repo.atualizarConsulta(consulta);
	}

	@Override
	public List<Consulta> buscarConsultaCpf(String cpf) throws Exception {
		return repo.buscarConsultaCpf(cpf);
	}

	@Override
	public List<Consulta> buscarConsultaVet(String cpf) throws Exception {
		return repo.buscarConsultaVet(cpf);
	}

	@Override
	public List<Consulta> buscarConsultaPro(int prontuario) throws Exception {
		return repo.buscarConsultaPro(prontuario);
	}
	
	@Override
	public List<Consulta> buscarConsultasDoDia(String cpf, LocalDate data) throws Exception{
		return repo.buscarConsultasDoDia(cpf, data);
		
	}

	@Override
	public List buscarALLConsultas() throws Exception {
		
		return repo.buscarALLConsultas();
	}

	@Override
	public Consulta buscarConsultas(String cpf) throws Exception {
		
		return repo.buscarConsulta(cpf);
	}
	
	@Override
	public List<Consulta> buscarRelatorio1(LocalDate inicio, LocalDate fim, String cpf_tutor) throws Exception {
		
		return repo.buscarRelatorio1(inicio, fim, cpf_tutor);
		
	}
	@Override
	public List<Consulta> buscarRelatorio2(LocalDate inicio, LocalDate fim, String cpf_vet) throws Exception {
		
		return repo.buscarRelatorio2(inicio, fim, cpf_vet);
		
	}
	
	@Override
	public boolean atualizarSTATUSConsulta(Consulta consulta) throws Exception {
		
		
		return repo.atualizarSTATUSConsulta(consulta);		
	}


}
