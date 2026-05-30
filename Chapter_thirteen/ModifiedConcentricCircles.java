// Exercise 13.7 ModifiedConcentricCircles.java 
package Chapter_thirteen;

// importing useful libraries
import java.awt.Graphics;
import java.security.SecureRandom;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class ModifiedConcentricCircles extends JPanel {

  @Override 
  public void paintComponent(Graphics g) {

    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    SecureRandom randomNumber = new SecureRandom();
    int shift = 200;
    int width = getWidth() / 4;
    int height = getHeight() / 4;

    for (int i = 0; i < 10; i ++) {
      g2d.setPaint(new Color(randomNumber.nextInt(256), randomNumber.nextInt(256), randomNumber.nextInt(256)));

      g2d.draw(new Ellipse2D.Double(width, height, shift, shift));

      shift -= 20;
      width += 10;
      height += 10;
    }

  }

  public static void main(String[] args) {


    JFrame frame = new JFrame("Concentric circles");
    ModifiedConcentricCircles app = new ModifiedConcentricCircles();
    frame.add(app);
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

  }
}
