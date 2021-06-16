package cells;
import rider.Rider;

/**
 * @author Quentin et Maxime
 *
 */
public class CellStart extends Cell{
	
	private Rider r2; //Second rider
	
	/**
	 * @param pos cell position
	 */
	public CellStart(int pos){
		r = null;
		r2 = null;
		symbol = "#";
		this.pos = pos;
		process = "sur la case départ";
		rules = "est sur la case départ";
	}
	
	
	/**
	 * 	Adding rider on the cell and 
	 * 	get "process"
	 * 
	 * 	@param r rider in cell
	 */
	public String process(Rider r) {
		String res; //buffer for process
		
		
		//If cell not empty
		if (this.r !=  null && this.r.get_cellStart() != this.pos) {
			r.set_pos(pos); //Set position of new rider to position of the cell
			this.r2 = r; //Set r2 is rider
			
			//set process
			if(r.get_symbol()=='R') {
				res= "R ROUGE "+process;
			}
			else {
				res= "B BLEU "+process;
			}
			
			this.symbol ="RB";
		}
		//If cell is empty or is own start cell
		else {
			//Add rider to r
			res =super.process(r);
			//symbol is symbol of rider
			this.symbol =" "+this.r.get_symbol();
		}
		return res;
	}
	
	/**
	 * Delete rider in cell
	 */
	public void free_Rider() {
		//if there is 1 rider on the cell
		if(r2 == null) {
			//free rider of cell
			super.free_Rider();
			symbol = "#";
		}
		//if there 2 rider on the cell
		else {
			//set r as r2
			r = r2;
			//free r2
			r2 = null;
			//change symbol for set as r2 symbol
			symbol = ""+r.get_symbol();
		}
	}
	
	/**
	 * Get symbol of cell
	 */
	public String get_symbol() {
		if(r2 != null) {
			return symbol;
		}
		return " "+symbol;
	}
	
}
