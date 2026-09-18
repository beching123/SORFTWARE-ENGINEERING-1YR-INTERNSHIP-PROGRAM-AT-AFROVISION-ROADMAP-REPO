// Exercise 13.31 Shapes2.java
// Demonstrating a general path using class shape2.java to test our code 
package Chapter_thirteen;

import java.awt.Color;
import javax.swing.JFrame;

public class Shape2 {

  public static void main(String[] args) {

    // create frame for Shapes2JPanel
    JFrame frame = new JFrame("Drawing 2D Shapes");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Shapes2JPanel shapes2JPanel = new Shapes2JPanel();
    frame.add(shapes2JPanel);
    frame.setBackground(Color.WHITE);
    frame.setSize(315, 300);
    frame.setVisible(true);
  }
}
