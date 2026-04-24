package Chapter_ten;
// exercise 10.13 Tetrahedron.java
// extension of ThreeDimensionalShape

public class Tetrahedron extends ThreeDimensionalShape {

  // constructor
  public Tetrahedron (String name, int x, int y, int z, double dimension) {

    super(name, x, y, z, dimension);

  }

  // implementing abstract method
  @Override 
  public double getArea() {

    return Math.sqrt(3) * Math.pow(getDimension(), 2);

  }

  @Override 
  public double getVolume () {

    return Math.pow(getDimension(), 3) / (6 * Math.sqrt(2));

  }
}