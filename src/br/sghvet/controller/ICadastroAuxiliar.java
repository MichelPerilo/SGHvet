package br.sghvet.controller;

import java.sql.Connection;

import br.sghvet.model.Auxiliar;

public interface ICadastroAuxiliar {

	public Auxiliar buscaAuxiliar(String cpf) throws Exception;
	public boolean cadastrarAuxiliar(Auxiliar aux) throws Exception;
	public boolean atualizarAuxiliar(Auxiliar aux) throws Exception;
	public boolean deletarAuxiliar(Auxiliar aux)throws Exception;
	public void conectar(Connection conect);
}
