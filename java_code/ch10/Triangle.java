package Chapter_ten;
// exercise 10.13 extension of twoDimensionalShape

public class Triangle extends TwoDimensionalShapes {

  //instance variable for Circle
  private double base;
  private double leftSide;
  private double rightSide;

  public Triangle (String name, int x, int y, double base, double leftSide, double rightSide) {

    super(name, x, y);

    this.base = base;
    this.leftSide = leftSide;
    this.rightSide = rightSide;

  }

  // implementing the area method
  @Override
  public double getArea() {

    double semiPerimeter = getPerimeter() / 2;

    return Math.sqrt(semiPerimeter * (semiPerimeter - base) * (semiPerimeter - leftSide) * (semiPerimeter - rightSide));
  }

  @Override 
  public double getPerimeter() {

    return base + leftSide + rightSide;

  }

  @Override
  public String toString() {

    return String.format("%s%n%s%.2f  %.2f  %.2f", super.toString(), "sides: ", base, leftSide, rightSide);
  }
}