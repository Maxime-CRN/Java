/**
 * Description
 * 
 * Classe simulant un pion et ses actions
 */

/**
 * @author Maxime Caron
 *
 */

public class Pion extends Piece{
    
    /**
     * Constructeur
     * 
     * @param couleur
     * @param pos
     */
    Pion(Color couleur, Position pos) {
    	name="Pion";
    	this.couleur=couleur;
    	this.pos=pos;
    	if(this.couleur == Color.NOIR) this.symbole='♟';
    	else this.symbole='♙';
    }
    
    /**
     * Constructeur
     * 
     * @param couleur
     * @param row
     * @param col
     */
    Pion(Color couleur, int row, int col) {
    	name="Pion";
    	this.couleur=couleur;
    	this.pos= new Position(row, col);
    	if(this.couleur == Color.NOIR) this.symbole='♟';
    	else this.symbole='♙';
    }
    
    /**
     * Vérifie validité du mouvement
     * 
     * @param newPos
     * @return true si le mouvement est valide false sinon
     */
    boolean checkMove(Position newPos) {
    	if (this.couleur == Color.NOIR) {
    		if(this.pos.getRow() == 7) {
    			return ((this.pos.getRow() - newPos.getRow())<=2)&&(this.pos.getCol() == newPos.getCol());
    		}
    		else {
    			return ((this.pos.getRow() - newPos.getRow())<=1)&&(this.pos.getCol() == newPos.getCol());
    		}
    	}
    	else {
    		if(this.pos.getRow() == 1) {
    			return ((newPos.getRow() - this.pos.getRow())<=2)&&(this.pos.getCol() == newPos.getCol());
    		}
    		else {
    			return ((newPos.getRow() - this.pos.getRow())<=1)&&(this.pos.getCol() == newPos.getCol());
    		}
    	}
    }
    
    
    
    /**
     *
     */
    boolean move(int row, int col) {
    	Position newPos = new Position(row, col);
    	if (checkMove(newPos) && newPos.isValid()) {
    		this.pos = newPos;
    		return true;
    	}
    	return false;
    }
}
