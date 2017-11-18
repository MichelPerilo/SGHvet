package br.sghvet.model;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Tutor {

	// atributos

	private String nome;
	private String cpf;
	private String sexo;
	private String contato;
	private Endereco endereco;

	public Tutor(String nome, String cpf, String sexo, String contato, Endereco endereco) {

		this.setNome(nome);
		this.setCpf(cpf);
		this.setSexo(sexo);
		this.setContato(contato);
		this.setEndereço(endereco);

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

	public void setCpf(String cpf) {

		if (this.validarCPF(cpf) == true)
			this.cpf = cpf;

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
		if (endereço != null)
			this.endereco = endereço;
	}

	public boolean validarCPF(String numeroCPF) {

		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (numeroCPF.equals("00000000000") || numeroCPF.equals("11111111111") || numeroCPF.equals("22222222222")
				|| numeroCPF.equals("33333333333") || numeroCPF.equals("44444444444") || numeroCPF.equals("55555555555")
				|| numeroCPF.equals("66666666666") || numeroCPF.equals("77777777777") || numeroCPF.equals("88888888888")
				|| numeroCPF.equals("99999999999") || (numeroCPF.length() != 11))
			return (false);
		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) { //
				// converte o i-esimo caractere do CPF em um numero: por
				// exemplo,
				// transforma o caractere '0' no inteiro 0 (48 eh a
				// posicao de '0' na tabela ASCII)
				num = (int) (numeroCPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);
			// converte no respectivo caractere numerico
			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (numeroCPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);
			// Verifica se os digitos calculados
			// conferem com os digitos informados.
			if ((dig10 == numeroCPF.charAt(9)) && (dig11 == numeroCPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}

	}

	@Override
	public String toString() {
		return "\n\nNOME: " + nome + "\nCPF: " + cpf + "\nSEXO: " + sexo + "  TELEFONE: " + contato + endereco;
	}

}
