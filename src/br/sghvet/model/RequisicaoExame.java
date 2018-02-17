package br.sghvet.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class RequisicaoExame {

	private int id;
	private TipoExame tipo;
	private String natureza;
	private String observacoes;
	private int prontuario;
	private LocalTime hora;
	private LocalDate data;
	private String cpf_vet;
	private boolean realizado;

	public RequisicaoExame(TipoExame tipo, String natureza, String observacoes, int prontuario, LocalTime hora, LocalDate data, String cpf_vet,boolean realizado) {
		this.data = data;
		this.tipo = tipo;
		this.observacoes = observacoes;
		this.hora = hora;
		this.natureza = natureza;
		this.prontuario = prontuario;
		this.realizado = realizado;
		this.setCpf_vet(cpf_vet);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}


	public int getProntuario() {
		return prontuario;
	}


	public boolean getRealizado() {
		return realizado;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	

	public void setProntuario(int prontuario) {
		this.prontuario = prontuario;
	}


	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}

	public LocalTime getHora() {
		return hora;
	}

	private void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getObservacoes() {
		return observacoes;
	}

	private void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getNatureza() {
		return natureza;
	}

	private void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	public TipoExame getTipo() {
		return tipo;
	}

	private void setTipo(TipoExame tipo) {
		this.tipo = tipo;
	}

	public String getCpf_vet() {
		return cpf_vet;
	}

	private void setCpf_vet(String cpf_vet) {
		this.cpf_vet = cpf_vet;
	}

}
