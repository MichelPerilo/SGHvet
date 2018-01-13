package br.sghvet.data;

import java.sql.Connection;

import br.sghvet.model.Consulta;
import br.sghvet.model.RegistroConsulta;

public interface IRepositorioRegistroConsulta {
	
	public void conectar(Connection conect);
	
	public boolean CadastrarRegistro(RegistroConsulta registro) throws Exception;
	public boolean atualizarRegistro(RegistroConsulta registro) throws Exception;
	public RegistroConsulta buscarRegistro(Consulta consulta) throws Exception;
	

}
