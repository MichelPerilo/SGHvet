package br.sghvet.controller;

import br.sghvet.model.Endereco;
import br.sghvet.model.Tutor;

public class Teste {

	public static void main(String[] args) {
		IControlPaciente control = new ControlPaciente();
		control.conectar();
		Endereco e1 = new Endereco("rua teste", "bairro teste", "53310700", "912", "", "Olinda", "Pernambuco","10733725457");
		Tutor t1 = new Tutor("Nome teste", "10733725457", "M", "13133590", e1);
		try{
			control.cadastrarTutor(t1);
			//System.out.println(t1.getCpf());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
