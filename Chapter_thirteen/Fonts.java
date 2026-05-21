// Fig. 13.12: Font.java
// Using fonts.
package Chapter_thirteen;

import javax.swing.JFrame;

public class Fonts {
  
  // execute application
  public static void main(String[] args) {

    // create frame for FontJPanel
    JFrame frame = new JFrame("Using fonts");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    FontPanel fontJPanel = new FontPanel();
    frame.add(fontJPanel);

    frame.setSize(420, 150);
    frame.setVisible(true);
  }
} // end class
