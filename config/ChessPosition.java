package project.chess.config;

import project.chess.boardgame.Position;

public class ChessPosition {
	
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		// Programação defensiva => limitar possibilidades ao tabuleiro de xadrez:
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	// Método retorna a posição matricial (ao invés da posição do xadrez):
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		/* Espaço vazio força o compilador a entender a operação a seguir como
		 * concatenação de string:
		 */
		return "" + column + row;
	}
	
}
