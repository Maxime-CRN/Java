package cells;
import rider.Rider;

/**
 * @author Quentin et Maxime
 *
 */
public class CellSide extends Cell{
	
	/**
	 * @param pos position of cell
	 */
	public CellSide(int pos){
		this.r = null;
		this.symbol = "+";
		this.pos = pos;
		process = "dans l'écurie";
		rules ="doit faire un 6 pour sortir de l'écurie";
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
		symbol = "+";
	}
	
	/**
	 * @param nb_dice number of the dice
	 * 
	 * @return true if rider can move else false
	 */
	public boolean can_move(int nb_dice,Rider r) {
		if(nb_dice == 6) {
			return true;
		}
		return false;
	}
	
}
