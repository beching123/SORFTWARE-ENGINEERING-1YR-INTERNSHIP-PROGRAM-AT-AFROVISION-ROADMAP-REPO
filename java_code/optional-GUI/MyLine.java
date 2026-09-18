package OPTIONAL_GUI;

// Fig 8.17: MyLine.java
// MyLine class represents a line
import java.awt.Color;
import java.awt.Graphics;

public class MyLine extends MyShape {

  // non argument constructor
  public MyLine () {

    super();
  }
  
  // constructor with input values
  public MyLine (int x1, int y1, int x2, int y2, Color myColor) {

 
    super(x1, y1, x2, y2, myColor);

  }

  // Draw the line in the specified color
  @Override
  public void draw(Graphics g) {

    g.getColor();
    g.drawLine(getX1(), getY1(), getX2(), getY2());

  }
} // end class MyLine
