package br.sghvet.model;

public class Usuario {

	private String cpf;
	private TipoUsuario tipo;
	private CargoAdm cargo;

	public Usuario(String cpf, TipoUsuario tipo, CargoAdm cargo) {
		this.cpf = cpf;
		this.tipo = tipo;
		this.cargo = cargo;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public String getCpf() {
		return cpf;
	}
	
	public CargoAdm getCargo() {
		return cargo;
	}

	
	@Override
	public String toString() {
		
		return getCargo().toString();
	}
	
}
