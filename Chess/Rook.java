/**
 * Description
 * 
 * Classe simulant une tour et ses actions
 */

/**
 * @author Maxime Caron
 *
 */


public class Rook extends Piece{
    
    /**
     * Constructeur
     * 
     * @param couleur
     * @param pos
     */
    Rook(Color couleur, Position pos) {
    	name="Rook";
    	this.couleur=couleur;
    	this.pos=pos;
    	if(this.couleur == Color.NOIR) this.symbole='♜';
    	else this.symbole='♖';
    }
    
    /**
     * Constructeur
     * 
     * @param couleur
     * @param row
     * @param col
     */
    Rook(Color couleur, int row, int col) {
    	name="Rook";
    	this.couleur=couleur;
    	this.pos= new Position(row, col);
    	if(this.couleur == Color.NOIR) this.symbole='♜';
    	else this.symbole='♖';
    }
    
    /**
     *
     */
    boolean move(int row, int col) {
    	Position newPos = new Position(row, col);
    	if (newPos.isValid() && (Move.vertical(this.pos, newPos)^Move.horizontal(this.pos, newPos))) {
    		this.pos = newPos;
    		return true;
    	}
    	return false;
    }
}

