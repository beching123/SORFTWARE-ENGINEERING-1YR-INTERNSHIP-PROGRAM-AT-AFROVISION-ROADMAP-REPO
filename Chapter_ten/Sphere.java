package Chapter_ten;
// exercise 10.13 Sphere.java
// extension of ThreeDimensionalShape

public class Sphere extends ThreeDimensionalShape {

  // constructor
  public Sphere (String name, int x, int y, int z, double dimension) {

    super(name, x, y, z, dimension);

  }

  // implementing abstract method
  @Override 
  public double getArea() {

    return 4 * Math.PI * getDimension() * getDimension();

  }

  @Override 
  public double getVolume () {

    return ( 4 / 3 ) * Math.PI * Math.pow(getDimension(), 3);

  }
}