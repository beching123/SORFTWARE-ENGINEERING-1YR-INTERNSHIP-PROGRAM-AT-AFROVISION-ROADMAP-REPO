// Fig. 13.6: ShowColors.java
// Demonstrating Colors.
package Chapter_thirteen;

import javax.swing.JFrame;

public class ShowColors {
  
  // exercise application
  public static void main(String[] args) {

    // create frame for ColorJPanel
    JFrame frame = new JFrame("Using colors");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ColorPanel colorPanel = new ColorPanel();
    frame.add(colorPanel);
    frame.setSize(400, 180);
    frame.setVisible(true);
  }
} // end class ShowColors
