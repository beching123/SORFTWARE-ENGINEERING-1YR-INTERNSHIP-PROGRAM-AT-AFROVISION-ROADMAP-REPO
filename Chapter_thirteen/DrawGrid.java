package Chapter_thirteen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.RenderingHints;

public class DrawGrid extends JPanel {
  
  @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    int width = getWidth();
    int height = getHeight();

    double rowHeight = (double) height / 2;
    double colWidth = (double) width / 2;

    g2d.setColor(Color.BLACK);
    g2d.setStroke(new BasicStroke(1.5f));

    for (int i = 0; i <= 8; i ++) {

      int currentY = (int) (i * colWidth);

      int currentX = (int) (i * rowHeight);

      g2d.drawLine(0, currentY, width, currentY);
      g2d.drawLine(currentX, 0, currentY, height);
    }
  }

  public static void main(String[] args) {

    JFrame frame = new JFrame ();

    DrawGrid panel = new DrawGrid();

    frame.add(panel);
    frame.setSize(450, 450);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
