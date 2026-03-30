package Chapter_eight;

public class Rectangle {
  
  // attribute of the class
  private double width;
  private double length;

  // constructor used to initialized them to a default value of 1.0
  public Rectangle () {

    // initializing variables
    width = 1.0;
    length = 1.0;
    
  }

  // method to calculate the area of a rectangle
  public double area() {

    return length * width;

  }

  // method to calculate the perimeter of a rectangle
  public double perimeter () {

    return 2 * length * width; 
  } 

  // set method for length 
  public void setLength (double length) {

    if (length < 1.0 || length > 20.0) {

      this.length = 1.0;

    } else {
      
      this.length = length;
        
    }
  }

    // set method for width
  public void setWidth (double width) {

    if (width < 1.0 || width > 20.0) {

      this.width = 1.0;

    } else {
      
      this.width = width;
        
    }
  }

  // get method for length
  public double getLength () {

    return length;
  }

  // get method for width
  public double getWidth () {

    return width;
    
  }

}
