package graphicCells;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

import gameBoardComponents.GGameBoard;



public class GCellSide extends GCell {	
	
	private static final long serialVersionUID = 2745022012530312224L;

	/**
	 * Use onCell for known if there is 0, 1 or 2 rider on the cell
	 * 
	 * @param onCell character indicate if there is on the cell and who is it
	 */
	public GCellSide(char onCell) {
		this.onCell = onCell;
		this.players = new JLabel(" ");
		this.players.setPreferredSize(new Dimension(40,40));
		
		//set alignment of cell
		this.players.setLocation(GGameBoard.sizeCell/2-fontSize/2,GGameBoard.sizeCell/2-fontSize/2);
				
		this.players.setFont(new Font("Arial", Font.BOLD, fontSize));
		this.add(players);
		//set text in JLabel "players"
		super.setText(onCell);
	}
	
	
	/**
	 * Paint the inside of the cell with the good color
	 */
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		// Set color
		g.setColor(Color.green);
		//paint rectangle
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		return;
	}
}