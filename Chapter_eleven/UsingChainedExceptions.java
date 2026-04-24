package Chapter_eleven;
// Fig. 11.7: UsingChainedExceptions.java
// Chained exceptions.

public class UsingChainedExceptions {
  
  public static void main(String[] args) {

    try {
      method1();
    }

    catch (Exception exception) // exception thrown from method
    {
      exception.printStackTrace();
    }
  }

  // call method2; throw exceptions back to main
  public static void method1() throws Exception
  {
    try 
    {
      method2();
    } // end try

    catch (Exception exception) // exception thrown from method2
    {
      throw new Exception("Exception thrown in method", exception);
    }
  }

  // cal method3; throw exceptions back to method1
  public static void method2() throws Exception 
  {
    try 
    {
      method3();
    }
    catch(Exception exception) // exception thrown from method3
    {
      throw new Exception("Exception thrown in method2", exception);
    }
  }

  // throw Exception back to method2
  public static void method3() throws Exception
  {
    throw new Exception("Exception thrown in method3");
  }
} // end class UsingChainedException
