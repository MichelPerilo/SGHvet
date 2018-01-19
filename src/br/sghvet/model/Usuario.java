package br.sghvet.model;

public class Usuario {

	private String cpf;
	private TipoUsuario tipo;


	public Usuario(String cpf, TipoUsuario tipo) {
		this.cpf = cpf;
		this.tipo = tipo;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public String getCpf() {
		return cpf;
	}
	
	

	
	
	
}
