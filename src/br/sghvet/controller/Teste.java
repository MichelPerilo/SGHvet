package br.sghvet.controller;

import java.util.List;

import br.sghvet.model.Animal;
import br.sghvet.model.Endereco;
import br.sghvet.model.Tutor;

public class Teste {

	public static void main(String[] args) {
		IControlPaciente control = new ControlPaciente();
		
//		Endereco e1 = new Endereco("rua teste", "bairro teste", "53310700", "912", "", "Olinda", "Pernambuco","10103566406");
//		Tutor t1 = new Tutor("Nome teste333", "10103566406", "M", "13133590", e1);
//		Animal a1 = new Animal("Rex", "cachorro", "M", "3", "10733725457","yorkshire","pelo fofo","15.0");
		
		try{
			Tutor t1 = control.buscarTutor("41646752333");
			System.out.println(t1.getNome());
			
//			control.cadastrarAnimal(a1);
//			List<Tutor> lista = control.buscarALLTutor();
//			
//			for (Tutor tutor : lista) {
//				System.out.println(tutor.getNome() + "  " + tutor.getCpf() + "  "+tutor.getContato() + "  "+ tutor.getSexo());
//			}
			//System.out.println(t1.getCpf());
			//control.deletarAnimal(lista.get(0));
			//lista.get(0).setNome("pingo");
			//control.atualizarAnimal(lista.get(0));
			//control.cadastrarTutor(t1);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
