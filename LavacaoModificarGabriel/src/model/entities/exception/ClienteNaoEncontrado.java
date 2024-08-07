package model.entities.exception;

public class ClienteNaoEncontrado extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ClienteNaoEncontrado(String msg) {
		super(msg);
	}
	
}