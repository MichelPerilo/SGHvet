package br.sghvet.model;

import br.sghvet.facade.Fachada;

public class RequisicoesFarmaco {
	
	private int id;
	private int qtd;
	private String descricao;
	private String Justificativa;
	private String JustificativaNegacao;
	private String id_medico;
	private String nomeMedico;
	private int atendido;
	
	public RequisicoesFarmaco(int qtd, String descri, String just,String id_medico) {
		
		setQtd(qtd);
		setDescricao(descri);
		setJustificativa(just);
		setId_medico(id_medico);
			
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getJustificativa() {
		return Justificativa;
	}

	public void setJustificativa(String justificativa) {
		Justificativa = justificativa;
	}

	public String getJustificativaNegacao() {
		return JustificativaNegacao;
	}

	public void setJustificativaNegacao(String justificativaNegacao) {
		JustificativaNegacao = justificativaNegacao;
	}

	public String getId_medico() {
		return id_medico;
	}

	public void setId_medico(String id_medico) {
		this.id_medico = id_medico;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
	
			this.nomeMedico = nomeMedico;
	
	}

	public int getAtendido() {
		return atendido;
	}

	public void setAtendido(int atendido) {
		this.atendido = atendido;
	}
	
	
	
	

}
