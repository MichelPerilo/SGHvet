package exceptions;

public class ConectionException extends Exception{

	public ConectionException(){
		super("Falha na conex�o com banco de dados");
	}
}
