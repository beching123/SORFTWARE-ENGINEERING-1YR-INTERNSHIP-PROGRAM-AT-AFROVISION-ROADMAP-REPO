// Fig. 7.25: DrawRainbow.java
//Drawing a rainbow using arcs and an array of colors.
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class Rainbow  extends JPanel {
  
  //define indigo and violet
  private final static Color VIOLET = new Color(128, 0, 128);
  private final static Color INDIGO = new Color(75, 0, 130);

  // colors to use in the rainbow, starting from the innermost 
  // The two white entires in an empty arc in the center
  private Color[] Colors = {
    Color.WHITE, Color.WHITE, VIOLET, INDIGO, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED  
  };

  // constructor
  public Rainbow() {

    setBackground(Color.WHITE); // set the background to white

  }

  //draws a rainbow using concentric arcs
  public void paintComponent(Graphics g) {

    super.paintComponent(g);

    int radius = 20; // radius of an arc
    
    // draw the rainbow hear the bottom-center
    int centerX = getWidth() / 2;
    int centerY = getHeight() - 10;

    // draw filled arcs starting with the outermost
    for (int counter = Colors.length; counter > 0; counter --){

      // set the color for the current arc
      g.setColor(Colors[counter - 1]);

      // fill the arc from 0 to 180 degrees
      g.fillArc(centerX - counter * radius, centerY - counter * radius, counter * radius * 2, counter * radius * 2, 0, 180 );

    }
  } // end class rainbow
}
