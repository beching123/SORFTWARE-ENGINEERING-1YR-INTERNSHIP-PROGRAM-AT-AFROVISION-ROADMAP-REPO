package Chapter_twelve;
// Fig. 12.40: FlowLayoutDemo.java
// TestingFlowLayoutFrame.
import javax.swing.JFrame;

public class FlowLayoutDemo {
  
  public static void main(String[] args) {

    FlowLayoutFrame flowLayoutFrame = new FlowLayoutFrame();
    flowLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    flowLayoutFrame.setSize(300, 75);
    flowLayoutFrame.setVisible(true);
  }
} // end class FlowLayoutDemo
