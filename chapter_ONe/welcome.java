package chapter_ONe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class welcome {
  public static void main(String[] args){
    //create JFrame (the window)
    JFrame application = new JFrame("A simple Paint Case Study");
    PaintPanel paintPanel = new PaintPanel();
    application.add(paintPanel, BorderLayout.CENTER);

    //create a label and place it in SOUTH of BorderLayout
    application.add(new JLabel("Drag the mouse to draw"), BorderLayout.SOUTH);

    application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    application.setSize(400,300);
    application.setVisible(true);
  }
}

//close the handle drawing logic 

class PaintPanel extends JPanel {
  private int pointCount = 0;
  //store coordinates in array (old school Deitel style)
  private int[] xpoints = new int[10000];
  private int[] ypoints = new int[10000];

  public PaintPanel() {
    //Handle mouse motion events
    addMouseMotionListener(
      new MouseMotionAdapter(){
        @Override public void mouseDragged(MouseEvent event) {
          if (pointCount < xpoints.length) {
            xpoints[pointCount] = event.getX();
            ypoints[pointCount] = event.getY();
            pointCount ++;
            repaint();//call paint components
          }
        }
      }
    );
  }
  //Draw the points
  @Override public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLUE);//set draw color to blue

    for (int i = 0; i < pointCount; i ++){
      g.fillOval(xpoints[i], ypoints[i], 4, 4);
    }
  }
}