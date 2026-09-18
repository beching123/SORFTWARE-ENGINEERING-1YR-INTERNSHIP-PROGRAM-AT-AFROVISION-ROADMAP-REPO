package Chapter_ten;
// exercise 10.13 Cube.java
// extension of ThreeDimensionalShape

public class Cube extends ThreeDimensionalShape {

  // constructor
  public Cube (String name, int x, int y, int z, double dimension) {

    super(name, x, y, z, dimension);

  }

  // implementing abstract method
  @Override 
  public double getArea() {

    return 6 * getDimension() * getDimension();

  }

  @Override 
  public double getVolume () {

    return getDimension() * getDimension() * getDimension();

  }
}