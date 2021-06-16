package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Quentin et Maxime
 * 
 * Using boolean to know if player clicked on it or not
 *
 */
public class Button implements ActionListener{
	
	private boolean clicked;//Indicates if the player selected this button or not
	
	/**
	 * Init clicked to false
	 */
	public Button(){
		clicked = false;
	}
	
	/**
	 *	Detect if player click on difficultyButton
	 *	if player click set clicked on true
	 */
	public void actionPerformed (ActionEvent e) {
		clicked = true;
	}
	
	/**
	 * Return value of clicked
	 * 
	 * @return clicked indicates if the player clicked on this button
	 */
	public boolean get_clicked() {
		return clicked;
	}
	
	/**
	 * Set value of clicked to value passed in parameter
	 * 
	 * @param clicked in parameter becomes the value of the clicked of the class
	 */
	public void set_clicked(boolean clicked) {
		this.clicked = clicked;
	}

}
