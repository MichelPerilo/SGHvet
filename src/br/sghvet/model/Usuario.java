package br.sghvet.model;

import br.sghvet.controller.ValidadorCPF;

public class Usuario {

	private String cpf;
	private TipoUsuario tipo;

	public Usuario(String cpf, TipoUsuario tipo) {
		setCpf(cpf);
		this.tipo = tipo;
	}

	public void setCpf(String cpf) {
		if (ValidadorCPF.getInstance().validarCPF(cpf))
			this.cpf = cpf;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public String getCpf() {
		return cpf;
	}

}
