package gameBoardComponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import actions.RollButton;

/**
 * @author Quentin et Maxime
 * 
 * Panel for button "Rouler le dé" and turn message
 *
 */
public class GTopBoard extends JPanel{

	private static final long serialVersionUID = -4118779078373441845L;
	
	private JPanel rollBtnPan; //roll button panel
	private JButton rollBtn; //button for rolling dice
	private RollButton rollEvent; //Listener for event "someone click on rollBtn"
	
	private JLabel whosTurn; //Label for print who's player play
	
	private int winHeight =70; //Height of panel
	
	
	public GTopBoard() {
		
		//Create panel and init layout
		rollBtnPan = new JPanel();
		rollBtnPan.setLayout(new FlowLayout());
		
		//Create button for rolling dice
		rollBtn = new JButton("Rouler le dé");
		//Create listener of rollBtn
		rollEvent = new RollButton(rollBtn);
		
		//Add event on rollBtn
		rollBtn.addActionListener(rollEvent);
		
		rollBtnPan.add(rollBtn);
		

		
		//create and init label
		whosTurn = new JLabel(" ");
		whosTurn.setSize(new Dimension(150,30));
		whosTurn.setHorizontalAlignment(SwingConstants.CENTER);
		
		//set size of gameBoard
		this.setPreferredSize(new Dimension(this.getWidth(),winHeight));
		
		
		//set layout
		this.setLayout(new BorderLayout());
		
		//add rollBtn on panel
		this.add("South",rollBtnPan);
		
		//add labels on panel
		this.add("Center", whosTurn);
	}
	
	
	/**
	 * Change message of player turn
	 * 
	 * @param turn turn number
	 */
	public void printWhosTurn(int turn) {
		if(turn%2==0) {
			rollBtn.setEnabled(true); //unlock rollBtn to click on it
			whosTurn.setText("Le cavalier de couleur ROUGE joue :");
		}
		else {
			//rollBtn.setEnabled(false); //lock rollBtn to don't click on it
			whosTurn.setText("Le cavalier de couleur BLEU joue ");
		}
	}
	
	/**
	 * @return height of window
	 */
	public int getHeight() {
		return winHeight;
	}



	/**
	 * @return value of boolean "rolling" in rollEvent
	 */
	public boolean getRoll() {
		return rollEvent.getRoll();
	}
	
	/**
	 * @return Panel
	 */
	public JPanel getPanel() {
		return this;
	}
	
	
	/**
	 * Reset rolling value to false
	 */
	public void resetRoll() {
		rollEvent.setRoll(false);
	}
}
