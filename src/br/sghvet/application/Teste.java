package br.sghvet.application;

import java.time.LocalDate;

import br.sghvet.controller.ControlFuncionario;
import br.sghvet.controller.ControleLogin;
import br.sghvet.controller.IControlFuncionario;
import br.sghvet.controller.IControleLogin;
import br.sghvet.model.Auxiliar;
import br.sghvet.model.CargoAuxiliar;
import br.sghvet.model.TipoUsuario;
import br.sghvet.model.Usuario;

public class Teste {

	public static void main(String[] args) {
		
		try {
			IControleLogin cl = new ControleLogin();
			System.out.println(cl.loginUsuario("12332111232", "abcd").toString());
			
	//		IControlFuncionario control = new ControlFuncionario();
	//		control.conectar();
	//		Usuario user = new Usuario("11111111111111", "teste", TipoUsuario.VETERINARIO);
			//Veterinario vet = new Veterinario("jose", "11111111111111", LocalDate.of(1980, 1, 10), CargoVeterinario.MEDICO,
			//		"12345678901", "email@teste.com", "12345");
			//control.cadastrarVeterinario(user, vet);
			//control.atualizarVeterinario(vet);
			//control.deletarVeterinario(vet);
			//Administrativo adm = new Administrativo("joao", "11111111111111", LocalDate.of(1980, 1, 10), CargoAdm.ATENDENTE,
			//		"12345678901", "email@teste.com");
			//control.cadastraAdm(user, adm);
			//control.atualizaAdm(adm);
			//control.deletarAdm(adm);
	//		Auxiliar aux = new Auxiliar("Maria", "31111111111111", LocalDate.of(1980, 1, 10), CargoAuxiliar.LABORATORIO,
	//						"12345678901", "email@teste.com");
			//control.cadastrarAuxiliar(user, aux);
			//control.atualizarAuxiliar(aux);
	//		control.cadastrarAuxiliar(user, aux);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}