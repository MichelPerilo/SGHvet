package br.sghvet.data;

import java.sql.Connection;
import java.util.List;

import br.sghvet.model.Endereco;
import br.sghvet.model.Tutor;


public interface IRepositorioTutor {
	
	public Tutor buscaTutor(String cpf) throws Exception;
	public List buscarALLTutor() throws Exception;
	public boolean cadastrarTutor(Tutor tutor) throws Exception;
	public boolean atualizaTutor(Tutor tutor) throws Exception;
	public boolean deletarTutor(Tutor tutor) throws Exception;
	public void conectar(Connection conect);

	public boolean cadastrarEndereco(Endereco end) throws Exception;
	public Endereco buscaEndereco(String cpf) throws Exception;
	public boolean atualizarEndereco(Endereco end) throws Exception;
	public boolean deletarEndereco(Endereco end) throws Exception;
}
