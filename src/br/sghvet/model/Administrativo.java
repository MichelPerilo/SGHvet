package br.sghvet.model;

import java.time.LocalDate;

public class Administrativo {

	private String nome;
	private String cpf;
	private LocalDate dataNasc;
	private CargoAdm cargo;
	private String contato;
	private String email;

	public Administrativo(String nome, String cpf, LocalDate dataNasc, CargoAdm cargo, String contato, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.cargo = cargo;
		this.contato = contato;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public CargoAdm getCargo() {
		return cargo;
	}

	public String getContato() {
		return contato;
	}

	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString(){
		String dados = this.getNome() + " - " + this.cpf + " - " + this.getEmail();
		
		return dados;
	}

	
}
