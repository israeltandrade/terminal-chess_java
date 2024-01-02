package project.chess.config;

import project.chess.boardgame.Board;
import project.chess.boardgame.Piece;
import project.chess.boardgame.Position;

/* 
 * Subclasse da classe Piece, que é abstrata. Como ela ainda é genérica demais para
 * implementar os métodos da classe pai (o que é uma obrigatoriedade para classes abstratas),
 * ela também tem de ser classificada como abstrata e relegar a implementação para as classes
 * filhas:
 */
public abstract class ChessPiece extends Piece {

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
	
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}
	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
	
}
