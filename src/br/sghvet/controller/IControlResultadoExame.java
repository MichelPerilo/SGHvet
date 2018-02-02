package br.sghvet.controller;

import java.sql.Connection;

import br.sghvet.model.ResultadoExame;
import br.sghvet.model.Consulta;
import br.sghvet.model.RequisicaoExame;

/**
 * IcontroleRegistroFunctionario
 */
public interface IControlResultadoExame {
     
    public ResultadoExame buscarRegistro(Consulta consulta) throws Exception;
	public boolean cadastrarRegistro(ResultadoExame registroConsulta) throws Exception;
	public boolean atualizarRegistro(ResultadoExame registroConsulta) throws Exception;     

    public void conectar(Connection conect);

}