package br.sghvet.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cirurgia {
	
	/*
		  tipo enum('GERAL', 'ESPECISLISTA') not null,
		  especialidade varchar(60), 
		  data_cir date NOT NULL,
		  hr_fim time,
		  sala enum('SALA_A', 'SALA_B', 'SALA_C', 'SALA_D' , 'SALA_E') NOT NULL,
		  hr_inic time NOT NULL,
		  prontuario INT(11) NOT NULL,
	 */
	
	private int id;
	private TipoCirurgia tipo; 
	private String especialidade;
	private LocalDate data;
	private LocalTime hora_inicio;
	private LocalTime hora_fim;
	private SalaDeCirurgia sala;
	private int prontuario_id;

	public Cirurgia(TipoCirurgia tipo, String especialidade, LocalDate data, LocalTime hora_inicio, LocalTime hora_fim, SalaDeCirurgia sala, int prontuario){
		
		this.setTipo(tipo);
		this.setEspecialidade(especialidade);
		this.setData(data);
		this.setHora_inicio(hora_inicio);
		this.setHora_fim(hora_fim);
		this.setSala(sala);
		this.setProntuario_id(prontuario);
	}

	public TipoCirurgia getTipo() {
		return tipo;
	}

	private void setTipo(TipoCirurgia tipo) {
		this.tipo = tipo;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	private void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public LocalDate getData() {
		return data;
	}

	private void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora_inicio() {
		return hora_inicio;
	}

	private void setHora_inicio(LocalTime hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public LocalTime getHora_fim() {
		return hora_fim;
	}

	private void setHora_fim(LocalTime hora_fim) {
		this.hora_fim = hora_fim;
	}

	public SalaDeCirurgia getSala() {
		return sala;
	}

	private void setSala(SalaDeCirurgia sala) {
		this.sala = sala;
	}

	public int getProntuario_id() {
		return prontuario_id;
	}

	private void setProntuario_id(int prontuario_id) {
		this.prontuario_id = prontuario_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	

}
