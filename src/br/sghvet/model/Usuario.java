package br.sghvet.model;

import br.sghvet.controller.ValidadorCPF;

public class Usuario {

	private String cpf;
	private TipoUsuario tipo;


	public Usuario(String cpf, TipoUsuario tipo) throws Exception {
		setCpf(cpf);
		this.tipo = tipo;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setCpf(String cpf) throws Exception {
		if(ValidadorCPF.getInstance().validarCPF(cpf)) {
			this.cpf = cpf;
		}else
			throw new Exception("Cpf invalido");
	}

	public String getCpf() {
		return cpf;
	}
	
	

	
	
	
}
