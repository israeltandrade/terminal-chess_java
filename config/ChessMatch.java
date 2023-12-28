package project.chess.config;

import project.chess.boardgame.Board;
import project.chess.boardgame.Piece;
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
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source, target);
		// Downcasting de Piece para ChessPiece:
		return (ChessPiece)capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
	}
	
	// Método passa posição em coodenada de xadrez e converte para matriz:
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
	
}
