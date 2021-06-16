package cells;
import rider.Rider;

/**
 * @author Quentin et Maxime
 *
 */
public class CellFree extends Cell{
	
	/**
	 * @param pos position of the cell
	 */
	public CellFree(int pos){
		r = null;
		this.symbol = ".";
		this.pos = pos;
		process = "case neutre";
		rules = "";
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
		symbol = ".";
	}
	
}
