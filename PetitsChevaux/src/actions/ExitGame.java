package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Quentin et Maxime
 * 
 * If this action is called it will end the program
 * We use it to close the game
 *
 */
public class ExitGame implements ActionListener{


	/**
	 * Exit program
	 */
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
