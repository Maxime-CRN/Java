package graphicCells;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;



public class GCellStart extends GCell {
	
	private static final long serialVersionUID = 7797340095014410690L;	

	/**
	 * Use onCell for known if there is 0, 1 or 2 rider on the cell
	 * 
	 * @param onCell character indicate if there is on the cell and who is it
	 */
	public GCellStart(char onCell) {
		this.onCell = onCell;
		this.players = new JLabel(" ");
		this.players.setFont(new Font("Arial", Font.BOLD, fontSize));
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
		g.setColor(new Color(233,137,171));
		//paint rectangle
		g.fillRect(2, 2, this.getWidth()-4, this.getHeight()-4);
		
		return;
	}
}