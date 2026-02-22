// Fig. 4.20 CaptureTwo.java
// Modification of capture One so that the lines span from all 4 edges
import java.awt.Graphics;
import javax.swing.JPanel;

public class CaptureTwo extends JPanel {
  
  // redoing capture one but from all four edges
  public void paintComponent(Graphics g){

    // making sure paint component was properly called
    super.paintComponent(g);
    int width = getWidth();
    int height = getHeight();

    
    // this new width and height will ensure my line ends at the center
    int newWidth = width / 2;
    int newHeight = height / 2;

     //drawing a line at the center
    g.drawLine(0, 0, newWidth , newHeight );
    g.drawLine(width, height, newWidth , newHeight );
    g.drawLine(0, height, newWidth, newHeight);
    g.drawLine(width, 0, newWidth, newHeight);
      
    // dividing to have fixed intervals of spacing
    int x = newWidth / 8;
    int y = x;

    int z = height / 8;
    int w = z;

    // first while loop used to draw the line from center to bottom left side
    while (x <= newWidth){

      // drawing lines from top from center of the screen downwards towards the y axis.
      g.drawLine(0, 0, newWidth - x , newHeight + x );
      g.drawLine(width, height, newWidth - x , newHeight + x );
      g.drawLine(0, height, newWidth + x, newHeight + x);
      g.drawLine(width, 0, newWidth + x, newHeight + x);
      

      // incrementing x at y intervals
      x +=y;
      z +=w;
    }

    // since x will be updated after the loops finished in should go back to default value
    x = y;

    // loop used to draw the lines from center to top right
    while (x <= newWidth){

      // drawing lines from top from center of the screen downwards towards the y axis.
      g.drawLine(0, 0, newWidth + x , newHeight - x );
      g.drawLine(width, height, newWidth + x , newHeight - x );
        g.drawLine(0, height, newWidth - x, newHeight - x);
         g.drawLine(width, 0, newWidth - x, newHeight - x);
      
      // incrementing x at y intervals
      x +=y;
    }
  }
}
