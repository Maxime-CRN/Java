/**
 * Description
 *
 * Classe simulant un échiquier et ses pièces
 */

/**
 * @author Maxime Caron
 *
 */


public class ChessBoard {
	private Piece platal[][];
	private int size;
	private Piece blackEater[] = new Piece[16];
	private Piece whiteEater[] = new Piece[16];

	/**
	 * Constructeur : initalise le plateau et ses pièce aux position de départ;
	 *
	 */
	ChessBoard() {
		this.size=10;
		this.platal = new Piece [this.size][this.size];
		for(int i=1; i<9; ++i) {
			platal[i][2] = new Pion(Color.NOIR, 2, i);
			platal[i][7] = new Pion(Color.BLANC, 7, i);
		}
		platal[1][1] = new Rook(Color.NOIR, 1, 1);
		platal[8][1] = new Rook(Color.NOIR, 1, 8);
		platal[1][8] = new Rook(Color.BLANC, 8, 1);
		platal[8][8] = new Rook(Color.BLANC, 8, 8);

		platal[3][1] = new Bishop(Color.NOIR, 1, 3);
		platal[6][1] = new Bishop(Color.NOIR, 1, 6);
		platal[3][8] = new Bishop(Color.BLANC, 8, 3);
		platal[6][8] = new Bishop(Color.BLANC, 8, 6);

		platal[2][1] = new Knight(Color.NOIR, 1, 2);
		platal[7][1] = new Knight(Color.NOIR, 1, 7);
		platal[2][8] = new Knight(Color.BLANC, 8, 2);
		platal[7][8] = new Knight(Color.BLANC, 8, 7);

		platal[5][1] = new King(Color.NOIR, 1, 5);
		platal[5][8] = new King(Color.BLANC, 8, 5);

		platal[4][1] = new Queen(Color.NOIR, 1, 4);
		platal[4][8] = new Queen(Color.BLANC, 8, 4);
	}

	/**
	 * @param row
	 * @param col
	 * @return la Piece contenue dans la case spécifié
	 */
	Piece getCase(int row, int col) {
		return this.platal[col][row];
	}

	/**
	 * @param row
	 * @param col
	 * @return le symbole de la Piece contenue dans la case spécifié
	 */
	char getSymbole(int row, int col) {
		return this.platal[col][row].getSymbole();
	}

	/**
	 * @param piece
	 */
	void setCase(Piece piece) {
		this.platal[piece.getCol()][piece.getRow()] = piece;
	}

	/**
	 * Efface le contenue de la case et la remet a la valeur null
	 *
	 * @param row
	 * @param col
	 */
	private void eraseCase(int row, int col) {
		this.platal[col][row]=null;
	}

	/**
	 * Sauvegarde la piece prise dans le "eater" de l'adversaire
	 *
	 * @param piecePrise
	 */
	private void eatPiece(Piece piecePrise) {
		int i=0;
		if(piecePrise.getColor() == Color.BLANC) {
			while(blackEater[i] != null) ++i;
			blackEater[i] = piecePrise;
		}
		else {
			while(whiteEater[i] != null) ++i;
			whiteEater[i] = piecePrise;
		}
	}

	/**
	 * Vérifie si aucune pièce ne bloque le passage de la piece en mouvement
	 *
	 * @param row
	 * @param col
	 * @param newRow
	 * @param newCol
	 * @return true si il n'y a aucune pièce qui bloque, false sinon
	 */
	private boolean betweenUs(int row, int col, int newRow, int newCol) {
		int start;
		int end;
		if (row == newRow) {
			start = (col < newCol)? col+1 : newCol+1;
			end = (col > newCol)? col : newCol;
			for(int i =start; i <end; ++i) {
				if(this.platal[i][row] != null) return false;
			}
		}
		else if (col == newCol) {
			start = (row < newRow)? row+1 : newRow+1;
			end = (row > newRow)? row : newRow;
			for(int i =start; i <end; ++i) {
				if(this.platal[col][i] != null) return false;
			}
		}
		else {
			int x,y;
			if(newCol>col && newRow>row) {
				x = row+1;
				y = col+1;
				while(x != newRow && y != newCol) {
					if(this.platal[y][x] != null) return false;
					++x;
					++y;
				}
			}
			else if(newCol<col && newRow>row) {
				x = row+1;
				y = col-1;
				while(x != newRow && y != newCol) {
					if(this.platal[y][x] != null) return false;
					++x;
					--y;
				}
			}
			else if(newCol>col && newRow<row) {
				x = row-1;
				y = col+1;
				while(x != newRow && y != newCol) {
					if(this.platal[y][x] != null) return false;
					--x;
					++y;
				}
			}
			else {
				x = row-1;
				y = col-1;
				while(x != newRow && y != newCol) {
					if(this.platal[y][x] != null) return false;
					--x;
					--y;
				}
			}
		}

		return true;
	}

	/**
	 * Vérifie la validité d'un mouvement
	 *
	 * @param row
	 * @param col
	 * @param newRow
	 * @param newCol
	 * @return true si le mouvement est valide, false sinon
	 */
	private boolean checkMove(int row, int col, int newRow, int newCol) {
		boolean res= this.platal[col][row].move(newRow, newCol);
		if(this.platal[newCol][newRow] != null) {
			if(this.platal[newCol][newRow].getColor() != this.platal[col][row].getColor()) {
				eatPiece(this.platal[newCol][newRow]);
			}
			else return false;
		}
		if( ! this.platal[col][row].getName().equals("Knight")) {
			res =(res || betweenUs(row, col, newRow, newCol));
		}
		return res;
	}

	/**
	 * Effectue le mouvement d'une piece sur l'échiquier
	 *
	 * @param row
	 * @param col
	 * @param newRow
	 * @param newCol
	 * @return true si le mouvement est effectué, false sinon
	 */
	boolean move(int row, int col, int newRow, int newCol) {
		boolean res = checkMove(row, col, newRow, newCol);
		if(res) {
			this.platal[newCol][newRow] = this.platal[col][row];
			eraseCase(row, col);
		}
		return res;
	}

	/**
	 *
	 */
	public String toString() {
		String res ="";
		for(int i=0; i<this.size; ++i) {
			for(int j=0; j<this.size; ++j) {
				if((i==0 || i==9) && (j==0 || j==9))res =res+"   ";
				else if(j == 0 || j == 9)res =res+" "+i+" ";
				else if(i == 0 || i == 9)res =res+" "+j+" ";
				else if(this.platal[j][i]==null)res =res+" . ";
				else res =res+" "+this.platal[j][i].getSymbole()+" ";
			}
			res =res+"\n";
		}
		return res;
	}
}
