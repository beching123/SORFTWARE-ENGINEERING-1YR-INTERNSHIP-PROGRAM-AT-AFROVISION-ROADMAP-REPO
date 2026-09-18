package Chapter_eleven;

public class ExceptionTest2 {
  
  public static void main(String[] args) {

    try {

      throw new ExceptionA();

    }
    

 

    catch (ExceptionC e) {

    }

    
    catch (ExceptionB e) {
      
    }

    catch(ExceptionA e) {

    }
  }
}
