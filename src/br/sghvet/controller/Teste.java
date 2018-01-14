package br.sghvet.controller;

import java.sql.Connection;
import java.time.LocalDate;

import br.sghvet.facade.Fachada;
import br.sghvet.model.RequisicaoExame;
import br.sghvet.controller.*;

public class Teste {

	public static void main(String[] args) throws Exception {

		Connection conect = new Conexao().getConexao("root", "");
		
		Fachada.getInstance().conectar(conect);
		
		//new CadastroReqExame().conectar(conect);
		
		RequisicaoExame buscaReqExame = Fachada.getInstance().buscaReqExame(2);
		
		Fachada.getInstance().gerarPdfRequisicao(buscaReqExame);
		
//		RequisicaoExame req = new RequisicaoExame(LocalDate.of(2018, 2, 10), "11111111111", 1, "22222222222", false);
//		
//		Fachada.getInstance().cadastraReqExame(req);
		
	}

}
