package Chapter_thirteen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.BasicStroke;
import java.awt.geom.GeneralPath;

public class CubeDrawingApplication  extends JPanel {
  
  @Override 
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    int x1 = 120, y1 = 180;
    int x2 = 280, y2 = 180;
    int x3 = 280, y3 = 340;
    int x4 = 120, y4 = 340;

    int offset = 60;
    int bx1 = x1 + offset, by1 = y1 - offset;
    int bx2 = x2 + offset, by2 = y2 - offset;
    int bx3 = x3 + offset, by3 = y3 - offset;
    int bx4 = x4 + offset, by4 = y4 - offset;

    GeneralPath frontFace = new GeneralPath();
    frontFace.moveTo(x1, y1);
    frontFace.lineTo(x2, y2);
    frontFace.lineTo(x3, y3);
    frontFace.lineTo(x4, y4);
    frontFace.closePath();

    GeneralPath backFace = new GeneralPath();
    backFace.moveTo(bx1, by1);
    backFace.lineTo(bx2, by2);
    backFace.lineTo(bx3, by3);
    backFace.lineTo(bx4, by4);
    backFace.closePath();

    GeneralPath topFace = new GeneralPath();
    topFace.moveTo(x1, y1);
    topFace.lineTo(bx1, by1);
    topFace.lineTo(bx2, by2);
    topFace.lineTo(x2, y2);
    backFace.closePath();

    GeneralPath bottomFace = new GeneralPath();
    bottomFace.moveTo(x4, y4);
    bottomFace.lineTo(bx4, by4);
    bottomFace.lineTo(bx3, by3);
    bottomFace.lineTo(x3, y3);
    bottomFace.closePath();

    GeneralPath leftFace = new GeneralPath();
    leftFace.moveTo(x1, y1);
    leftFace.lineTo(bx1, by1);
    leftFace.lineTo(bx4, by4);
    leftFace.lineTo(x4, y4);
    leftFace.closePath();

    GeneralPath rightFace = new GeneralPath();
    rightFace.moveTo(x2, y2);
    rightFace.lineTo(bx2, by2);
    rightFace.lineTo(bx3, by3);
    rightFace.lineTo(x3, y3);
    rightFace.closePath();

    g2d.setColor(new Color(240, 240, 245));
    g2d.fill(backFace);
    g2d.fill(topFace);
    g2d.fill(leftFace);
    g2d.fill(rightFace);
    g2d.fill(bottomFace);
    g2d.fill(frontFace);

    g2d.setColor(Color.BLACK);
    g2d.setStroke(new BasicStroke(2.0f));
    g2d.draw(backFace);
    g2d.draw(topFace);
    g2d.draw(leftFace);
    g2d.draw(rightFace);
    g2d.draw(bottomFace);
    g2d.draw(frontFace);

  }

  public static void main(String[] args) {

    JFrame frame = new JFrame();
    CubeDrawingApplication panel = new CubeDrawingApplication();

    frame.add(panel);
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

  }
}
