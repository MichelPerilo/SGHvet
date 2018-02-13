package br.sghvet.controller;

import java.sql.Connection;
import java.util.List;

import br.sghvet.model.MembroCirurgia;

public interface ICadastroMembroCirurgia {

	boolean cadastrarMembroCirurgia(MembroCirurgia membro) throws Exception;

	void conectar(Connection conect);

	boolean removerMembroCirurgia(MembroCirurgia membro) throws Exception;

	boolean atualizarMembroCirurgia(MembroCirurgia membro) throws Exception;

	List<MembroCirurgia> buscarMembros(int cirurgia_id) throws Exception;

	List<MembroCirurgia> buscarCirurgias(String cpf_membro) throws Exception;

}