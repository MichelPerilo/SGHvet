package br.sghvet.model;

import java.time.LocalDate;

import br.sghvet.controller.ValidadorCPF;

public class Administrativo {

	private String nome;
	private String cpf;
	private LocalDate dataNasc;
	private CargoAdm cargo;
	private String contato;
	private String email;

	public Administrativo(String nome, String cpf, LocalDate dataNasc, CargoAdm cargo, String contato, String email) throws Exception {
		this.nome = nome;
		setCpf(cpf);
		this.dataNasc = dataNasc;
		this.cargo = cargo;
		this.contato = contato;
		this.email = email;
	}

	public void setCpf(String cpf) throws Exception {
		if(ValidadorCPF.getInstance().validarCPF(cpf)) {
			this.cpf = cpf;
		}else
			throw new Exception("Cpf invalido");
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
	public String toString() {
		String dados = this.getNome() + " - " + this.cpf + " - " + this.getEmail();

		return dados;
	}

}
