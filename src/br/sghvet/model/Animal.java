package br.sghvet.model;

public class Animal {

	private static long geraProntuario = 0000000; 
	private long numProntuario;
	private String nome;
	private String especie;
	private String raca;
	private String pelagem;
	private Double peso;	
	private String sexo;
	private int idade;
	private String cpfTutor;
	

	public Animal(String nome, String especie, String sexo, int idade, String cpftutor, String raca, String pelagem,
			Double peso) {

		setNome(nome);
		setEspecie(especie);
		setSexo(sexo);
		setIdade(idade);
		setCpfTutor(cpftutor);
		setRaça(raca);
		setPelagem(pelagem);
		setPeso(peso);
		this.numProntuario = geraProntuario + 1;
		++geraProntuario;
		
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
			return peso;
		} else
			return null;
	}

	public void setPeso(Double peso) {
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {

			this.idade = idade;
	}

	public long getNumProntuario() {
		return numProntuario;
	}
	
	public void setNumProntuario(long x) {
		this.numProntuario =x;
	}

		
	
	@Override
	public String toString() {
		return getNome();
	}

}
