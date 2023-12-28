package project.chess.boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		// Programação defensiva => evitando anomalias com matriz do board:
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		/*
		 * O construtor padrão iria sugerir "this.pieces = pieImplementar a atualização das mensagens do fluxo de finalização 1ces". No entanto, ao invés
		 * de uma matriz sem informação, assumiremos que ela será nova e já vem com o
		 * número de linhas e colunas:
		 */
		pieces = new Piece[rows][columns];
	}
	
	// Programação defensiva => remoção de setters para rows e columns.
	
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	/*
	 * Ao invés de getters e setters para piece, foram criados dois métodos. O primeiro
	 * retorna a peça, dada a linha e coluna e o outro, por sobrecarga, fornecendo a
	 * posição da peça:
	 */
	public Piece piece(int row, int column) {
		// Programação defensiva => avaliar posição inexistente:
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		// Ao invés de retornar a matriz inteira, é retornado apenas uma peça:
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		// Programação defensiva => avaliar posição inexistente:
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		// Ao invés de retornar a matriz inteira, é retornado apenas uma peça:
		return pieces[position.getRow()][position.getColumn()];
	}
	
	// Preenchendo a matriz declarada acima e inicializada no construtor:
	public void placePiece(Piece piece, Position position) {
		// Programação defensiva => checar se já existe peça na posição:
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		// Atribuindo uma posição à peça (não terá mais valor nulo):
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		// Primeira checagem => posição existe no tabuleiro:
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		// Segunda checagem => peça está na posição indicada:
		if (piece(position) == null) {
			return null;
		}
		// Objeto instanciado Piece auxiliar:
		Piece aux = piece(position);
		// Recebe nulo para posição:
		aux.position = null;
		// Matriz de peças recebe valor nulo na posição indicada: 
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	// Método auxiliar ao seguinte, que também serve para consultas:
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	// Método referencia o anterior para checar a position:
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	// Testa o método piece() e checa se o retorno é nulo:
	public boolean thereIsAPiece(Position position) {
		// Programação defensiva => Testa se a posição existe antes de checar peça:
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
	
}
