// Exercise 13.9 RandomTriangle 
package Chapter_thirteen;

// importing useful libraries
import java.awt.Graphics;
import java.security.SecureRandom;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.BasicStroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.GeneralPath;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class RandomTriangles  extends JPanel{
  

   @Override 
  public void paintComponent(Graphics g) {

    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    SecureRandom randomNumber = new SecureRandom();
    GeneralPath[] rectangle = new GeneralPath[10];

    //int[] xPoints = {30, 30, 60};
    //int[] yPoints = {40, 50, 70};
    
    for (int j = 0; j < 10; j ++) {

      rectangle[j] = new GeneralPath();

      rectangle[j].moveTo(randomNumber.nextInt(getWidth()), randomNumber.nextInt(getHeight()));
      
      g2d.setColor(new Color (randomNumber.nextInt(256), randomNumber.nextInt(256), randomNumber.nextInt(256)));

      for (int i = 0; i < 2; i ++) 
        rectangle[j].lineTo(randomNumber.nextInt(100), randomNumber.nextInt(100));

      rectangle[j].closePath();
     

      g2d.fill(rectangle[j]);

    }
  }

  public static void main(String[] args) {


    JFrame frame = new JFrame("Concentric circles");
    RandomTriangles app = new RandomTriangles();
    frame.add(app);
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

  }
}
