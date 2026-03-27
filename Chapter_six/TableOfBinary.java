// exercise 6.34 number system
// TableOfBinary.java


public class TableOfBinary {

  
  public String decimalToBinary (int number) {

    if (number == 0) {
      return "0";
    }

    StringBuilder binary = new StringBuilder();

    while (number > 0) {

      int remainder = number % 2;
      
      binary.append(remainder);

      number /= 2;
    }

    return binary.reverse().toString();

  }

  public String decimalToOctal (int number) {

    if (number == 0) {
      return "0";
    }

    StringBuilder octal = new StringBuilder();

    while (number > 0) {

      int remainder = number % 8;

      octal.append(remainder);
      number /= 8;

    }

    return octal.reverse().toString();

  }
  public String decimalToHexadecimal (int number) {

    char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    
    if (number == 0) 
      return "0";

    StringBuilder hex = new StringBuilder();

    while (number > 0) {

      int remainder = number % 16;

      hex.append(hexChars[remainder]);
      number /= 16;

    }

    return hex.reverse().toString();

  }

  public static void main(String[] args) {

    System.out.printf("\n%10s|%10s|%10s|%10s", "Decimal", "Binary", "Octal", "Hexadecimal");
    System.out.println();

    TableOfBinary number = new TableOfBinary();


    for (int i = 0; i <= 256; i ++) {

      System.out.printf("\n%10s|%10s|%10s|%10s", i + "", number.decimalToBinary(i), number.decimalToOctal(i), number.decimalToHexadecimal(i));
    }
  }
}
