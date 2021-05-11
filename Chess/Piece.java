/**
 * Description
 * 
 * Classe abstraite définissant les variables et méthodes communes des piece du jeu
 */

/**
 * @author Maxime Caron
 *
 */

public abstract class Piece {

    protected String name;
    protected char symbole;
    protected Color couleur;
    protected Position pos;	
	
    
    
    /**
     * @return nom de la pièce
     */
    protected String getName(){
    	return name;
    }

    /**
     * @return symbole de la pièce
     */
    protected char getSymbole(){
    	return symbole;
    }

    /**
     * @return couleur de la pièce
     */
    protected Color getColor(){
    	return couleur;
    }

    /**
     * @return position de la pice sur l'echiquier
     */
    protected Position getPos(){
    	return pos;
    }
    
    /** 
     * @return the row number of the position 
     */
    protected int getRow() { 
    	return pos.getRow();
    }

    /** 
     * @return the column number of the position 
     */
    protected int getCol() { 
    	return pos.getCol();
    }
    
    /**
     * Effectue un mouvement
     * 
     * @param row
     * @param col
     * @return true si le movement à été effectué, false sinon
     */
    abstract boolean move( int row, int col);

}