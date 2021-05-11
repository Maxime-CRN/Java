/**
 * Description
 * 
 * Classe simulant une reine et ses actions
 */

/**
 * @author Maxime Caron
 *
 */


public class Queen extends Piece{
    
    /**
     * Constructeur
     * 
     * @param couleur
     * @param pos
     */
    Queen(Color couleur, Position pos) {
    	name="Queen";
    	this.couleur=couleur;
    	this.pos=pos;
    	if(this.couleur == Color.NOIR) this.symbole='♛';
    	else this.symbole='♕';
    }
    
    
    /**
     * Constructeur
     * 
     * @param couleur
     * @param pos
     */
    Queen(Color couleur, int row, int col) {
    	name="Queen";
    	this.couleur=couleur;
    	this.pos= new Position(row, col);
    	if(this.couleur == Color.NOIR) this.symbole='♛';
    	else this.symbole='♕';
    }
    
    /**
     *
     */
    boolean move(int row, int col) {
    	Position newPos = new Position(row, col);
    	if (newPos.isValid() &&(Move.diagonal(this.pos, newPos)^Move.vertical(this.pos, newPos)^Move.horizontal(this.pos, newPos))) {
    		this.pos = newPos;
    		return true;
    	}
    	return false;
    }

}