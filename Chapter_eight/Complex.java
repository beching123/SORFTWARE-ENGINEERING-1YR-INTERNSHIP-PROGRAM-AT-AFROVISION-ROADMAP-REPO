package Chapter_eight;
// Exercise Complex.java
// Writing a complex number class that perform coplex calculation

public class Complex {

  // instance variable which will be used hold the parts of our complex number;
  private double realPart;
  private double imaginaryPart;

  public Complex () {

    this(1, 1);

  }

  public Complex (double realPart, double imaginaryPart) {

    this.realPart = realPart;
    this.imaginaryPart = imaginaryPart;

  }

  public double getRealPart () {

    return realPart;
  }

  public double getImaginaryPart () {

    return imaginaryPart;

  }

  public void setRealPart (double realPart) {

    this.realPart = realPart;

  }

  public void setImaginaryPart (double imaginaryPart) {

    this.imaginaryPart = imaginaryPart;

  }

  public String toString() {

    return String.format("%.1f + %.1fi", realPart, imaginaryPart);

  }

  public void printComplexNumber () {

    System.out.printf("( %.1f, %.1f )\n",realPart, imaginaryPart);

  }

}