package gameBoardComponents;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author Quentin et Maxime
 *
 *	Panel for player sat
 */
public class GBotBoard extends JPanel{

	private static final long serialVersionUID = -6139664918405529025L;

	private JLabel infoBlue; //Label for print information about players
	private JLabel infoRed; //Label for print information about players
	
	private int winHeight; //Height of panel
	
	
	public GBotBoard() {
		//create and init labels
		infoBlue = new JLabel();
		infoRed = new JLabel();
		
		infoBlue.setHorizontalAlignment(SwingConstants.CENTER);
		infoRed.setHorizontalAlignment(SwingConstants.CENTER);
		
		//set layout
		this.setLayout(new BorderLayout());
				
		//add label on panel
		this.add("North",infoRed);
		//add label on panel
		this.add("South", infoBlue);
		
		this.winHeight = 0;
	}
	
	/**
	 * Update informations about red and blue players
	 * 
	 * @param textRed informations about red player
	 * @param textBlue information about blue player
	 */
	public void updateText(String textRed, String textBlue) {
		this.winHeight = 70;
		infoRed.setText("** "+textRed+ " **");
		infoBlue.setText("** "+textBlue+ " **");
	}
	
	/**
	 * @return Panel
	 */
	public JPanel getPanel() {
		return this;
	}
	
	/**
	 * @return height of panel
	 */
	public int getHeight() {
		return winHeight;
	}

}
