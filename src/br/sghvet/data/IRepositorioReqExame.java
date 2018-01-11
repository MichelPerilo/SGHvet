package br.sghvet.data;

import java.sql.Connection;
import java.util.List;

import br.sghvet.model.RequisicaoExame;

public interface IRepositorioReqExame {

	public RequisicaoExame buscaReqExame(int id) throws Exception;
	public List<RequisicaoExame> buscaReqExameCPF(String cpf) throws Exception;
	public List<RequisicaoExame> buscaReqExameVet(String cpf_vet) throws Exception;
	public List<RequisicaoExame> buscaReqExameProntuario(int id) throws Exception;
	public boolean cadastraReqExame(RequisicaoExame e) throws Exception;
	public boolean atualizaReqExame(RequisicaoExame e) throws Exception;
	public boolean deletarReqExame(int id) throws Exception;
	public void conectar(Connection conect);
}
