package playlist;

public class CancionNoEncontradaException extends Exception{
	
	public CancionNoEncontradaException(String msj) {
		
		super(msj);
	}

	public CancionNoEncontradaException() {
		this(null);
	}
}
