package OPTIONAL_GUI;
// Exercise 8.1 MyOvals extension of MyLine program for optional GUI

import java.awt.Graphics;
import java.awt.Color;

public class MyOvals extends MyShape {
  
  private boolean fillShape; // used to determine whether a shape is filled or not


  public MyOvals () {

    super();
    fillShape = true;

  }

  public MyOvals (int x1, int y1, int x2, int y2, Color color, boolean fillShape) {

    super(x1, y1, x2, y2, color);
    this.fillShape = fillShape;
    System.out.printf("2");
       
  }

   public int getUpperLeftX (){

    return (getX1() <= getX2()) ? getX1(): getX2();

  }

  public int getUpperLeftY () {

    return (getY1() <= getY2()) ? getY1(): getY2();

  }

  public int getWidth() {

    return Math.abs(getX1() - getX2());

  }
  
  public int getHeight () {
 
    return Math.abs(getY1() - getY2());

  }

  // set method for fillShape
  public void setFillShape (boolean fillShape) {

    this.fillShape = fillShape;
    
  }

  // get method for fillShape
  public boolean getFillShape () {

    return fillShape;

  }

  

  // Draw the line in the specified color
  @Override
  public void draw(Graphics g) {

    g.setColor(getColor());

    if (getFillShape() == true) {

      g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());

    } else {

    g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());

    }
  }
}
