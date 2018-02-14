package br.sghvet.model;

import java.time.LocalTime;

public class Disponibilidade {

	private LocalTime horarioInicio;
	private LocalTime horarioFinal;
	private String cpfVet;
	private DiaDaSemana dia;

	public Disponibilidade(LocalTime horarioInicio, LocalTime horarioFinal, String cpfVet, DiaDaSemana dia) {
		this.horarioInicio = horarioInicio;
		this.horarioFinal = horarioFinal;
		this.cpfVet = cpfVet;
		this.dia = dia;
	}

	public DiaDaSemana getDia() {
		return dia;
	}

	public void setDia(DiaDaSemana dia) {
		this.dia = dia;
	}

	public LocalTime getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(LocalTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public LocalTime getHorarioFinal() {
		return horarioFinal;
	}

	public void setHorarioFinal(LocalTime horarioFinal) {
		this.horarioFinal = horarioFinal;
	}

	public String getCpfVet() {
		return cpfVet;
	}

	public void setCpfVet(String cpfVet) {
		this.cpfVet = cpfVet;
	}
	
	@Override
	public String toString(){
		String result = this.getDia().toString() + ":   ------------------ das " + this.getHorarioInicio()+ " horas até as " + this.getHorarioFinal() + " horas ";
		
		return result;
	}

}
