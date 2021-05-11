import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class BarreEtat {
	protected JPanel etat;
	protected JLabel textCX;
	protected JTextField coordX;
	protected JLabel textCY;
	protected JTextField coordY;

	BarreEtat(){
		etat = new JPanel();

		textCX= new JLabel("Coord. X");
		coordX = new JTextField("start",5);

		textCY= new JLabel("Coord. Y");
		coordY = new JTextField("start",5);

		etat.setLayout(new FlowLayout());

		etat.add(textCX);
		etat.add(coordX);
		etat.add(textCY);
		etat.add(coordY);
	}

	void printNewPos(int newX, int newY){
		if(newX < 0 || newY < 0){
			coordX.setText("out");
			coordY.setText("out");
			coordX.repaint();
			coordY.repaint();
		}
		else{
			coordX.setText(""+newX);
			coordY.setText(""+newY);
			coordX.repaint();
			coordY.repaint();
		}

	}

	JPanel getPanel (){
		return etat;
	}
}
