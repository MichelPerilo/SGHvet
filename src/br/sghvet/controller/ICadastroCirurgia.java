package br.sghvet.controller;

import java.sql.Connection;
import java.util.List;

import br.sghvet.model.Cirurgia;

public interface ICadastroCirurgia {

	boolean cadastrarCirurgia(Cirurgia cirugia) throws Exception;

	void conectar(Connection conect);

	boolean removerCirurgia(Cirurgia cirurgia) throws Exception;

	boolean atualizarCirurgia(Cirurgia cirurgia) throws Exception;

	List<Cirurgia> buscarCirurgias(int prontuario_id) throws Exception;

	List<Cirurgia> buscarALLCirurgia() throws Exception;

}
