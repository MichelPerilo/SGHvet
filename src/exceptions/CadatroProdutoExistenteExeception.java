package exceptions;

/**
 *
 * @author Raylison
 */
public class CadatroProdutoExistenteExeception extends Exception{
    
    private String nome;
    public CadatroProdutoExistenteExeception(String nome){
		
	super(nome + " JA ESTA CADASTRADO!!!");
	this.setNome(nome);
    }
		
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
	if(nome!= null)
	this.nome = nome;
    }

    
}
