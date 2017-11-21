package br.sghvet.model;

import java.io.Serializable;

import java.io.Serializable;

public class Endereco implements Serializable {

	// atributos

	private String logradouro;
	private String bairro;
	private String cep;
	private String numero;
	private String complemento;
	private String cidade;
	private String estado;
	private String CpfTutor;
	

	public Endereco(String logradouro, String bairro, String cep, String numero, String complemento, String cidade,
			String estado, String cpfTutor) {

		this.setLogradouro(logradouro);
		this.setBairro(bairro);
		this.setCep(cep);
		this.setNumero(numero);
		this.setComplemento(complemento);
		this.setCidade(cidade);
		this.setEstado(estado);
		this.setCpfTutor(cpfTutor);
		
	}

	// metodos

	

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		if (logradouro != null)
			this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		if (bairro != null)
			this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		if (cep != null)
			this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		if (numero != null)
			this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		if (complemento != null)
			this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		if (cidade != null)
			this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		if (estado != null)
			this.estado = estado;
	}

	@Override
	public String toString() {
		return "\nLOFRADOURO: " + logradouro + "  BAIRRO: " + bairro + "\nCEP: " + cep + "  NUMERO: " + numero
				+ "  COMPLEMENTO: " + complemento + "\nCIDADE: " + cidade + "  ESTADO: " + estado;
	}

	public String getCpfTutor() {
		return CpfTutor;
	}

	public void setCpfTutor(String cpfTutor) {
		CpfTutor = cpfTutor;
	}

}