package br.sghvet.model;

public class MembroCirurgia {
	
	/*
		id INT(11) AUTO_INCREMENT,
	  	id_cirur INT(11) NOT NULL,
	  	cpf_membro char(11) NOT NULL,
	 */
	
	private int id;
	private int cirurgia_id;
	private String membro_cpf;
	
	public MembroCirurgia(int cirurgia_id, String membro_cpf){
		
		this.setCirurgia_id(cirurgia_id);
		this.setMembro_cpf(membro_cpf);
	}

	public int getCirurgia_id() {
		return cirurgia_id;
	}

	private void setCirurgia_id(int cirurgia_id) {
		this.cirurgia_id = cirurgia_id;
	}

	public String getMembro_cpf() {
		return membro_cpf;
	}

	private void setMembro_cpf(String membro_cpf) {
		this.membro_cpf = membro_cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
