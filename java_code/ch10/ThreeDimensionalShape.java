package Chapter_ten;
// exercise 10.13 ThreeDimensionalShape.java
// extension of Shapes

public abstract class ThreeDimensionalShape extends Shape {

  // instance variable 
  private final int z;
  private final double dimension;

  // constructor 
  public ThreeDimensionalShape (String name, int x, int y, int z, double dimension) {

    super(name, x, y);
    
    this.z = z;
    this.dimension = dimension;

  }

  // get method for dimension
  public double getDimension() {

    return dimension;
  } 

  // abstract method all three shapes must implement
  @Override
  public abstract double getArea();

  public abstract double getVolume();

  @Override
  public String toString() {

    return String.format("%s%n%s%d%n%s%.2f", super.toString(), "Coordinate on the z-plane", z, "Dimension: ", getDimension());
  }

}