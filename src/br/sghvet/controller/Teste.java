package br.sghvet.controller;

import java.util.List;

import br.sghvet.model.Animal;

public class Teste {

	public static void main(String[] args) {
		IControlPaciente control = new ControlPaciente();
		control.conectar();
		//Endereco e1 = new Endereco("rua teste", "bairro teste", "53310700", "912", "", "Olinda", "Pernambuco","10733725457");
		//Tutor t1 = new Tutor("Nome teste", "10733725457", "M", "13133590", e1);
		//Animal a1 = new Animal("ringo", "cachorro", "M", "3", "10733725457","yorkshire","pelo fofo","15.0");
		try{
			List<Animal> lista = control.buscarAnimal("10733725457");
			
			for (Animal animal : lista) {
				System.out.println(animal.getNome() + animal.getPeso());
			}
			control.deletarAnimal(lista.get(0));
			//lista.get(0).setNome("pingo");
			//control.atualizarAnimal(lista.get(0));
			//control.cadastrarTutor(t1);
			//control.cadastrarAnimal(a1);
			//System.out.println(t1.getCpf());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
