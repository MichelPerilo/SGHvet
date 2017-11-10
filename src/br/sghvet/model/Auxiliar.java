package br.sghvet.model;

import java.time.LocalDate;

public class Auxiliar {

	private String nome;
	private String cpf;
	private LocalDate dataNasc;
	private CargoAuxiliar cargo;
	private String contato;
	private String email;

	public Auxiliar(String nome, String cpf, LocalDate dataNasc, CargoAuxiliar cargo, String contato, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.cargo = cargo;
		this.contato = contato;
		this.email = email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public void setCargo(CargoAuxiliar cargo) {
		this.cargo = cargo;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
