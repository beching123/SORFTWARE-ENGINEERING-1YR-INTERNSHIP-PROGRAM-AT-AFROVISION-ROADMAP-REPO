// Drawing 12 concentric circles with varying with varying sizes
import java.awt.Graphics;
import javax.swing.JPanel;

public class CirclesEXercise extends JPanel {
  
  public void paintComponent (Graphics g) {

    super.paintComponent(g);

    int i = 1;
    int radius;
    int edges;

    int width = getWidth();
    int height = getHeight();

    width /=2;
    height /=2;

    radius = 50;
    while (i <= 12){

      g.drawOval(width - radius, height - radius, 2 * radius, 2 * radius);
      
      i ++;
      radius += 10;

    }
  }
}
