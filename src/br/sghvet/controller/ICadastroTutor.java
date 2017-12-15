package br.sghvet.controller;

import java.sql.Connection;
import java.util.List;

import br.sghvet.model.Endereco;
import br.sghvet.model.Tutor;


public interface ICadastroTutor {
	
	public Tutor buscaTutor(String cpf) throws Exception;
	public List buscarALLTutor() throws Exception;
	public boolean cadastrarTutor(Tutor tutor) throws Exception;
	public boolean atualizaTutor(Tutor tutor) throws Exception;
	public boolean deletarTutor(Tutor tutor) throws Exception;
	public Endereco buscaEndereco(String cpf) throws Exception;
	public boolean cadastraEndereco(Endereco e1) throws Exception;
	public boolean atualizarEndereco(Endereco e1) throws Exception;
	public boolean deletarEndereco(Endereco e1) throws Exception;
	public void conectar(Connection conect);

}
