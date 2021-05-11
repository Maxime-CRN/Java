import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Fenetre extends JFrame {
	protected BarreAction action;
	protected BarreEtat etat;
	protected EspaceTravail workspace;
	protected Container c;

	Fenetre(){
		c = this.getContentPane();
    //nom fenêtre
    setTitle("TP6");
    //taille fenêtre
    setSize(800, 700);
    //fin au programme si fermeture fenêtre
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		c.setLayout(new BorderLayout(0,0));

    action = new BarreAction();
		etat = new BarreEtat();
		workspace = new EspaceTravail();


		c.add("North",action.getPanel());
		c.add("Center", workspace.getPanel());
		c.add("South",etat.getPanel());

		this.setVisible(true);
		 	while(true){
				etat.printNewPos( workspace.getPosX(), workspace.getPosY());
			}
    }
}
