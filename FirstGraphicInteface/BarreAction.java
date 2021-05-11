import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BarreAction{
	protected JPanel action;
	protected JButton quit;

	BarreAction(){
		action = new JPanel();

		quit = new JButton("Quitter");
		quit.addActionListener(new QuitButton());

		action.setLayout(new BorderLayout(320,5));
		action.add("North", new JPanel());
		action.add("South", new JPanel());
		action.add("East", new JPanel());
		action.add("West", new JPanel());
		action.add("Center",quit);
	}

	JPanel getPanel () {
		return action;
	}
}
