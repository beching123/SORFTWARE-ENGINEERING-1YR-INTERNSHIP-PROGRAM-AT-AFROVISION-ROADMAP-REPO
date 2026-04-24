package Chapter_ten;
// exercise 10.13 Shape.java
// abstract method for all the shape

public abstract class Shape {

  // instance variables 
  private final String type;
  private final int x;
  private final int y;

  // constructor
  public Shape (String type, int x, int y) {

    this.type = type;
    this.x = x;
    this.y = y;

  }

  // abstract method
  public abstract double getArea();

  @Override
  public String toString() {

    return String.format ("%n%s%s%n%s%d%n%s%d", "Name: ", type, "Coordinate on the x-plane: ", x, "Coordinate on the y-plane: ", y);
  }
}