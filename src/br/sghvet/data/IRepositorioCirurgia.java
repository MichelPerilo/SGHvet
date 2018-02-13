package br.sghvet.data;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import br.sghvet.model.Cirurgia;
import br.sghvet.model.Consulta;
import br.sghvet.model.MembroCirurgia;

public interface IRepositorioCirurgia {

	boolean cadastrarCirurgia(Cirurgia cirugia) throws Exception;

	void conectar(Connection conect);

	boolean removerCirurgia(Cirurgia cirurgia) throws Exception;

	boolean atualizarCirurgia(Cirurgia cirurgia) throws Exception;

	List<Cirurgia> buscarCirurgias(int prontuario_id) throws Exception;

	List<Cirurgia> buscarALLCirurgia() throws Exception;



	
}
