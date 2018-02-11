package br.sghvet.data;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import br.sghvet.model.Disponibilidade;

public interface IRepositorioDisponibilidade {

	public void conectar(Connection conect);
	void cadastrarHorario(Disponibilidade disp) throws Exception;
	void atualizarHorario(Disponibilidade dispo) throws Exception;
	List<Disponibilidade> buscaHorarios(String cpf_vet) throws Exception;
	void deletarHorario(Disponibilidade dispo)throws Exception;
	List<Disponibilidade> buscaDisponibilidade(String horario, LocalDate dia) throws Exception;
}
