// optional gui 
// drawing rectangle spiral
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class DrawRectangularSpiral extends JPanel {
 
    public DrawRectangularSpiral() {

    setBackground(Color.WHITE); // set the background to white

  }
  
  public void paintComponent(Graphics g) {

    super.paintComponent(g); 

    int right;
    int left;
    int top;
    int bottom;

    int width = getWidth();
    int height = getHeight();

    top = height / 2;
    bottom = height / 2;

    left = width / 2;
    right = width / 2;
    
    g.setColor(Color.RED);

    while (top > 0 && right <= width) {
      g.drawLine (right, top, right,  bottom += 50);
      g.drawLine (right, bottom, left -= 50, bottom);

      g.drawLine(left, bottom, left, top -= 75);
      g.drawLine(left, top, right += 75, top);

    }
  }
}
