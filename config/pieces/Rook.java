package project.chess.config.pieces;

import project.chess.boardgame.Board;
import project.chess.config.ChessPiece;
import project.chess.config.Color;

public class Rook extends ChessPiece{

	// Construtor parte do que é estabelecido na classe pai:
	public Rook(Board board, Color color) {
		super(board, color);
	}

	// O retorno serve apenas para posicionar a letra no tabuleiro:
	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return mat;
	}
	
}
