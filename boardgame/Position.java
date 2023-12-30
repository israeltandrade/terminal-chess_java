package project.chess.boardgame;
// Pacote correspondente à camada de tabuleiro

public class Position {

	private int row;
	private int column;
	
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	public void setValues(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	/*
	 * Classe Object é uma superclasse de todas as classes.
	 * Override aplica o conceito de sobreposição pois sobreescrevemos o método
	 * toString() que pertence à classe Object.
	 */
	@Override
	public String toString() {
		return row + ", " + column;
	}
	
	
}
