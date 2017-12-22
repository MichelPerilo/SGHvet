package br.sghvet.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {
	
	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
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

	private int id;
	
	private LocalDate dia;
	private LocalTime horario;
	private String cpfTutor;
	private int prontuario;
	private String cpfVeterinario;
	
	public Consulta(LocalDate dia, LocalTime horario, String cpfTutor, int prontuario, String cpfVeterinario) {
		this.dia = dia;
		this.horario = horario;
		this.cpfTutor = cpfTutor;
		this.prontuario = prontuario;
		this.cpfVeterinario = cpfVeterinario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDia() {
		return dia;
	}

	public LocalTime getHorario() {
		return horario;
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
	
	
	
}
