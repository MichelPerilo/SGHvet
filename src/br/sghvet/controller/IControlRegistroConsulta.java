package br.sghvet.controller;

import java.sql.Connection;

import br.sghvet.model.RegistroConsulta;
import br.sghvet.model.Consulta;

/**
 * IcontroleRegistroFunctionario
 */
public interface IControlRegistroConsulta {
     
    public RegistroConsulta buscarRegistro(Consulta consulta) throws Exception;
	public boolean cadastrarRegistro(RegistroConsulta registroConsulta) throws Exception;
	public boolean atualizarRegistro(RegistroConsulta registroConsulta) throws Exception;     

    public void conectar(Connection conect);

}