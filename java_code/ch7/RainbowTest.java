// Fig. 7.26: RainbowTest.java
// Test application to display a rainbow

import javax.swing.JFrame;

public class RainbowTest {
  

  public static void main(String[] args) {

    drawSpiralArgs panel = new drawSpiralArgs();
    JFrame application = new JFrame();
    
    application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    application.add(panel);
    application.setSize(400, 250);
    application.setVisible(true);

  }
} // end class DrawRainbowTest
