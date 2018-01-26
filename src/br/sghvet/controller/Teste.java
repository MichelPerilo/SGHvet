package br.sghvet.controller;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import br.sghvet.facade.Fachada;
import br.sghvet.model.Administrativo;
import br.sghvet.model.Auxiliar;
import br.sghvet.model.DiaDaSemana;
import br.sghvet.model.Disponibilidade;
import br.sghvet.model.RequisicaoExame;
import br.sghvet.model.Veterinario;
import br.sghvet.controller.*;

public class Teste {

	public static void main(String[] args) throws Exception {

		Fachada.getInstance().loginUsuario("admsupremo", "abcd");
		
		Disponibilidade disp = new Disponibilidade(LocalTime.of(14, 30), LocalTime.of(19, 00), "22222222222", DiaDaSemana.QUARTA);
		Fachada.getInstance().deletarHorario(disp);;
		
	}

}
