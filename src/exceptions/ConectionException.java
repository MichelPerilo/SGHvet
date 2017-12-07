package exceptions;

public class ConectionException extends Exception{

	public ConectionException(){
		super("Falha na conexão com banco de dados");
	}
}
