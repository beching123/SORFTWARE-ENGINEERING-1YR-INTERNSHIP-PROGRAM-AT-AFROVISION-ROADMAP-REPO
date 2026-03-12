// Fig. 6.12: DrawSmileyTest.java
// Test application that displays a smiley face.
import javax.swing.JFrame;

public class DrawSmileyTest {
  
  public static void main(String[] args){

    RandomShapes panel = new RandomShapes();
    JFrame application = new JFrame();

    application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    application.add(panel);
    application.setSize(230, 250);
    application.setVisible(true);

  }
}
