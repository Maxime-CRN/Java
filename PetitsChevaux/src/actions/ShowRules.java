package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import windows.HelpPageWindow;

/**
 * @author Quentin et Maxime
 * 
 * If this action is called it will open the help window
 */
public class ShowRules implements ActionListener{


	/**
	 * Launch help page
	 */
	public void actionPerformed(ActionEvent e) {
		@SuppressWarnings("unused")
		HelpPageWindow aide = new HelpPageWindow();
	}

}
