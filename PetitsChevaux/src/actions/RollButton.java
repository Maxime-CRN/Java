package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * @author Quentin et Maxime
 *
 * Listener for event "someone click on rollBtn"
 *
 */
public class RollButton implements ActionListener {
	
	private boolean rolling; // If true dice can roll else it can't
	
	private JButton rollBtn; // rollButton of GTopBoard used to lock rollBtn when plyer click on it
	
	/**
	 * Init value of rolling to false
	 * Set rollBtn to JButton passed in parameter
	 * 
	 * @param rollBtn button on what player click
	 */
	public RollButton(JButton rollBtn) {
		this.rolling = false;
		this.rollBtn = rollBtn;
	}
	
	/**
	 *	Detect if player click on rollButton
	 *	if player click dice can roll
	 *	Disable button while dice rolling
	 */
	public void actionPerformed (ActionEvent e) {
		rollBtn.setEnabled(false);
		this.rolling = true;
	}
	
	/**
	 * Return value of rolling
	 * @return rolling indicates if the player clicked on this button
	 */
	public boolean getRoll () {
		return this.rolling;
	}
	
	/**
	 * Set rolling value, use it like reset of rolling value 
	 * between each turn
	 * 
	 * @param rolling in parameter becomes the value of the rolling of the class
	 */
	public void setRoll(boolean rolling) {
		this.rolling = rolling;
	}
}
