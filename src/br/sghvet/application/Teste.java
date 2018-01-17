package br.sghvet.application;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

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
		//
		// try {
		//// IControleLogin cl = new ControleLogin();
		//// System.out.println(cl.loginUsuario("12332111232", "abcd").toString());
		//
		// // IControlFuncionario control = new ControlFuncionario();
		// // control.conectar();
		// // Usuario user = new Usuario("11111111111111", "teste",
		// TipoUsuario.VETERINARIO);
		// //Veterinario vet = new Veterinario("jose", "11111111111111",
		// LocalDate.of(1980, 1, 10), CargoVeterinario.MEDICO,
		// // "12345678901", "email@teste.com", "12345");
		// //control.cadastrarVeterinario(user, vet);
		// //control.atualizarVeterinario(vet);
		// //control.deletarVeterinario(vet);
		// //Administrativo adm = new Administrativo("joao", "11111111111111",
		// LocalDate.of(1980, 1, 10), CargoAdm.ATENDENTE,
		// // "12345678901", "email@teste.com");
		// //control.cadastraAdm(user, adm);
		// //control.atualizaAdm(adm);
		// //control.deletarAdm(adm);
		// // Auxiliar aux = new Auxiliar("Maria", "31111111111111", LocalDate.of(1980,
		// 1, 10), CargoAuxiliar.LABORATORIO,
		// // "12345678901", "email@teste.com");
		// //control.cadastrarAuxiliar(user, aux);
		// //control.atualizarAuxiliar(aux);
		// // control.cadastrarAuxiliar(user, aux);
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		 Calendar c = new GregorianCalendar();
		 System.out.println("Primeiro dia do mes: " +
		 c.getActualMinimum(Calendar.DAY_OF_MONTH));
		 System.out.println("Ultimo dia do mes: " +
		 c.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		 // Calendar cal = Calendar.getInstance();
		 // int diaSemana = cal.get(Calendar.DAY_OF_WEEK); //aqui você já possui o  número
		 // do dia da semana
		 // Aqui você pega o texto do dia da semana
		 DateFormatSymbols symbols = new DateFormatSymbols();
		 String[] nomeDia = symbols.getWeekdays();
		 System.out.println(nomeDia[c.getActualMinimum(Calendar.DAY_OF_MONTH)+6]);


//		int DiaSem;
//		int Bissex;
//		int mes;
//		int dia;
//		int aux;
//		Scanner input = new Scanner(System.in);
//		do {
//			System.out.println(" Entre com o dia da semana do primeiro dia do ano");
//			DiaSem = input.nextInt();
//		} while ((DiaSem < 0) || (DiaSem > 7));
//		do {
//			System.out.println("O ano é bissexto? (0 para não e 1 para sim)");
//			Bissex = input.nextInt();
//		} while ((Bissex != 0) && (Bissex != 1));
//		aux = 0;
//		for (mes = 1; mes <= 12; mes++) {
//			System.out.println();
//			System.out.println();
//			switch (mes) {
//			case 1:
//				System.out.println("Janeiro");
//				break;
//			case 2:
//				System.out.println("Fevereiro");
//				break;
//			case 3:
//				System.out.println("Março");
//				break;
//			case 4:
//				System.out.println("Abril");
//				break;
//			case 5:
//				System.out.println("Maio");
//				break;
//			case 6:
//				System.out.println("Junho");
//				break;
//			case 7:
//				System.out.println("Julho");
//				break;
//			case 8:
//				System.out.println("Agosto");
//				break;
//			case 9:
//				System.out.println("Setembro");
//				break;
//			case 10:
//				System.out.println("Outubro");
//				break;
//			case 11:
//				System.out.println("Novembro");
//				break;
//			case 12:
//				System.out.println("Dezembro");
//				break;
//			}
//			System.out.println("\n\n   Dom  Seg  Ter  Qua  Qui  Sex  Sab");
//			switch (mes) {
//			case 1:
//				aux = 31;
//				break;
//			case 2:
//				if (Bissex == 0) {
//					aux = 28;
//				} else {
//					aux = 29;
//				}
//				break;
//			case 3:
//				aux = 31;
//				break;
//			case 4:
//				aux = 30;
//				break;
//			case 5:
//				aux = 31;
//				break;
//			case 6:
//				aux = 30;
//				break;
//			case 7:
//				aux = 31;
//				break;
//			case 8:
//				aux = 31;
//				break;
//			case 9:
//				aux = 30;
//				break;
//			case 10:
//				aux = 31;
//				break;
//			case 11:
//				aux = 30;
//				break;
//			case 12:
//				aux = 31;
//				break;
//			}
//			int aux1 = 1;
//
//			String esp = "";
//			switch (DiaSem) {
//			case 1:
//
//				break;
//			case 2:
//				esp += "     ";
//				break;
//			case 3:
//				esp += "          ";
//				break;
//			case 4:
//				esp += "               ";
//				break;
//			case 5:
//				esp += "                    ";
//				break;
//			case 6:
//				esp += "                         ";
//				break;
//			case 7:
//				esp += "                              ";
//				break;
//			}
//
//			System.out.print(esp);
//
//			for (dia = 1; dia <= aux; dia++) {
//				String dias = "";
//				if (dia == aux1++) {
//					switch (DiaSem) {
//					case 1:
//						if (dia > 9) {
//							dias += "   " + dia;
//						} else {
//							dias += "    " + dia;
//						}
//
//						break;
//					case 2:
//						if (dia > 9) {
//							dias += "   " + dia;
//						} else {
//							dias += "    " + dia;
//						}
//
//						break;
//					case 3:
//						if (dia > 9) {
//							dias += "   " + dia;
//						} else {
//							dias += "    " + dia;
//						}
//
//						break;
//					case 4:
//						if (dia > 9) {
//							dias += "   " + dia;
//						} else {
//							dias += "    " + dia;
//						}
//
//						break;
//					case 5:
//						if (dia > 9) {
//							dias += "   " + dia;
//						} else {
//							dias += "    " + dia;
//						}
//						break;
//					case 6:
//						if (dia > 9) {
//							dias += "  " + dia;
//						} else {
//							dias += "    " + dia;
//						}
//
//						break;
//					case 7:
//						if (dia > 9) {
//							dias += "   " + dia;
//						} else {
//							dias += "    " + dia;
//						}
//
//						break;
//					}
//					System.out.print(dias);
//
//					DiaSem = DiaSem + 1;
//					if (DiaSem > 7) {
//						DiaSem = 1;
//						System.out.println();
//					}
//
//				}
//
//			}
//		}
	}
}
