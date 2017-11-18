package br.sghvet.model;

public class Animal {

	private String nome;
	private String especie;
	private String raça;
	private String pelagem;
	private String peso;
	private Tutor tutor;
	private String sexo;
	private String idade;
	private String numProntuario;

	public Animal(String numeProntuario, String nome, String especie, String sexo, String idade) {

		setNome(nome);
		setEspecie(especie);
		setSexo(sexo);
		setIdade(idade);
		setNumProntuario(numeProntuario);

	}

	public String getRaça() {
		return raça;
	}

	public void setRaça(String raça) {

		if (raça != null && !raça.equals(""))
			this.raça = raça;
	}

	public String getPelagem() {
		return pelagem;
	}

	public void setPelagem(String pelagem) {

		if (pelagem != null && !pelagem.equals(""))
			this.pelagem = pelagem;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {

		if (peso != null && !peso.equals(""))
			this.peso = peso;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {

		if (tutor != null)
			this.tutor = tutor;
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

	public String getNumProntuario() {
		return numProntuario;
	}

	public void setNumProntuario(String numProntuario) {

		if (numProntuario != null && !numProntuario.equals(""))
			this.numProntuario = numProntuario;
	}

}
