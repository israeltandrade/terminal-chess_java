package project.chess.config;

import project.chess.boardgame.Board;
import project.chess.boardgame.Piece;

// Subclasse da classe Piece:
public class ChessPiece extends Piece {

	private Color color;

	/*
	 * Como a classe extende outra e a classe que ela herda tem um construtor. É
	 * obrigatório ter um construtor aqui também:
	 */
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	// A cor de uma peça não pode ser modificada, portanto apenas getter:
	public Color getColor() {
		return color;
	}
	
}
