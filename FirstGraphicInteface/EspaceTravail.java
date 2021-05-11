import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EspaceTravail{
	protected JPanel workspace;
  protected Mouse souri = new Mouse();

	EspaceTravail(){
		workspace = new DrawRect();
    workspace.setBackground(Color.white);
    workspace.addMouseMotionListener(souri);
		workspace.addMouseListener(souri);
	}

  public int getPosX(){
    return souri.getPosX();
  }

  public int getPosY(){
    return souri.getPosY();
  }

	JPanel getPanel () {
		return workspace;
	}
}
