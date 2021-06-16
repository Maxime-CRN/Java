package rider;

/**
 * @author Quentin et Maxime
 *
 */
public class Rider {
	private char symbol; //Symbol of rider 'R' or 'B'
	private int pos; //Position of rider on the board
	private int cellStart; //Start cell of the rider, used to make 'back to start' actions
	private boolean win; //true if player won, false else
	
	/**
	 * 
	 * @param pos position of rider
	 * @param symbol symbol of rider
	 * @param cellStart Start cell of rider
	 */
	public Rider(int pos, char symbol, int cellStart){
		this.symbol=symbol;
		this.pos = pos;
		this.cellStart =cellStart;
		this.win = false;
	}
	
	/**
	 * @return symbol of rider
	 */
	public char get_symbol() {
		return symbol;
	}
	
	/**
	 * @return position of rider
	 */
	public int get_pos() {
		return pos;
	}
	
	/**
	 * @param pos set position of rider
	 */
	public void set_pos(int pos) {
		this.pos = pos;
	}
	
	
	/**
	 * @return position of start cell
	 */
	public int get_cellStart() {
		return cellStart;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}
}
