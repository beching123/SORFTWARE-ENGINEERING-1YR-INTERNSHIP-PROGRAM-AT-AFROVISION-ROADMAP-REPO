// EXercise 13.6 Concentric circles using method drawArc
package Chapter_thirteen;

// importing useful libraries
import java.awt.Graphics;
import java.security.SecureRandom;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class ConcentricCircles extends JPanel {

  @Override 
  public void paintComponent(Graphics g) {

    super.paintComponent(g);

    SecureRandom randomNumber = new SecureRandom();
    int shift = 200;
    int width = getWidth() / 4;
    int height = getHeight() / 4;

    for (int i = 0; i < 10; i ++) {
      g.setColor(new Color(randomNumber.nextInt(256), randomNumber.nextInt(256), randomNumber.nextInt(256)));

      g.fillArc(width, height, shift, shift, 0, 360);

      shift -= 20;
      width += 10;
      height += 10;
    }

  }

  public static void main(String[] args) {


    JFrame frame = new JFrame("Concentric circles");
    ConcentricCircles app = new ConcentricCircles();
    frame.add(app);
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

  }
}