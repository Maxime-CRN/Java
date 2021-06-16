package cells;
import rider.Rider;

/**
 * @author Quentin et Maxime
 *
 */
public class CellHedge extends Cell{

	/**
	 * @param pos position of cell
	 */
	public CellHedge(int pos){
		r = null;
		this.symbol = "|";
		this.pos = pos;	
		rules = " doit obtenir une valeur de dé impair pour franchir la haie";
		process = "case haie";
	}
	
	/**
	 * 	Adding rider on the cell and 
	 * 	get "process"
	 * 
	 * 	@param r rider in cell
	 */
	public String process(Rider r) {
		String res =super.process(r); 
		this.symbol =""+this.r.get_symbol();
		return res;
	}
	
	/**
	 * Delete rider in cell
	 */
	public void free_Rider() {
		super.free_Rider();
		symbol = "|";
	}
	
	
	/**	
	 * @param nb_dice number of the dice
	 * 
	 * @return true if rider can move else false
	 */
	public boolean can_move(int nb_dice, Rider r) {
		if(nb_dice%2 == 1) {
			return true;
		}
		return false;
	}
}
