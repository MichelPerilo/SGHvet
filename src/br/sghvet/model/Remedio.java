
package br.sghvet.model;

/**
 *
 * @author Raylison
 */


public class Remedio {
    
    
	private int id;
    private String nome;
    private Tipo_Remedio tipo;
    private String descricao;
    private String restricao;
   

    public Remedio(String nome, Tipo_Remedio tipo, String descricao, String retricao) {
       
    	setNome(nome);
        setTipo(tipo);
        setDescricao(descricao);
        setRestricao(retricao);

    }

    
    
    
    public String getNome() {
        return nome;
    }

    public Tipo_Remedio getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
         this.id = id;
    }
   
    private void setNome(String nome) {
        if(nome != null && nome.length() > 0){
        this.nome = nome;
        }
    }

    private void setTipo(Tipo_Remedio tipo) {
        
        this.tipo = tipo;
        
    }

    private void setDescricao(String descricao) {
        if(descricao != null && descricao.length() > 0){
        this.descricao = descricao;
        }
    }




	public String getRestricao() {
		return restricao;
	}




	public void setRestricao(String restricao) {
		this.restricao = restricao;
	}
    
     
 }
