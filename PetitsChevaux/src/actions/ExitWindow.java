package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * @author Quentin et Maxime
 * 
 *If this action is called it will close windows set in win
 * We use it to close help page
 */
public class ExitWindow implements ActionListener{
	
	private JFrame win; //The window that will close when the button is pressed 
	
	/**
	 * Set currWindows to window passed in parameter
	 * 
	 * @param win set to window in parameter
	 */
	public ExitWindow(JFrame window) {
		this.win = window;
	}

	
	/**
	 * Close window
	 */
	public void actionPerformed(ActionEvent e) {
		win.dispose();
		
	}

}
