package br.sghvet.model;

public class Usuario {

	private String cpf;
	private String senha;
	private TipoUsuario tipo;

	public Usuario(String cpf, String senha, TipoUsuario tipo) {
		this.cpf = cpf;
		this.senha = senha;
		this.tipo = tipo;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public String getCpf() {
		return cpf;
	}

	public String getSenha() {
		return senha;
	}

	
}
