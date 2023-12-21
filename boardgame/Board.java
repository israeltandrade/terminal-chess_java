package project.chess.boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		/*
		 * O construtor padrão iria sugerir "this.pieces = pieces". No entanto, ao invés
		 * de uma matriz sem informação, assumiremos que ela será nova e já vem com o
		 * número de linhas e colunas:
		 */
		pieces = new Piece[rows][columns];
	}
	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	/*
	 * Ao invés de getters e setters para piece, foram criados dois métodos. O primeiro
	 * retorna a peça, dada a linha e coluna e o outro, por sobrecarga, fornecendo a
	 * posição da peça:
	 */
	public Piece piece(int row, int column) {
		// Ao invés de retornar a matriz inteira, é retornado apenas uma peça:
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		// Ao invés de retornar a matriz inteira, é retornado apenas uma peça:
		return pieces[position.getRow()][position.getColumn()];
	}
	
	// Preenchendo a matriz declarada acima e inicializada no construtor:
	public void placePiece(Piece piece, Position position) {
		pieces[position.getRow()][position.getColumn()] = piece;
		// Atribuindo uma posição à peça (não terá mais valor nulo):
		piece.position = position;
	}
	
}
