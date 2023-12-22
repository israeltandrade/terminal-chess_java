package project.chess.config;

import project.chess.boardgame.Board;
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
	
	// Método passa posição em coodenada de xadrez e converte para matriz:
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('e', 1, new King(board, Color.WHITE));
	}
	
}
