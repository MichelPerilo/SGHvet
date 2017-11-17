package br.sghvet.data;

import java.sql.Connection;
import br.sghvet.model.Tutor;


public interface IRepositorioTutor {
	
	public Tutor buscaTutor(String cpf) throws Exception;
	public boolean cadastraTutor(Tutor tutor) throws Exception;
	public boolean atualizaTutor(Tutor tutor) throws Exception;
	public boolean deletarTutor(Tutor tutor) throws Exception;
	public void conectar(Connection conect);

}
