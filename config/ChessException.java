package project.chess.config;

public class ChessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	// Método recebe uma mensagem e repassa ao construtor da superclasse:
	public ChessException(String msg) {
		super(msg);
	}
	
}
