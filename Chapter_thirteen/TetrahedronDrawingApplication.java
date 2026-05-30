package Chapter_thirteen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;

public class TetrahedronDrawingApplication extends JPanel {
  
  @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    int centerX = getWidth() / 2;
    int centerY = getHeight() / 2;

    double[] xPoints = { centerX, centerX - 120, centerX + 120, centerX + 120};
    double[] yPoints = {centerY - 130, centerY + 80, centerY + 80, centerY - 10};

    GeneralPath face1 = new GeneralPath();
    face1.moveTo(xPoints[0], yPoints[0]);
    face1.lineTo(xPoints[1], yPoints[1]);
    face1.lineTo(xPoints[3], yPoints[3]);
    face1.closePath();


    GeneralPath face2 = new GeneralPath();
    face2.moveTo(xPoints[0], yPoints[0]);
    face2.lineTo(xPoints[2], yPoints[2]);
    face2.lineTo(xPoints[3], yPoints[3]);
    face2.closePath();

    GeneralPath face3 = new GeneralPath();
    face3.moveTo(xPoints[1], yPoints[1]);
    face3.lineTo(xPoints[2], yPoints[2]);
    face3.lineTo(xPoints[3], yPoints[3]);
    face3.closePath();

    GeneralPath face4 = new GeneralPath();
    face4.moveTo(xPoints[0], yPoints[0]);
    face4.lineTo(xPoints[1], yPoints[1]);
    face4.lineTo(xPoints[2], yPoints[2]);
    face4.closePath();

    g2d.setColor(new Color(100, 149, 237, 40));
    g2d.fill(face1);
    g2d.fill(face2);
    g2d.fill(face3);
    g2d.fill(face4);

    g2d.setColor(Color.BLACK);
    g2d.setStroke(new BasicStroke(2.0f));
    g2d.draw(face1);
    g2d.draw(face2);
    g2d.draw(face3);
    g2d.draw(face4);  

  }

  public static void main(String[] args) {

    JFrame frame = new JFrame();
    TetrahedronDrawingApplication panel = new TetrahedronDrawingApplication();

    frame.add(panel);
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
