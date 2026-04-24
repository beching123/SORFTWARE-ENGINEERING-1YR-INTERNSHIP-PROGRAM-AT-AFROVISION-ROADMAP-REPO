package Chapter_ten;
// continuation of exercise 10.13
// ShapeTest.java that brings all the shape together via polymorphism

public class ShapeTest {

  public static void main(String[] args) {

    System.out.println("Shapes");
    System.out.println();

    // array of shapes
    Shape[] shapes = new Shape[6];
    
    // shape variables assigned to concrete shapes
    shapes[0] = new Circle ("Circle", 8, 10, 2.45);
    shapes[1] = new Square("Square", 3, 20, 15);
    shapes[2] = new Triangle("Triangle", 3, 1, 10, 13, 13);
    shapes[3] = new Sphere ("Sphere", 1, 10, 2, 15.66);
    shapes[4] = new Cube("Cube", 4, 3, 6, 10);
    shapes[5] = new Tetrahedron("Tetrahedron", 1, 0, 5, 20);


    for(Shape shape: shapes) {

      System.out.printf("%s%n", shape.toString());
      if (shape instanceof ThreeDimensionalShape) {

        ThreeDimensionalShape threeDimensionalShape = (ThreeDimensionalShape) shape;

        System.out.printf("%s%.2f%n%s%.2f%n%n", "Area: ", threeDimensionalShape.getArea(), "Volume: ", threeDimensionalShape.getVolume());
      }

      else {
        System.out.printf("%s%.2f%n%n", "Area: ", shape.getArea());
      }
    }

    
  }
}