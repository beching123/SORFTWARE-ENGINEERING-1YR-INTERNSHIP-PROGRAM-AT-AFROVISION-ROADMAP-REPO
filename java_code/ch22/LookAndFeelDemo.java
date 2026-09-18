// Fig. 22.10: lookAndFeelDemo.java
// Changing the look-and-feel.
package java_code.ch22;

import javax.swing.JFrame;

public class LookAndFeelDemo {

    public static void main(String[] args) {

        LookAndFeelFrame lookAndFeelFrame = new LookAndFeelFrame();
        lookAndFeelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lookAndFeelFrame.setSize(400, 220);
        lookAndFeelFrame.setVisible(true);
    }
} // end class LookAndFeelDemo
