// exercise 6.2 Drawing random shapes
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.security.SecureRandom;

public class RandomShapes extends JPanel{

  SecureRandom randomNumbers = new SecureRandom();

  public void paintComponent(Graphics g){

    super.paintComponent(g);

    int width = getWidth();
    int height = getHeight();

    for (int i = 1; i <= 10; i ++){

      Color color = new Color(randomNumbers.nextInt(256),randomNumbers.nextInt(256),randomNumbers.nextInt(256));

      g.setColor(color);

      if (i % 2 == 0)
        g.fillOval(randomNumbers.nextInt(width), randomNumbers.nextInt(height), width / 2, height / 2);
        
      else
         g.fillRect(randomNumbers.nextInt(width), randomNumbers.nextInt(height), randomNumbers.nextInt(width / 4), randomNumbers.nextInt(height / 4));
    }

  }
  
}
