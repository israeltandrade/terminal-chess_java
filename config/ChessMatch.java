package project.chess.config;

import project.chess.boardgame.Board;
import project.chess.boardgame.Position;
import project.chess.config.pieces.King;
import project.chess.config.pieces.Rook;

/*
 * Classe dedicada às regras do jogo de xadrez:
 */
public class ChessMatch {

	private Board board;
	
	// Quem deveria "conhecer" a dimensão do tabuleiro seria a classe ChessMatch: 
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}
	
	/*
	 * Método retorna uma matriz de peças de xadrez correspondente à partida específica.
	 * "ChessPiece" faz com que a classe acesse apenas a camada de xadrez e não a de
	 * tabuleiro (que envolveria Piece apenas):
	 */
	public ChessPiece[][]getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				/* Necessário fazer um downcasting para ChessPiece para interpretar como
				 * peça de xadrez e não peça comum:
				 */
				
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
		board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
	}
	
}
