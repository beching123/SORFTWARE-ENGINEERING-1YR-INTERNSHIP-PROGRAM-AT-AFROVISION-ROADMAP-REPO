package Chapter_eleven;
// demonstrating Constructor exception.

public class SomeClass {
  
  private int num;
  private String string;

  public SomeClass(int num, String string) throws ArithmeticException {

    this.num = num / num;
    this.string = string;

    

  }

  public static void main(String[] args)  {

    try {

      SomeClass someClass = new SomeClass(0, "name");

      System.out.println("Caught an error");
    }

    catch(ArithmeticException e) {

      System.out.println("Caught arithmetic error");
    }
  }
  
}
