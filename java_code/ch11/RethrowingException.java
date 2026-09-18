package Chapter_eleven;

public class RethrowingException {
  
  public static void someMethod() throws Exception {

    try {
      someMethod2();
    }

    catch(Exception exception) // exception thrown form method2 
    {
      throw new Exception("Exception thrown from method", exception);
    }

  }
  public static void someMethod2() throws Exception 
  {

    throw new Exception("Exception thrown in method2\n");
  }

  public static void main(String[] args) {

    try {

      someMethod();
    }

    catch(Exception e) {

      e.printStackTrace();
    
    }
  }
}
