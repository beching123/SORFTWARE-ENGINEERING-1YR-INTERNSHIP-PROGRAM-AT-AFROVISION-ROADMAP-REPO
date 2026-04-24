package Chapter_ten;
// exercise 10.13 class TwoDimensionalShape.java
// extension of class Shape

public abstract class TwoDimensionalShapes extends Shape {

  public TwoDimensionalShapes (String type, int x, int y) {

    super (type, x, y);

  }

  // abstract method all two dimensional shape share in common
  @Override
  public abstract double getArea();

  // abstract method all two dimensional shape share in common
  public abstract double getPerimeter();

}