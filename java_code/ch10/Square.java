package Chapter_ten;
// exercise 10.13 extension of twoDimensionalShape

public class Square extends TwoDimensionalShapes {

  //instance variable for Circle
  private double side;

  public Square (String name, int x, int y, double side) {

    super(name, x, y);

    this.side = side;

  }

  // implementing the area method
  @Override
  public double getArea() {

    return side * side;
  }

  @Override 
  public double getPerimeter() {

    return 4 * side;

  }

  @Override
  public String toString() {

    return String.format("%s%n%s%.2f", super.toString(), "side: ", side);
  }
}