import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class QuitButton implements ActionListener {
	@Override
	public void actionPerformed (ActionEvent e){
		System.out.println("End by QuitButton");
		System.exit(0);
	}
}
