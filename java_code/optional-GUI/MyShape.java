package OPTIONAL_GUI;
// Exercise 10.17 modifications of exercise 8.1 and exercise 9.1 
import java.awt.Color;
import java.awt.Graphics;

public abstract class MyShape {
  
  private int x1; // x-coordinate of first endpoint
  private int y1; // y-coordinate of first endpoint
  private int x2; // x-coordinate of second endpoint
  private int y2; // y-coordinate of second endpoint
  private Color color; // color of this line


    // constructor that initializes the instance variables to the values supplied
  public MyShape (int x1, int y1, int x2, int y2, Color color) {

    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.color = color;
  
  }

  // no argument constructor that sets all the private variable to zero and the color to black
  public MyShape () {

    // initializing all the variables to default values
    x1 = 0;
    y1 = 0; 
    x2 = 0; 
    y2 = 0; 
    color = Color.BLACK;

  }


   // set methods
  public void setX1 (int x1) {

    if (x1 < 0)
      this.x1 = 0;
    else 
      this.x1 = x1;
  }

  public void setY1 (int y1) {

    if (y1 < 0)
      this.y1 = 0;
    else 
      this.y1 = y1;
  }

  public void setX2 (int x2) {

    if (x2 < 0)
      this.x2 = 0;
    else 
      this.x2 = x2;
  }

  public void setY2 (int y2) {

    if (y2 < 0)
      this.y2 = 0;
    else 
      this.y2 = y2;
  }

  public void setColor (Color color) {

    this.color = color;
    
  }


  // get method
  public int getX1 () {

    return x1;
  }

  public int getY1 () {

    return y1;
  }

  public int getX2 () {

    return x2;
  }

  public int getY2 () {

    return y2;

  }

  public Color getColor () {

    return color;

  }
  
  // abstract method draw which will be implemented by the subclasses
  public abstract void draw(Graphics g);

}
