package cells;
/**
 * @author Quentin et Maxime
 *
 */
public class CellWhite extends Cell{
	
	/**
	 * 
	 * @param pos position of cell
	 */
	public CellWhite(int pos){
		this.symbol = " ";
		this.pos = pos;
		process = "";
		rules = "";
	}
}
