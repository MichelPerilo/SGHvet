package br.sghvet.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class RequisicaoExame {

	private int id;
	private LocalDate data;
	private String cpfTutor;
	private int prontuario;
	private String cpfVeterinario;
	private boolean realizado;

	public RequisicaoExame(LocalDate data, String cpfTutor, int prontuario, String cpfVeterinario, boolean realizado) {
		this.data = data;
		this.cpfTutor = cpfTutor;
		this.prontuario = prontuario;
		this.cpfVeterinario = cpfVeterinario;
		this.realizado = realizado;
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

	public String getCpfTutor() {
		return cpfTutor;
	}

	public int getProntuario() {
		return prontuario;
	}

	public String getCpfVeterinario() {
		return cpfVeterinario;
	}

	public boolean getRealizado() {
		return realizado;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setCpfTutor(String cpfTutor) {
		this.cpfTutor = cpfTutor;
	}

	public void setProntuario(int prontuario) {
		this.prontuario = prontuario;
	}

	public void setCpfVeterinario(String cpfVeterinario) {
		this.cpfVeterinario = cpfVeterinario;
	}

	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}

}
