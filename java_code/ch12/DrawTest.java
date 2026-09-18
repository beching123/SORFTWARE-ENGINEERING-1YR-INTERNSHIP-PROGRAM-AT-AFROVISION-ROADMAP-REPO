// test application for automatic drawing app
package Chapter_twelve;

import javax.swing.JFrame;

public class DrawTest {
  
  public static void main(String[] args) {

    DrawFrame frame = new DrawFrame();
    frame.setSize(700, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
