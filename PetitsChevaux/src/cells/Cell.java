package cells;
import rider.Rider;

/**
 * @author Quentin et Maxime
 *
 */
public abstract class Cell implements Questionnable {
	protected int pos; //position of cell
	protected String symbol; // symbol of cell
	protected Rider r; //rider in cell
	protected String rules; //rules of cell
	protected String process; //process of cell
	
	/**
	 * @return position of cell
	 */
	protected int get_pos() {
		return pos; 
	}
	
	/**
	 * @return symbol of cell
	 */
	public String get_symbol() {
		return " "+symbol;
	}
	
	/**
	 * Delete rider in the cell
	 */
	public void free_Rider() {
		r = null;
	}
	
	/**
	 * @return true if there is rider in cell false else
	 */
	public boolean is_Rider() {
		return r!=null;
	}
	
	/**
	 * @return rider in the cell
	 */
	protected Rider get_Rider() {
		return r;
	}
	
	/**
	 * @param nb_dice = number of dice
	 * @param r = rider
	 * @return true if rider can move false else
	 */
	public boolean can_move(int nb_dice, Rider r) {
		return true;
	}
	
	/**
	 * Add rider in the cell and set the process
	 * 
	 * @param r rider in cell
	 * @return process of the cell
	 */
	public String process(Rider r) {
		r.set_pos(pos);
		this.r = r;
		return "Joueur "+((r.get_symbol()=='R')? "ROUGE":"BLEU")+" : "+process;
	}
	
	/**
	 * @return rules of the cell
	 */
	public String get_rules() {
		return rules;
	}
}
