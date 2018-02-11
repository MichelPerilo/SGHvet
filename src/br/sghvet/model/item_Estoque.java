package br.sghvet.model;

import java.time.LocalDate;


public class item_Estoque {
	
	private int id_intem_estoque;
	private LocalDate data_entrada;
	private LocalDate data_validade;
	private int qtd_atual;
	private int codigo_remedio_ie;
	private String nome;
	
	
	public item_Estoque(LocalDate dv, int qtd, int cr) {
		
		data_entrada = LocalDate.now();
		setData_validade(dv);
		setQtd_atual(qtd);
		setCodigo_remedio_ie(cr);
		setNome(cr);
					
		
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


	
	public int getQtd_atual() {
		return qtd_atual;
	}


	public void setQtd_atual(int qtd_atual) {
		this.qtd_atual = qtd_atual;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(int cr) {
		
//		realizar uma busca pelo nome e setar na variavel fazer deppois que terminar o repositorio de farmaco		
		
	}
	
	
	
	
}
