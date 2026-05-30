package Chapter_thirteen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;

public class DrawDoubleGrid extends JPanel {

  @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    double width = getWidth();
    double height = getHeight();

    double rowHeight = (double) height / 8.0;
    double colWidth = (double) width / 8.0;

    g2d.setColor(Color.BLACK);
    g2d.setStroke(new BasicStroke(1.5f));

    for (int i = 0; i <= 8; i ++) {

      double currentY = i * rowHeight;
      double currentX = i * colWidth;

      Line2D.Double horizontalLine = new Line2D.Double(0.0, currentY, width, currentY);
      g2d.draw(horizontalLine);

      Line2D.Double verticalLine = new Line2D.Double(currentX, 0.0, currentX, height);

      g2d.draw(verticalLine);
    }
  }
  
  public static void main(String[] args) {
    
    JFrame frame = new JFrame();
    DrawDoubleGrid panel = new DrawDoubleGrid();

    frame.add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(450, 450);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
