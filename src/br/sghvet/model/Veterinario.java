package br.sghvet.model;
import java.time.LocalDate;

public class Veterinario {

	private String nome;
	private String cpf;
	private LocalDate dataNasc;
	private CargoVeterinario cargo;
	private String contato;
	private String email;
	private String crmv;

	public Veterinario(String nome, String cpf, LocalDate dataNasc, CargoVeterinario cargo, String contato,
			String email, String crmv) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.cargo = cargo;
		this.contato = contato;
		this.email = email;
		this.crmv = crmv;
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
