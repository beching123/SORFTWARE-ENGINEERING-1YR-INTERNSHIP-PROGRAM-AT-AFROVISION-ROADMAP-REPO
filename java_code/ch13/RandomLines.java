// Exercise 13.7 ModifiedConcentricCircles.java 
package Chapter_thirteen;

// importing useful libraries
import java.awt.Graphics;
import java.security.SecureRandom;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.BasicStroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class RandomLines extends JPanel {

  @Override 
  public void paintComponent(Graphics g) {

    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    SecureRandom randomNumber = new SecureRandom();
    
    for (int i = 0; i < 10; i ++) {
      g2d.setPaint(new Color(randomNumber.nextInt(256), randomNumber.nextInt(256), randomNumber.nextInt(256)));

      g2d.setStroke(new BasicStroke (randomNumber.nextInt(20)));

      g2d.draw(new Line2D.Double(randomNumber.nextInt(getWidth()), randomNumber.nextInt(getHeight()), randomNumber.nextInt(500), randomNumber.nextInt(500)));


    }

  }

  public static void main(String[] args) {


    JFrame frame = new JFrame("Concentric circles");
    RandomLines app = new RandomLines();
    frame.add(app);
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

  }
}

