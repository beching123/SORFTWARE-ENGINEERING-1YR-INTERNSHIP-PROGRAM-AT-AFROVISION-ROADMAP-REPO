package Chapter_thirteen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.RenderingHints;

public class GridUsingRect  extends JPanel {
  
  @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    int width = getWidth();
    int height = getHeight();

    int cellWidth = width / 10;
    int cellHeight = height / 10;

    g2d.setColor(Color.BLACK);
    g2d.setStroke(new BasicStroke(1.5f));

    for (int row = 0; row < 10; row ++) {

      for (int col = 0; col < 10; col ++) {

        int x = col * cellWidth;
        int y = row * cellHeight;

        g2d.drawRect(x, y, cellWidth, cellHeight);
      }
    }
  }

  public static void main(String[] args) {
    
    JFrame frame = new JFrame();
    GridUsingRect panel = new GridUsingRect();

    frame.add(panel);
    frame.setSize(450, 450);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
