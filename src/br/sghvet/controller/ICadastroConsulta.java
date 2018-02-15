package br.sghvet.controller;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import br.sghvet.model.Consulta;

public interface ICadastroConsulta {
	
	public boolean cadastrarConsulta(Consulta consulta) throws Exception;
	public boolean removerConsulta(Consulta consulta) throws Exception;
	public boolean atualizarConsulta(Consulta consulta) throws Exception;
	public List<Consulta> buscarConsultaCpf(String cpf) throws Exception;
	public List<Consulta> buscarConsultaVet(String cpf) throws Exception;
	public List<Consulta> buscarConsultaPro(int prontuario) throws Exception;
	public List<Consulta> buscarConsultasDoDia(String cpf, LocalDate data) throws Exception;
	
	public void conectar(Connection conect);
	public List buscarALLConsultas()throws Exception;
	public Consulta buscarConsultas(String cpf) throws Exception;
	boolean atualizarSTATUSConsulta(Consulta consulta) throws Exception;
	List<Consulta> buscarRelatorio1(LocalDate inicio, LocalDate fim, String cpf_tutor) throws Exception;
}
