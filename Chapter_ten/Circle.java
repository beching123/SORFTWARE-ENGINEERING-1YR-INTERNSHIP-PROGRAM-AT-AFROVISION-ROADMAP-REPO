package Chapter_ten;
// exercise 10.13 extension of twoDimensionalShape

public class Circle extends TwoDimensionalShapes {

  //instance variable for Circle
  private double radius;

  public Circle (String name, int x, int y, double radius) {

    super(name, x, y);

    this.radius = radius;

  }

  // implementing the area method
  @Override
  public double getArea() {

    return radius * radius * Math.PI;
  }

  @Override 
  public double getPerimeter() {

    return 2 * Math.PI * radius;

  }

  @Override
  public String toString() {

    return String.format("%s%n%s%.2f", super.toString(), "radius: ", radius);
  }
}