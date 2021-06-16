package graphicCells;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gameBoardComponents.GGameBoard;

public abstract class GCell extends JPanel{	
	private static final long serialVersionUID = 8603366871490044258L;
	
	protected char onCell; //Character indicate if there is 1 2 or 0 player on one cell
	protected JLabel players; //Label used to print character 'R' or 'B' or the string "BR"
	protected int fontSize = 28; //Size of font
	
	
	/**
	 * Set text in JLabel "players"
	 *  depend of onCell value
	 *  
	 * @param onCell character indicate if there is on the cell and who is it
	 */
	public void setText(char onCell) {
		this.players.setForeground(Color.black);
		
		//set alignment of cell
		this.players.setLocation(GGameBoard.sizeCell/2-fontSize/2,GGameBoard.sizeCell/2-fontSize/2);
		
		//if onCell == 'R' set Red Rider in cell
		if(onCell == 'R') {
			this.players.setText("R");
		}
		//if onCell == 'B' set Blue Rider in cell
		else if (onCell =='B'){
			this.players.setText("B");
		}
		//if onCell == 'A' set Blue and Red Rider in cell
		else if (onCell =='A'){
			this.players.setLocation(GGameBoard.sizeCell/2-fontSize,GGameBoard.sizeCell/2-fontSize);
			this.players.setText("RB");
		}
		//if onCell == 'N' set nothing in cell
		else {
			this.players.setText(" ");
		}
	}
	
	public void setText(int number) {
		//set alignment of cell
		this.players.setLocation(GGameBoard.sizeCell/2-fontSize/2,GGameBoard.sizeCell/2-fontSize/2);
		
		//set number in a cell
		this.players.setText(""+number);
	}
}
