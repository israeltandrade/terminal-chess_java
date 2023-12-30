package project.chess.boardgame;

public abstract class Piece {

	/*
	 * A posição aqui tem o modificador de acesso "protected" porque se trata de uma
	 * posição em matriz e não é interessante tornar isso visível na camada de xadrez:
	 */
	protected Position position;
	/*
	 * A peça "conhece" o tabuleiro onde se encontra. Existe a seguinte relação:
	 * Um (1) tabuleiro (Board) TEM várias peças:
	 */
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		/*
		 * A posição da peça é colocada como nula a princípio no construtor para indicar
		 * que a peça ainda não foi colocada no tabuleiro. Por padrão o Java já atribui
		 * o valor nulo ao objeto e não seria necessário fazer a atribuição a seguir,
		 * porém, ela se encontra aqui com fins didáticos: 
		 */
		position = null;
	}

	/*
	 * Foi criado o get do objeto Board e não o set.
	 * Modificador de acesso "protected" faz com que somente classes no mesmo pacote
	 * e subclasses do objeto "Piece" poderão acessar o tabuleiro de uma peça
	 * específica. O tabuleiro não deve ser acessado pela camada de configuração de
	 * xadrez específica.
	 */
	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	/*
	 * Método apelidado "Hook Method", faz um gancho com a subclasse.
	 * Um método concreto utilizando um método abstrato.
	 * Existe um padrão de projeto chamado "Template Method" em que pode-se fornecer uma
	 * implementação padrão de um método que contém um método abstrato:
	 */
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
}
