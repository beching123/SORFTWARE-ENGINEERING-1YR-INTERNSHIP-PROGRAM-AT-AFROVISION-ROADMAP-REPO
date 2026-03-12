// Fig. 6.13 A bull-eye with two alternating colors.
  
// Drawing 12 concentric circles with varying with varying sizes
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.security.SecureRandom; // program uses class SecureRandom

public class ColoredCircle extends JPanel {

  SecureRandom randomNumbers = new SecureRandom(); 
  public void paintComponent (Graphics g) {

    super.paintComponent(g);
    int a;
    int b;
    int radius;
    int edges;

    int width = getWidth();
    int height = getHeight();

    Color color1 = new Color(randomNumbers.nextInt(256),randomNumbers.nextInt(256),randomNumbers.nextInt(256));

    Color color2 = new Color(randomNumbers.nextInt(256),randomNumbers.nextInt(256),randomNumbers.nextInt(256));

    a = 10;
    b = 10;
    for (int i = 1; i <= 5; i ++){

      if (i % 2 != 0)
        g.setColor(color1);

      else
        g.setColor(color2);

      g.fillOval(a, b, width, height);

      a += 10;
      b += 10;
      width -=20;
      height -= 20;
    }  
  }
}

