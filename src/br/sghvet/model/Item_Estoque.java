package br.sghvet.model;

import java.time.LocalDate;


public class Item_Estoque {
	
	private int id_intem_estoque;
	private LocalDate data_entrada;
	private LocalDate data_validade;
	private int qtd_atual;
	private int codigo_remedio_ie;
	private String nome;
	private String tipo;
	
	
	public Item_Estoque(LocalDate dv, int qtd, int cr) {
		
		
		setData_validade(dv);
		setQtd_atual(qtd);
		setCodigo_remedio_ie(cr);
	
					
		
	}
	
	
	public void logCadastro() {
		data_entrada = LocalDate.now();
	}


	public int getId_intem_estoque() {
		return id_intem_estoque;
	}


	public void setId_intem_estoque(int id_intem_estoque) {
		this.id_intem_estoque = id_intem_estoque;
	}


	public int getCodigo_remedio_ie() {
		return codigo_remedio_ie;
	}


	public void setCodigo_remedio_ie(int codigo_remedio_ie) {
		this.codigo_remedio_ie = codigo_remedio_ie;
	}


	public LocalDate getData_validade() {
		return data_validade;
	}


	public void setData_validade(LocalDate data_validade) {
		this.data_validade = data_validade;
	}


	public LocalDate getData_entrada() {
		return data_entrada;
	}

	public void setData_entrada(LocalDate ld) {
		data_entrada = ld;
	}

	
	public int getQtd_atual() {
		return qtd_atual;
	}


	public void setQtd_atual(int qtd_atual) {
		this.qtd_atual = qtd_atual;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		
      		this.nome = nome;
      				
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
