package windows;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import actions.Button;



/**
 * @author Quentin et Maxime
 * 
 * Windows to select game level
 *
 */
public class SetupWindow extends JFrame {

	
	private static final long serialVersionUID = 2707248314881984572L;
	
	
	private Container c; //Contains all the window elements
	private int difficulty; //game difficulty
	
	private JLabel info; //Information of what do you do
	
	//Clicked on button events for each button
	private Button easy; //Event clicked on easy mode
	private Button normal; //Event clicked on normal mode
	private Button hard; //Event clicked on hard mode
	private Button night; //Event clicked on nightmare mode
	
	//Difficulty buttons
	private JButton easyBtn; //Button for easy mode
	private JButton normalBtn; //Button for normal mode
	private JButton hardBtn; //Button for hard mode
	private JButton nightBtn;  //Button for nightmare mode
	
	//Panels to set buttons at good place
	private JPanel easyBtnPan; //Panel to set easy button at good place with good size
	private JPanel normalBtnPan; //Panel to set normal button at good place with good size
	private JPanel hardBtnPan; //Panel to set hard button at good place with good size
	private JPanel nightBtnPan; //Panel to set nightmare button at good place with good size
	
	//Size of buttons
	private int widthBtn = 150; //Width for all buttons
	private int heightBtn = 40; //Height for all buttons

	
	
	public SetupWindow(){		
		//set label
		info = new JLabel("Choisissez le mode de jeu :");
		info.setFont(new Font("Arial",0, 20));
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setVerticalAlignment(SwingConstants.CENTER);
		
		//create button events
		easy = new Button();
		normal = new Button();
		hard = new Button();
		night = new Button();
		
		//create and resize buttons
		easyBtn = new JButton("Facile");
		easyBtn.setPreferredSize(new Dimension(widthBtn,heightBtn));
		
		normalBtn = new JButton("Normal");
		normalBtn.setPreferredSize(new Dimension(widthBtn,heightBtn));
		
		hardBtn = new JButton("Difficile");
		hardBtn.setPreferredSize(new Dimension(widthBtn,heightBtn));
		
		nightBtn = new JButton("Cauchemar");
		nightBtn.setPreferredSize(new Dimension(widthBtn,heightBtn));
				
				
		//set event on button
		easyBtn.addActionListener(easy);
		normalBtn.addActionListener(normal);
		hardBtn.addActionListener(hard);
		nightBtn.addActionListener(night);
				
				
		//create panel and add button
		easyBtnPan = new JPanel(new FlowLayout());
		easyBtnPan.add(easyBtn);
				
		normalBtnPan = new JPanel(new FlowLayout());
		normalBtnPan.add(normalBtn);
				
		hardBtnPan = new JPanel(new FlowLayout());
		hardBtnPan.add(hardBtn);
		
		nightBtnPan = new JPanel(new FlowLayout());
		nightBtnPan.add(nightBtn);
		
		
		
		//create container for all elements of the windows
		c = this.getContentPane();
		c.setLayout(new GridLayout(5,1));
		
		//add JPanel and buttons on window
		c.add(info);
		c.add(easyBtnPan);
		c.add(normalBtnPan);
		c.add(hardBtnPan);
		c.add(nightBtnPan);
		
		
		//window name
		setTitle("Configuration de la partie");
		//window size
		setSize(400,300);
		//set not resizable
		setResizable(false);
		//end of program when closing window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//show window
		setVisible(true);
		
		//init difficulty to 0
		difficulty =0;
		
		//loop while difficulty wasn't selected
		while(this.difficulty == 0) {
			System.out.print("");
			if(easy.get_clicked()) {
				difficulty =1;
			}
			else if(normal.get_clicked()) {
				difficulty =2;
			}
			else if(hard.get_clicked()) {
				difficulty =3;
			}
			else if(night.get_clicked()) {
				difficulty =4;
			}
		}
		
		//destroy window
		dispose();
		
	}

	
	/**
	 * @return difficulty level selected for game
	 */
	public int getDifficulty() {
		return difficulty;
	}

}

