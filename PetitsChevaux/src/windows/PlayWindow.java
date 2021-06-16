package windows;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import actions.Button;
import actions.ExitGame;
import actions.ShowRules;
import gameBoardComponents.GBotBoard;
import gameBoardComponents.GGameBoard;
import gameBoardComponents.GTopBoard;

/**
 * @author Quentin et Maxime
 * 
 * Game window
 *
 */
public class PlayWindow extends JFrame {
	
	
	private static final long serialVersionUID = 3327021125662171002L;
	
	private JMenuBar menubar; //menu bar at top of screen
	
	private JMenu options; //option for game
	private JMenu help; //help for game
	
	private JMenuItem restart; //item for restart game
	private JMenuItem exit; //item for exit game
	private JMenuItem helpWindow; //item for show rules of game
	
	private Button reset; //event click on restart
	private ExitGame quit; //event click on exit
	
	private GGameBoard gameBoard; //Game Board mid panel
	private GTopBoard tBoard; // Top Panel
	private GBotBoard bBoard; //Bottom panel

	private Container c; //Contains all the window elements

	
	
	
	/**
	 * @param tBoard the panel on the top of the window
	 * @param gameBoard the panel on the middle of the window
	 * @param bBoard the panel on the bottom of the window
	 * @param width width of the window
	 * @param height height of the window
	 */
	public PlayWindow(GTopBoard tBoard, GGameBoard winBoard, GBotBoard bBoard, int width, int height){
		
		//create container for all elements of the windows
		c = this.getContentPane();
    
		//BorderLayout because there is 3 parts on the windows 
		c.setLayout(new BorderLayout(0,0));
		
		this.tBoard = tBoard;
		
		//Game Board in the window
		this.gameBoard = winBoard;
		
		//ad information panel
		this.bBoard= bBoard;
		
		//create menu bar
		menubar = new JMenuBar();
		menubar.setSize(150,30);
		
		//add size of menubar
		height+=30;
		
		//Init and set options menu
		options = new JMenu("Options");
		
		//Init and set aide menu
		help = new JMenu("Aide");
		
		//set his items
		restart = new JMenuItem("Recommencer");	
		exit = new JMenuItem("Quitter");
		helpWindow = new JMenuItem("Règles");
		
		//add items in menus
		options.add(restart);
		options.add(exit);
		help.add(helpWindow);
		
		//init event click on restart
		reset = new Button();
		
		//init event click on exit
		quit = new ExitGame();		
		
		//set action
		restart.addActionListener(reset);
		exit.addActionListener(quit);
		helpWindow.addActionListener(new ShowRules());
		
		//add menus to menu bar
		menubar.add(options);
		menubar.add(help);
		
		c.add(menubar);
		setJMenuBar(menubar);
		
		c.add("North", this.tBoard.getPanel());
		//add on the middle of the window
		c.add("Center",this.gameBoard.getBoard());
		
		c.add("South", this.bBoard.getPanel());
		
		
		//window name
		setTitle("Petits Chevaux");
		//window size
		setSize(width,height);
		//set not resizable
		setResizable(false);
		//end of program when closing window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//show window
		setVisible(true);
	}


	
	/**
	 * Make an update of the window
	 * Update size to haven't display bug with new panel
	 * this function will be call after each turn
	 * 
	 * @param width width of the window
	 * @param height height of the window
	 */
	public void UpdateWindow(int width, int height) {
		//add size of menubar
		height+=30;
		//window size
		setSize(width,height);
		//update windows
		this.repaint();
		this.setVisible(true);
	}
	
	
	//getters for button
	///////////////////////////////////
	
	public boolean getRestart() {
		return reset.get_clicked();
	}
	
	//setters for button
	///////////////////////////////////
	public void setRestart() {
		reset.set_clicked(false);
	}
	

}
