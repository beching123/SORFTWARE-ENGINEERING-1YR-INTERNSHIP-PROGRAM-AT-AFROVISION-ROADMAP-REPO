// Fig. 4.21 CaptureThree.java
// using while loop and draw Line to come up with a new design
import java.awt.Graphics;
import javax.swing.JPanel;

public class CaptureThree extends JPanel {

  public void paintComponent(Graphics g){

    super.paintComponent(g);
    int width = getWidth();
    int height = getHeight();

    int x = width / 15;
    int y = height / 15;

    int i = x;
    int j = 0;
    int k = width;
    int l = height;

    while (i <= (width + x)){
      
      g.drawLine(0, j, i, height);
      g.drawLine(width, j, i , 0);
      g.drawLine(0, k ,i,0);
      g.drawLine(width, j, k, height);

      i +=x;
      j +=y;
      k -=y;
      l -=x;
    }
  }
}