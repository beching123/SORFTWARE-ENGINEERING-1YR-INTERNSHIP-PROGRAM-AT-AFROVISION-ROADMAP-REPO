package Chapter_thirteen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.util.Random;

public class RandomCharacter extends JPanel {
  
  // Number of random characters we want to draw on the screen
  private static final int NUMBER_OF_CHARACTER = 30;

  @Override
  public void paintComponent(Graphics g) {

    // always call super paintComponent first to clear the old screen background
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;

    // enable aliasing son the t3est edges look smooth and crisp, not blocky
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // initialize the random number
    Random random = new Random();

    // get the current width and height
    int width = getWidth();
    int height = getHeight();

    // array of standard , safe font families available
    String[] fontNames = {"Serif", "SansSerif", "Monospaced", "Dialog"};

    // loop to generate and draw eah character individually
    for (int i = 0; i < NUMBER_OF_CHARACTER; i ++) {

      char randomChar = (char) ('A' + random.nextInt(26));
      String text = String.valueOf(randomChar);

      int red = random.nextInt(256);
      int green = random.nextInt(256);
      int blue = random.nextInt(256);

      Color randomColor = new Color(red, green, blue);

      String randomFontName = fontNames[random.nextInt(fontNames.length)];

      int randomStyle = random.nextInt(3);

      // randomly select between 12pt to 72pt
      int randomSize = 12 + random.nextInt(61);

      Font randomFont = new Font(randomFontName, randomStyle, randomSize);

      // generating random position 
      int x = random.nextInt(width - 20);
      int y = random.nextInt(height - 20) + 15;

      // apply the custom color and font to our virtual pen
      g2d.setColor(randomColor);
      g2d.setFont(randomFont);

      // draw the text in the canvas
      g2d.drawString(text, x, y);
    }
  }

  public static void main(String[] args) {

    JFrame frame = new JFrame("Random Generated character");

    RandomCharacter panel = new RandomCharacter();

    frame.add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 400);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    
  }
}
