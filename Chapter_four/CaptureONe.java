// Fig. 4.20 CaptureONe.java
//Drawing multiple lines using looping statements
import java.awt.Graphics;
import javax.swing.JPanel;

public class CaptureONe extends JPanel {
  
  // draw many lines from the y axis all the way to the x axis
  public void paintComponent(Graphics g){
    
    // call paint component to ensure the panel displays correctly
    super.paintComponent(g);
    int width = getWidth();
    int height = getHeight();

    // this new width and height will ensure my line ends at the center
    int newWidth = width / 2;
    int newHeight = height / 2;

     //drawing a line at the center
    g.drawLine(0, 0, newWidth , newHeight );
    
    // dividing to have fixed intervals of spacing
    int x = newWidth / 8;
    int y = x;

    // first while loop used to draw the line from center to bottom left side
    while (x <= newWidth){

      // drawing lines from top from center of the screen downwards towards the y axis.
      g.drawLine(0, 0, newWidth - x , newHeight + x );

      // incrementing x at y intervals
      x +=y;
    }

    // since x will be updated after the loops finished in should go back to default value
    x = y;

    // loop used to draw the lines from center to top right
    while (x <= newWidth){

      // drawing lines from top from center of the screen downwards towards the y axis.
      g.drawLine(0, 0, newWidth + x , newHeight - x );

      
      // incrementing x at y intervals
      x +=y;
    }
  }
}
