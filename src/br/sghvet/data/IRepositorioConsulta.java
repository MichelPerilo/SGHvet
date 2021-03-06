package br.sghvet.data;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import br.sghvet.model.Consulta;

public interface IRepositorioConsulta {
	
	public boolean cadastrarConsulta(Consulta consulta) throws Exception;
	public boolean removerConsulta(Consulta consulta) throws Exception;
	public boolean atualizarConsulta(Consulta consulta) throws Exception;
	public List<Consulta> buscarConsultaCpf(String cpf) throws Exception;
	public List<Consulta> buscarConsultaVet(String cpf) throws Exception;
	public List<Consulta> buscarConsultaPro(int prontuario) throws Exception;
	public List<Consulta> buscarConsultasDoDia(String cpf, LocalDate data) throws Exception;
	
	
	public void conectar(Connection conect);
	public List<Consulta> buscarALLConsultas() throws Exception;
	public Consulta buscarConsulta(String cpf) throws Exception;

}
