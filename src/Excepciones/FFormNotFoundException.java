package Excepciones;

public class FFormNotFoundException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID=1L;
	static String message = "no se ha encontrado la anottation FForm en la clase: ";
	public FFormNotFoundException(String className){
		super(message+className);
	}
}
