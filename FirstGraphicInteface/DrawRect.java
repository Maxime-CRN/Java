import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawRect extends JPanel{

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.black);
    g.drawRect(2,7,this.getWidth()-5,this.getHeight()-10);
  }

}
