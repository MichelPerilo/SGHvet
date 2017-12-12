package br.sghvet.data;

import java.sql.Connection;
import java.util.List;

import br.sghvet.model.Consulta;

public interface IRepositorioConsulta {
	
	public boolean cadastrarConsulta(Consulta consulta) throws Exception;
	public boolean removerConsulta(Consulta consulta) throws Exception;
	public boolean atualizarConsulta(Consulta consulta) throws Exception;
	public List<Consulta> buscarConsultaCpf(String cpf) throws Exception;
	public List<Consulta> buscarConsultaVet(String cpf) throws Exception;
	public List<Consulta> buscarConsultaPro(int prontuario) throws Exception;
	
	public void conectar(Connection conect);

}
