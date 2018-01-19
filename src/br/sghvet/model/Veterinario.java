package br.sghvet.model;
import java.time.LocalDate;

import br.sghvet.controller.ValidadorCPF;

public class Veterinario {

	private String nome;
	private String cpf;
	private LocalDate dataNasc;
	private CargoVeterinario cargo;
	private String contato;
	private String email;
	private String crmv;

	public Veterinario(String nome, String cpf, LocalDate dataNasc, CargoVeterinario cargo, String contato,
			String email, String crmv) throws Exception {
		this.nome = nome;
		setCpf(cpf);
		this.dataNasc = dataNasc;
		this.cargo = cargo;
		this.contato = contato;
		this.email = email;
		this.crmv = crmv;
	}

	public void setCpf(String cpf) throws Exception {
		if (ValidadorCPF.getInstance().validarCPF(cpf))
			this.cpf = cpf;
		else throw new Exception("Cpf invalido");
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

	public CargoVeterinario getCargo() {
		return cargo;
	}

	public String getContato() {
		return contato;
	}

	public String getEmail() {
		return email;
	}

	public String getCrmv() {
		return crmv;
	}

	@Override
	public String toString(){
		String dados = this.getNome() + " - " + this.cpf + " - " + this.getEmail();
		
		return dados;
	}
	
}
