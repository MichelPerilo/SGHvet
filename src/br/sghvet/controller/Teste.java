package br.sghvet.controller;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import br.sghvet.facade.Fachada;
import br.sghvet.model.Administrativo;
import br.sghvet.model.Auxiliar;
import br.sghvet.model.RequisicaoExame;
import br.sghvet.model.Veterinario;
import br.sghvet.controller.*;

public class Teste {

	public static void main(String[] args) throws Exception {

		Fachada.getInstance().loginUsuario("admsupremo", "abcd");
		
		List<Administrativo> buscaTodosAdm = Fachada.getInstance().buscaTodosAdm();
		
		List<Auxiliar> buscaTodosAuxiliar = Fachada.getInstance().buscaTodosAuxiliar();
		
		List<Veterinario> buscaTodosVeterinario = Fachada.getInstance().buscaTodosVeterinario();
		
		System.out.println(buscaTodosAdm.size() + " Adms");
		System.out.println(buscaTodosAuxiliar.size() + " Auxiliares");
		System.out.println(buscaTodosVeterinario.size() + " Veterinarios");
		
		System.out.println(buscaTodosAdm.get(0).getNome());
		System.out.println(buscaTodosVeterinario.get(0).getNome());
		System.out.println(Fachada.getInstance().buscaAdm("admsupremo").getNome());
	}

}
