package br.sghvet.data;

import java.sql.Connection;

import br.sghvet.model.Consulta;
import br.sghvet.model.RequisicaoExame;
import br.sghvet.model.ResultadoExame;

public interface IRepositorioResultadoExame {
	
	public void conectar(Connection conect);
	
	public boolean CadastrarRegistro(ResultadoExame registro) throws Exception;
	public boolean atualizarRegistro(ResultadoExame registro) throws Exception;
	public ResultadoExame buscarRegistro(Consulta consulta) throws Exception;
	

}
