package OPTIONAL_GUI;

// Fig. 8.18: DrawPanel.java
// Program that uses class MyLine
// to draw random lines.
import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;
import javax.swing.JPanel;



public class DrawPanel  extends JPanel {
  
  private SecureRandom randomNumber = new SecureRandom();
  private MyShape[] shapes = new MyShape[3]; // shape variable to be used to polymorphically hold shapes 
  private int[] shapesNumber = new int[3];
  private int shapeNumber; // for the number of shape the user wish to draw

  // constructor. creates a panel with random shapes
  public DrawPanel(int shapeNumber) {

    setBackground(Color.WHITE);
    this.shapeNumber = shapeNumber;

    // polymorphically assigning shapes to the MyShape variables
    shapes[0] = new MyLine();
    shapes[1] = new MyOvals();
    shapes[2] = new MyRectangle();
    
  }
  // for each shape array, draw the individual shapes
  public void paintComponent(Graphics g) {

    super.paintComponent(g);

    for (int i = 0; i < shapeNumber; i ++) {

      Color color = new Color(randomNumber.nextInt(256),randomNumber.nextInt(256),randomNumber.nextInt(256));

      int randomShape = randomNumber.nextInt(3);

      if (randomShape == 0) {

        shapes[randomShape] = new MyLine(randomNumber.nextInt(300), randomNumber.nextInt(300), randomNumber.nextInt(300), randomNumber.nextInt(300), color);
        ++ shapesNumber [0];
        shapes[0].draw(g);

      }

      else if (randomShape == 1) {

        shapes[randomShape] = new MyOvals(randomNumber.nextInt(300), randomNumber.nextInt(300), randomNumber.nextInt(300), randomNumber.nextInt(300), color, true);
        ++ shapesNumber [1];
        shapes[1].draw(g);
        

      }

      else if (randomShape == 2){

        shapes[randomShape] = new MyRectangle(randomNumber.nextInt(300), randomNumber.nextInt(300), randomNumber.nextInt(300), randomNumber.nextInt(300), color, true);
        ++ shapesNumber [2];
        shapes[2].draw(g);
        
      }
    }
  }
  
  // string method that return the number of lines, rectangle, ovals
  public String statusText () {

    return String.format("%s: %d, %s: %d, %s: %d", "Lines", shapesNumber[0], "Ovals", shapesNumber[1], "Rectangle", shapesNumber[2]);

  }
} // end class DrawPanel
