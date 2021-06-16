package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import actions.ExitWindow;

/**
 * @author Quentin et Maxime
 * 
 * Help page window show game rules to player who's open it
 *
 */
public class HelpPageWindow extends JFrame {
	

	private static final long serialVersionUID = 3121026746422673671L;
	
	
	
	//We use html so that the text is formatted in the JLabel
	private final String gameRules = "<html>"
			+ "<style> p{margin:10;} </style>"			
			+ "<p>Bienvenue au jeu des petits chevaux !</p>"
			+ "<p><br>Dans cette version du jeu vous incarnez le joueur rouge (représenté par le symbole 'R')</p>"
			+ "<p>Votre objectif est d'atteindre votre case bleu clair avant que votre adversaire le joueur bleu (représenté par le symbole 'B') n'atteigne la sienne.</p>"
			+ "<p>Mais attention car sur votre chemin est parsemé d'embuches...</p></html>"; //Rules of game
	
	
	//We use html so that the text is formatted in the JLabel
	private final String cellRules = "<html>"
			+ "<style> p{margin:10;} "
			+ "p{margin:10;}"
			+ "<p>Voici le code couleur qui correspond aux cases :</p>"
			+ "<p><br>Bleu clair : case d'arrivée</p>"
			+ "<p>Vert : mur et écurie uniquement pour le départ de la partie ; pour sortir de l'écurie un joueur doit obtenir un 6</p>"
			+ "<p>gris clair : case libre</p>"
			+ "<p>Blanc : case pour \"aéréer\" le jeu</p>"
			+ "<p>Rose : case départ</p>"
			+ "<p>Bleu foncé : case rivière ; le joueur ne peut sortir de cette case que s'il obtient un nombre pair</p>"
			+ "<p>Jaune : case trou ; le joueur dois attendre 3 tours avant de pouvoir sortir celle-ci</p>"
			+ "<p>Gris foncé : case haie ; le joueur ne peut sortir de cette case que s'il obtient un nombre impair</p></html>"; //Cell documentation
	
	
	private JLabel title1; //Title label on top of window
	private JLabel rules; //Game rules label just next to title1 
	
	private JLabel title2; //Title label on center of window
	private JLabel explanations; //Cell documentation label just next to title2
	
	private JPanel btn; //Panel for button
	private JPanel r;	//Panel for rules
	private JPanel e;	//Panel for explanations
	
	private JButton understand; //Button "J'ai compris" user to close this window
	
	private Container c; //Contains all the window elements
	
	
	
	public HelpPageWindow() {
		//window size
		setSize(550,750);
		
		//Create panels and set layouts
		btn = new JPanel();
		btn.setLayout(new FlowLayout());
		r = new JPanel();
		r.setLayout(new BorderLayout());
		e = new JPanel();
		e.setLayout(new BorderLayout());
		
		//create and set understand button
		//use it to close rules windows
		understand = new JButton("J'ai compris !");
		understand.setPreferredSize(new Dimension(200,50));
		understand.addActionListener(new ExitWindow(this));
		btn.add(understand);
		
		//create and set Labels
		title1 = new JLabel("<html><p>Règles du jeu :</p></html>");
		title1.setPreferredSize(new Dimension(500,25));
		title1.setFont(new Font("Arial", Font.BOLD, 20));
		title1.setForeground(Color.red);
		title1.setHorizontalAlignment(SwingConstants.CENTER);
		r.add("North",title1);
		
		title2 = new JLabel("<html><p>Fonctionnement des cases :</p></html>");
		title2.setPreferredSize(new Dimension(500,20));
		title2.setFont(new Font("Arial", Font.BOLD, 17));
		title2.setForeground(Color.black);
		title2.setHorizontalAlignment(SwingConstants.CENTER);
		e.add("North",title2);
		
		rules = new JLabel(gameRules);
		rules.setPreferredSize(new Dimension(400,220));
		rules.setForeground(new Color(70,70,70));
		rules.setHorizontalAlignment(SwingConstants.CENTER);
		r.add("Center",rules);
		
		explanations = new JLabel(cellRules);
		explanations.setHorizontalAlignment(SwingConstants.CENTER);
		explanations.setForeground(new Color(70,70,70));
		explanations.setPreferredSize(new Dimension(400,400));
		e.add("Center",explanations);
		
		//create and set container
		c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		c.add("North",r);
		c.add("Center",e);
		c.add("South",btn);
				
				
		//window name
		setTitle("Règle");
		//set not resizable
		setResizable(false);
				
		//show window
		setVisible(true);
	
	}
	

}
