package br.sghvet.model;

import java.util.ArrayList;
import java.util.InputMismatchException;

import br.sghvet.controller.ValidadorCPF;

public class Tutor {

	// atributos

	private String nome;
	private String cpf;
	private String sexo;
	private String contato;
	private Endereco endereco;

	public Tutor(String nome, String cpf, String sexo, String contato, Endereco endereco) throws Exception {

		this.setNome(nome);
		this.setCpf(cpf);
		this.setSexo(sexo);
		this.setContato(contato);
		this.setEndereço(endereco);

	}

	public Tutor(String nome, String cpf, String sexo, String contato) throws Exception {

		this.setNome(nome);
		this.setCpf(cpf);
		this.setSexo(sexo);
		this.setContato(contato);

	}

	// metodos

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if ((nome != null))
			this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws Exception {

		if (ValidadorCPF.getInstance().validarCPF(cpf))
			this.cpf = cpf;
		else
			throw new Exception("Cpf invalido");

	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		if (sexo != null)
			this.sexo = sexo;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String telefone) {
		if (telefone != null)
			this.contato = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereço(Endereco endereço) {
		this.endereco = endereço;
	}

	@Override
	public String toString() {
		return "\n\nNOME: " + nome + "\nCPF: " + cpf + "\nSEXO: " + sexo + "  TELEFONE: " + contato + endereco;
	}

}
