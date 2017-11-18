package br.sghvet.model;

public class Animal {

	private String nome;
	private String especie;
	private String raca;
	private String pelagem;
	private String peso;
	private String cpfTutor;
	private String sexo;
	private String idade;
	private int numProntuario;

	public Animal(String nome, String especie, String sexo, String idade, String cpftutor, String raca, String pelagem,
			String peso) {

		setNome(nome);
		setEspecie(especie);
		setSexo(sexo);
		setIdade(idade);
		setCpfTutor(cpftutor);
		setRaça(raca);
		setPelagem(pelagem);
		setPeso(peso);
	}

	public String getCpfTutor() {
		return cpfTutor;
	}

	public void setCpfTutor(String cpfTutor) {
		this.cpfTutor = cpfTutor;
	}

	public String getRaça() {
		return raca;
	}

	public void setRaça(String raca) {

		if (raca != null && !raca.equals(""))
			this.raca = raca;
	}

	public String getPelagem() {
		return pelagem;
	}

	public void setPelagem(String pelagem) {

		if (pelagem != null && !pelagem.equals(""))
			this.pelagem = pelagem;
	}

	public Double getPeso() {
		if (peso != null) {
			return Double.parseDouble(peso);
		} else
			return null;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null && !nome.equals(""))
			this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		if (especie != null && !especie.equals(""))
			this.especie = especie;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		if (sexo != null && !sexo.equals(""))
			this.sexo = sexo;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {

		if (idade != null && !idade.equals(""))
			this.idade = idade;
	}

	public int getNumProntuario() {
		return numProntuario;
	}

	public void setNumProntuario(int numProntuario) {

		this.numProntuario = numProntuario;
	}

}
