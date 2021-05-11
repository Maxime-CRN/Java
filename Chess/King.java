/**
 * Description
 * 
 * Classe simulant un roi et ses actions
 */

/**
 * @author Maxime Caron
 *
 */


public class King extends Piece{
    
    /**
     * Constructeur
     * 
     * @param couleur
     * @param pos
     */
    King(Color couleur, Position pos) {
    	name="King";
    	this.couleur=couleur;
    	this.pos=pos;
    	if(this.couleur == Color.NOIR) this.symbole='♚';
    	else this.symbole='♔';
    }
    
    /**
     * Constructeur
     * 
     * @param couleur
     * @param row
     * @param col
     */
    King(Color couleur, int row, int col) {
    	name="King";
    	this.couleur=couleur;
    	this.pos= new Position(row, col);
    	if(this.couleur == Color.NOIR) this.symbole='♚';
    	else this.symbole='♔';
    }    
    
    
    /**
     *
     */
    boolean move(int row, int col) {
    	Position newPos = new Position(row, col);
    	if (newPos.isValid() && (Move.longueurVertical(this.pos, newPos) <=1) &&  (Move.longueurHorizontal(this.pos, newPos) <=1)) {
    		this.pos = newPos;
    		return true;
    	}
    	return false;
    }
}