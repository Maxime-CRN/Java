import java.awt.event.MouseListener;
import java.awt.event.*;

public class Mouse extends MouseAdapter implements MouseMotionListener, MouseListener{
  protected int posX = 0;
  protected int posY = 0;

  public void mouseExited(MouseEvent e){
    posX = -1;
    posY = -1;
  }

	public void mouseMoved(MouseEvent e){
    posX = e.getX();
    posY = e.getY();
  }

  public void mouseDragged(MouseEvent e){
    posX = e.getX();
    posY = e.getY();
  }

  public int getPosX(){
    return posX;
  }

  public int getPosY(){
    return posY;
  }

}
