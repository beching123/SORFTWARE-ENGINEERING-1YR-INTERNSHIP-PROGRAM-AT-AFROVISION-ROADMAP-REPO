package OPTIONAL_GUI;
// Extension of Fig 8.1
import java.awt.Color;
import java.awt.Graphics;

public class MyRectangle extends MyShape {

  private boolean fillShape; // used to determine whether a shape is filled or not

  public MyRectangle() {

    super();
    fillShape = true;
    
  }
  
  public MyRectangle (int x1, int y1, int x2, int y2, Color color, boolean fillShape) {

    super(x1, y1, x2, y2, color);
    this.fillShape = fillShape;
    System.out.printf("2");


  }

  // set method for fillShape
  public void setFilledShape (boolean fillShape) {

    this.fillShape = fillShape;

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

  // get method for fillShape that returns the value of fillShape
  public boolean getFilledShape() {

    return fillShape;

  }
  

  // Draw the line in the specified color
  @Override
  public void draw(Graphics g) {

    g.setColor(getColor());

    if (getFilledShape() == true) {

      g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());

    } else {

    g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());

    }
  }

}
