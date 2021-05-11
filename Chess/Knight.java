/**
 * Description
 * 
 * Classe simulant un cavalier et ses actions
 */

/**
 * @author Maxime Caron
 *
 */
public class Knight extends Piece{
    
    /**
     * Constructeur
     * 
     * @param couleur
     * @param pos
     */
    Knight(Color couleur, Position pos) {
    	name="Knight";
    	this.couleur=couleur;
    	this.pos=pos;
    	if(this.couleur == Color.NOIR) this.symbole='♞';
    	else this.symbole='♘';
    }
    
    /**
     * Constructeur
     * 
     * @param couleur
     * @param row
     * @param col
     */
    Knight(Color couleur, int row, int col) {
    	name="Knight";
    	this.couleur=couleur;
    	this.pos= new Position(row, col);
    	if(this.couleur == Color.NOIR) this.symbole='♞';
    	else this.symbole='♘';
    }
    
    /**
     * Vérifie validité du mouvement
     * 
     * @param newPos
     * @return true si le mouvement est valide false sinon
     */
    boolean checkMove(Position newPos) {
    	return ((Move.longueurVertical(this.pos, newPos)*Move.longueurHorizontal(this.pos, newPos))==2);
    }
    
    /**
     *
     */
    boolean move(int row, int col) {
    	Position newPos = new Position(row, col);
    	if (newPos.isValid() && checkMove(newPos)) {
    		this.pos = newPos;
    		return true;
    	}
    	return false;
    }
}
