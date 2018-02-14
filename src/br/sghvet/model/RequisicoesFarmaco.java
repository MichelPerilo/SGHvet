package br.sghvet.model;

public class RequisicoesFarmaco {
	
	private int id;
	private int qtd;
	private String descricao;
	private String Justificativa;
	private String JustificativaNegacao;
	
	public RequisicoesFarmaco(int qtd, String descri, String just) {
		
		setQtd(qtd);
		setDescricao(descri);
		setJustificativa(just);
		
		
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
	
	
	
	

}
