package Chapter_eleven;
// testing the exception files created

import java.io.IOException;

public class ExceptionATest {

  public static void main(String[] args) {

    try {

     System.out.print("Throwing Exception C") ;
     // even though exception A will be thrown
     throw new ExceptionA();
     
    }

    catch(ExceptionA e) {

      System.out.println("\nCaught an Exception");

      System.out.println("The exception caught was of type " + e.getClass().getSimpleName());
      

    }

    try {
      System.out.println("Throwing exception B");
      throw new ExceptionB();
    }

    catch (ExceptionB e) {
      System.out.println("\nCaught an Exception");
      
      System.out.println("The exception caught was of type " + e.getClass().getSimpleName());
      
    }

    
    try {
      System.out.println("Throwing exception B");
      throw new NullPointerException();
    }

    catch (NullPointerException e) {
      System.out.println("\nCaught an Exception");
      
      System.out.println("The exception caught was of type " + e.getClass().getSimpleName());
      
    }

    
    try {
      System.out.println("Throwing exception B");
      throw new IOException();
    }

    catch (IOException e) {
      System.out.println("\nCaught an Exception");
      
      System.out.println("The exception caught was of type " + e.getClass().getSimpleName());
      
    }
  }

  public static void method1() throws ExceptionA {

    
  }
}
