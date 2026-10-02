// test application for automatic drawing app
// test application for PaintAppFrame.java
package java_code.ch22;

import javax.swing.JFrame;

public class PaintAppTest {
  
  public static void main(String[] args) {

    PaintAppFrame frame = new PaintAppFrame();
    frame.setSize(700, 700);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
