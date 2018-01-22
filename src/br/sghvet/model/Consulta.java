package br.sghvet.model;

import java.time.LocalDate;
import java.time.LocalTime;

import br.sghvet.facade.Fachada;

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
	private String nomeTutor;
	private String nomeAnimal;
	private String nomeMedico;
	
	public Consulta(LocalDate dia, LocalTime horario, String cpfTutor, int prontuario, String cpfVeterinario) throws Exception {
		this.dia = dia;
		this.horario = horario;
		this.cpfTutor = cpfTutor;
		this.prontuario = prontuario;
		this.cpfVeterinario = cpfVeterinario;
		this.setNomeTutor(getCpfTutor());
		this.setNomeAnimal(getProntuario());
		this.setNomeMedico(getCpfVeterinario());
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

	public String getNomeTutor() {
		return nomeTutor;
	}

	public void setNomeTutor(String nomeTutor) throws Exception {
		this.nomeTutor = Fachada.getInstance().buscarTutor(nomeTutor).getNome();
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(int nomeAnimal) throws Exception {
		this.nomeAnimal = Fachada.getInstance().buscaAnimalProntuario(nomeAnimal).getNome();
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) throws Exception {
		
		this.nomeMedico = Fachada.getInstance().buscaVeterinario(nomeMedico).getNome();
	}
	
	
	
}
