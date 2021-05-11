/**
 * Description
 * 
 * Classe simulant un fou et ses actions
 */

/**
 * @author Maxime Caron
 *
 */


public class Bishop extends Piece{
    
    /**
     * Constructeur
     * 
     * @param couleur
     * @param pos
     */
    Bishop(Color couleur, Position pos) {
    	name="Rook";
    	this.couleur=couleur;
    	this.pos=pos;
    	if(this.couleur == Color.NOIR) this.symbole='♝';
    	else this.symbole='♗';
    }
    
    /**
     * Constructeur
     * 
     * @param couleur
     * @param row
     * @param col
     */
    Bishop(Color couleur, int row, int col) {
    	name="Rook";
    	this.couleur=couleur;
    	this.pos= new Position(row, col);
    	if(this.couleur == Color.NOIR) this.symbole='♝';
    	else this.symbole='♗';
    }
    
    /**
     *
     */
    boolean move(int row, int col) {
    	Position newPos = new Position(row, col);
    	if (newPos.isValid() && Move.diagonal(this.pos, newPos)) {
    		this.pos = newPos;
    		return true;
    	}
    	return false;
    }
}
