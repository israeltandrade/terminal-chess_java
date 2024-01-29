package project.chess.config.pieces;

import project.chess.boardgame.Board;
import project.chess.boardgame.Position;
import project.chess.config.ChessMatch;
import project.chess.config.ChessPiece;
import project.chess.config.Color;

public class King extends ChessPiece {
	
	/*
	 * Dependência ChessMatch acrescentada para a peça do Rei poder averiguar as
	 * condições de Roque:
	 */
	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor(); 
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		// Acima
		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// Abaixo
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// À esquerda
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// À direta
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// Noroeste
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// Nordeste
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// Sudoeste
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// Sudeste
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// Special Move: Castling
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			/*
			 * Special Move: castling on kingside rook
			 */
			Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
			if (testRookCastling(posT1)) {
				// Casa à direita do rei
				Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				// Duas casas à direita do rei:
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				
				// Teste de se as posições p1 e p2 estão vazias (condição do Roque):
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}
			}
			/*
			 * Special Move: castling on queenside rook
			 */
			Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
			if (testRookCastling(posT2)) {
				// Casa à esquerda do rei
				Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				// Duas casas à esquerda do rei:
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				// Três casas à esquerda do rei:
				Position p3 = new Position(position.getRow(), position.getColumn() - 3);
				
				// Teste de se as posições p1 e p2 estão vazias (condição do Roque):
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					mat[position.getRow()][position.getColumn() - 2] = true;
				}
			}
		}
		
		return mat;
	}

}
