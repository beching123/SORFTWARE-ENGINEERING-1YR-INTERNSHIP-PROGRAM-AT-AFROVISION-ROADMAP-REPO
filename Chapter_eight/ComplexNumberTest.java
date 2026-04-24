package Chapter_eight;
import java.util.Scanner;

public class ComplexNumberTest {

  public Scanner input = new Scanner(System.in);
  
  public static void main (String[] args) {

    ComplexNumberTest myComplexNumber = new ComplexNumberTest ();

    myComplexNumber.menu();

  }

  public void menu () {

    System.out.println("Operations:");
    System.out.println("  1. Add two complex number. ");
    System.out.println("  2. Subtract two complex number.");
    System.out.print("Enter your option: ");
    int option = input.nextInt();

    switch (option) {

      case 1: 
        add();
        break;
      case 2: 
        subtract();
        break;
      default:
        System.out.println("Invalid option!!!");
        return;
    }

    menu();
  }

  public void add() {

    Complex complexNumber1 = new Complex(3,4);
    Complex complexNumber2 = new Complex();


    System.out.printf("Adding:\n ( %s ) + ( %s )\n\n", complexNumber1, complexNumber2);

    Complex complexNumber3 = new Complex((complexNumber1.getRealPart() + complexNumber2.getRealPart()), (complexNumber1.getImaginaryPart() + complexNumber2.getImaginaryPart()));

    System.out.printf("Result:\n %s\n", complexNumber3.toString());

    System.out.println();
    complexNumber1.printComplexNumber();
    System.out.println();
    complexNumber2.printComplexNumber();
    System.out.println();
    complexNumber3.printComplexNumber();
  }

    public void subtract() {

    Complex complexNumber1 = new Complex(2, 3);
    Complex complexNumber2 = new Complex();


    System.out.printf("Subtracting:\n ( %s ) + ( %s )\n\n", complexNumber1, complexNumber2);

    Complex complexNumber3 = new Complex((complexNumber1.getRealPart() + complexNumber2.getRealPart()), (complexNumber1.getImaginaryPart() + complexNumber2.getImaginaryPart()));

    System.out.printf("Result:\n %s\n\n", complexNumber3.toString());

    System.out.println();
    complexNumber1.printComplexNumber();
    System.out.println();
    complexNumber2.printComplexNumber();
    System.out.println();
    complexNumber3.printComplexNumber();
  }


}
