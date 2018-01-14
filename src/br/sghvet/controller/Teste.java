package br.sghvet.controller;

import java.time.LocalDate;
import java.util.List;

import br.sghvet.facade.Fachada;
import br.sghvet.model.Animal;
import br.sghvet.model.Endereco;
import br.sghvet.model.RequisicaoExame;
import br.sghvet.model.Tutor;
import exceptions.ConectionException;

public class Teste {

	public static void main(String[] args) throws Exception {

		Fachada.getInstance().conectar();
		
		RequisicaoExame req = new RequisicaoExame(LocalDate.of(2018, 2, 10), "11111111111", 1, "22222222222", false);
		
		Fachada.getInstance().cadastraReqExame(req);
		
	}

}
