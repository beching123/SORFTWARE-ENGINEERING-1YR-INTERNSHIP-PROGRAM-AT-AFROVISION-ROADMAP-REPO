package Chapter_thirteen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

public class GridUsingRectDouble extends JPanel{

  
  @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    double width = getWidth();
    double height = getHeight();

    double cellWidth = width / 10;
    double cellHeight = height / 10;

    g2d.setColor(Color.BLACK);
    g2d.setStroke(new BasicStroke(1.5f));

    for (int row = 0; row < 10; row ++) {

      for (int col = 0; col < 10; col ++) {

        double x = col * cellWidth;
        double y = row * cellHeight;

        Rectangle2D.Double cell = new Rectangle2D.Double(x, y, cellWidth, cellHeight);

        g2d.draw(cell);
      }
    }
  }

  
  public static void main(String[] args) {
    
    JFrame frame = new JFrame();
    GridUsingRectDouble panel = new GridUsingRectDouble();

    frame.add(panel);
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
  
}
