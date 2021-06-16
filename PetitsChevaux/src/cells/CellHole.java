package cells;
import rider.Rider;

/**
 * @author Quentin et Maxime
 *
 */
public class CellHole extends Cell{
	
	private int counter; //Nb of turn passed since the rider was in the box
	private char r_blocked; //Symbol of blocked rider

	/**
	 * @param pos position of cell
	 */
	public CellHole(int pos){
		r = null;
		this.symbol = "@";
		this.pos = pos;
		rules = "est tombé dans le trou il doit attendre 3 tours avant de pouvoir en sortir";
		process = "case trou";
		counter = 0;
		r_blocked = ' ';
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
		
		//test if is the same rider of blocked rider
		if(r.get_symbol() != r_blocked) {
			//if not block new rider and reset counter
			r_blocked = r.get_symbol();
			counter = 0;
		}
		return res;
	}
	
	/**
	 * Delete rider in cell
	 */
	public void free_Rider() {
		super.free_Rider();
		symbol = "@";
	}
	
	
	
	/**
	 *	
	 *
	 * @param nb_dice number of the dice
	 * 
	 * @return true if rider can move else false
	 */
	public boolean can_move(int nb_dice, Rider r) {
		//set different message depend of counter
		//increment counter
		if(counter == 0) {
			++counter;
		}
		else if(counter < 2) {
			rules = "doit attendre encore "+(3-counter)+" tours avant de pouvoir sortir du trou";
			++ counter;
		}
		else if(counter == 2) {
			rules = "sort au prochain tour";
			++ counter;
		}
		else{
			r_blocked = ' ';
			return true;
		}
		return false;
	}
}
