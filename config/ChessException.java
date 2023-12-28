package project.chess.config;

import project.chess.boardgame.BoardException;

public class ChessException extends BoardException {

	private static final long serialVersionUID = 1L;

	// Método recebe uma mensagem e repassa ao construtor da superclasse:
	public ChessException(String msg) {
		super(msg);
	}
	
}
