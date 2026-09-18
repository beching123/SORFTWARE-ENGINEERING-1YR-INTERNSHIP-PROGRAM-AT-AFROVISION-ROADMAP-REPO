// OOP Assignment creation of a simple calculator application using java 
// Calculator.java
public class Calculator {

  // instance variables which are used to hold the numbers which will used in the various arithmetic
  // operation and result variable which will be used to hold the result of calculation
  private double numberOne;
  private double numberTwo;
  private double result;

  // no argument constructor called when no parameter are passed during the instantiation of calculator
  public Calculator () {

    this(1,1);
  }
  
  // 2 argument constructor used to initialize the instance variable 
  public Calculator (double numberOne, double numberTwo) {

    // calling the set method of numberOne for good programming practice
    setNumberOne(numberOne); // calling the set method for numberOne for good programming practice
    setNumberTwo(numberTwo); // calling the set method for numberTwo for good programming practice

  }

  // set method for numberOne
  public void setNumberOne(double numberOne) {

    this.numberOne = numberOne;

  }

  // set method for numberTwo
  public void setNumberTwo (double numberTwo) {

    this.numberTwo = numberTwo;

  }

  // set method for result
  public void setResult(double result) {

    this.result = result;
  } 

  //get method for numberOne used to allow other method get access to the 
  // numberOne variable
  public double getNumberOne() {

    return numberOne;
  }

  // get method for numberTwo, used to allow other method get access to the 
  // numberTwo variable
  public double getNumberTwo () {

    return numberTwo;
  }

  // get method used to get the value of our result
  public double getResult() {

    return result;
  }

  // method addition used to add the two numbers
  public double addition() {

    return getNumberOne() + getNumberTwo();

  }

  // method subtraction used to find the difference between the two numbers
  public double subtraction() {

    return getNumberOne() - getNumberTwo();

  }

  // method multiplication used to find the product between two numbers
  public double multiplication() {

    return getNumberOne() * getNumberTwo();

  }

  // method division used to find the quotient between the two numbers
  public double division () {

    // testing for division by 0 and preventing it
    if (getNumberTwo() == 0) 
      throw new IllegalArgumentException ("Sorry! Division by zero is not possible");
    
    return getNumberOne() / getNumberTwo();

  }

  // method to print the calculator menu to the user
  public void menu () {

    System.out.println();System.out.println();
    System.out.println("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n");
    System.out.print("Enter your choice: ");

  }  

  // method used to perform the operation chosen by the user
  public double performOperation(int choice) {

     // switch case used to determine the type of operation to do
    switch (choice) {

      // case one for addition
      case 1:
        setResult(addition());
        break;
      //case two subtraction
      case 2:
        setResult(subtraction());
        break;
      //case three multiplication
      case 3:
        setResult(multiplication());
        break;
      //case four division
      case 4:
        setResult(division());
        break;
      // default case for none valid choice
      default:
        throw new IllegalArgumentException("Invalid choice!");
    }

    return getResult();
  }

} // end of class calculator