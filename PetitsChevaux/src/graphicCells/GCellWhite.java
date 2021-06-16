package graphicCells;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

import gameBoardComponents.GGameBoard;



public class GCellWhite extends GCell {
	private static final long serialVersionUID = 9216384511627828832L;
	
	/**
	 * Use onCell for known if there is 0, 1 or 2 rider on the cell
	 * 
	 * @param onCell character indicate if there is on the cell and who is it
	 */
	public GCellWhite(char onCell) {
		this.onCell = onCell;
		this.players = new JLabel(" ");
		
		//set alignment of cell
				this.players.setLocation(GGameBoard.sizeCell/2,GGameBoard.sizeCell/2);
		
		this.players.setFont(new Font("Arial", Font.BOLD, fontSize));
		this.add(players);
	}
	
	public GCellWhite(String msg) {
		
		this.players = new JLabel(msg);	
		
		//set alignment of cell
				this.players.setLocation(GGameBoard.sizeCell/2,GGameBoard.sizeCell/2);
				
		this.players.setFont(new Font("Arial", Font.BOLD, fontSize/2));
		
		
		this.add(players);
	}
	
	/**
	 * Paint the inside of the cell with the good color
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		/**
		 * Paint black rectangle in background
		 * to have a grid effect after painting 
		 * in a smaller rectangle
		 */
		
		// Set color
		g.setColor(Color.black);
		//paint rectangle
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// Set color
		g.setColor(Color.white);
		//paint rectangle
		g.fillRect(2, 2, this.getWidth()-4, this.getHeight()-4);
		
	}
}
