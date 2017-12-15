package br.sghvet.controller;

import java.time.LocalDate;

import br.sghvet.model.Administrativo;
import br.sghvet.model.CargoAdm;
import br.sghvet.model.TipoUsuario;
import br.sghvet.model.Usuario;

public class ControleCadastro {
	
	
	
	//chamados dependendo do tipo de usuario selecionado no cadastro
	
	public void cadastrarAdm(String nome, String cpf, LocalDate dataNasc, CargoAdm cargo, String contato, String email, String senha) {
		
		Administrativo adm = new Administrativo(nome, cpf, dataNasc, cargo, contato, email);
		Usuario user = new Usuario(cpf, TipoUsuario.ADMINISTRATIVO);
		
		//a fazer
	}
	
	public void cadastrarVet() {
		//a fazer
	}
	
	public void cadastrarAux() {
		//a fazer
	}

}
