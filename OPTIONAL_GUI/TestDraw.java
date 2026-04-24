package OPTIONAL_GUI;

// Fig. 8.19: TestDraw.java
// Creating a JFrame to display a DrawPanel.
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.BorderLayout;

public class TestDraw {
  
  public static void main(String[] args) {

    String shapeNumber = JOptionPane.showInputDialog("Number of shapes you wish to draw ");

    DrawPanel panel = new DrawPanel(Integer.parseInt(shapeNumber));
    JFrame app = new JFrame();
    JLabel statusLabel = new JLabel(panel.statusText());


    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.add(panel);
    app.setSize(300, 300);
    app.add(statusLabel, BorderLayout.SOUTH);
    app.setVisible(true);
  }
} // end class TestDraw
