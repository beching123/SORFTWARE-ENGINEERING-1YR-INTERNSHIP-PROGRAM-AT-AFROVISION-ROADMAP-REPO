// Special exercise 7.36 machine learning programming and the implementation of the SML.

// importing the Scanner class used to collect keyboard input
import java.util.Scanner;

public class Simpletron {
  
  // Instance variable used as opcode for the simpletron computer
  private int SIZE = 1000; // size of our memory
  
  // 1. Input/output operations:  
  private final int READ = 10;    // Read a word from the keyboard into a specific location in memory
  private final int WRITE = 11;   // Write a word from a specific location in memory to screen.

  // 2. Load/store operations: 
  private final int LOAD = 20;    // Load a word form a specific location in memory into the accumulator.
  private final int STORE = 21;   // store a word from the accumulator into a specific location in memory

  // 3. Arithmetic operations:
  private final int ADD = 30;   // Add a word from a specific location in memory to the word in the accumulator (leave the result in the accumulator).
  private final int SUBTRACT = 31;    // Subtract a word from a specific location in memory into the word in the accumulator (leave the result in the accumulator).
  private final int DIVIDE = 32;    // Divide a word from a specific location in memory into the word in the accumulator (leave the result in the accumulator).
  private final int MULTIPLY = 33;    // Multiply a word from a specific location in memory by the word in the accumulator ( leave the result in the accumulator).
  private final int REMAINDER = 34;  // Remainder will be used to perform remainder calculations.
  private final int EXPONENTIAL = 35; // exponential will be used to calculate powers.
  

  // 4. Transfer-of-control operations: 
  private final int BRANCH = 40;    // Branch to a specific location in memory.
  private final int BRANCHNEG = 41;   // Branch to a specific location in memory if the accumulator is negative.
  private final int BRANCHZERO = 42;    // Branch to a specific location in memory if the accumulator is zero.
  private final int HALT = 43;    // Halt, The program has completed its task. 
  private final int NEWLINE = 44;  // following the standard of sml the should be a new line from the opcode not manually. so this variable is an opcode that will be called when we need new line.

  private final int READ_STRING = 50;   // this opcode is used to enable the user to read a input a string
  private final int WRITE_STRING = 51;  // this opcode is used to enable the user to write or output string or display a string from the memory 


  // 5. Sentinel variable used for the terminating of input from the user
  private final long END_OF_INPUT = -99999;

  // 6. Simpletron memory.
  private final double[] MEMORY = new double[SIZE];

  // 7. Creating an input object from class Scanner which was imported for the collection of user input
  Scanner input = new Scanner(System.in);

  // 8. Instance special variable used as registers (special registers)
  private double accumulator;   // all the data after any operation will be stored here
  private int instructionCounter;    // will be used to keep track of the location in memory that contains the instruction being performed
  private int operationCode;   // used to represent the of the operation currently being performed
  private int operand;   // register that is used to indicate the memory location on which the current instruction operates.
  private long instructionRegister;   // used to hold the next instruction to be performed

  // 9. Constant denominator variable which will be used when dividing our instructions to get operand and operation code
  private int DENOMINATOR = 1000;


  // Constructor which is called to initialize all the special registers to zero
  public Simpletron () {
 
    // initializing registers to zero
    accumulator = 0;
    instructionCounter = 0;
    operationCode = 0;
    operand = 0;
    instructionRegister = 0;

  }
  // This methods is used only once, to print the welcome message to the user when they first run our program
  public void welcomeMessage () {

    System.out.println();System.out.println();
    System.out.println("*** Welcome to Simpletron!                        ***");
    System.out.println("*** Please enter your program instruction         ***");
    System.out.println("*** (or data word) at a time. I will display      ***");
    System.out.println("*** the location number and a question mark (?).  ***");
    System.out.println("*** You then type the word for that location.     ***");
    System.out.println("*** Type -99999 to stop entering your program.   ***");
    System.out.println();System.out.println();
  }

  // Method which is called to display some message after the all user input has been taken and stored
  public void displayConfirmationMessage () {

    // displaying messages
    System.out.println();System.out.println();
    System.out.println("*** Program loading completed ***");
    System.out.println("*** Program execution begins ***");

  }

  // 8. This methods will be used to collect user input
  public void getInput() {

    // Declaring and initializing the Index variable used in our sentinel-controlled while loop
    int i;
    i = 0;

    // Sentinel controlled while loop used to collect user input
    while (i < MEMORY.length) {

      System.out.printf("  %03d ? ", i);
      String hexInput = input.next(); // read input as a string

      //MEMORY[i]  = input.nextLong();
      
      //if ((long)MEMORY[i] == END_OF_INPUT)
     // if (hexInput.equals("-99999"))
       // break;
      // converting our hex string input to a double so our memory can store it
      //MEMORY[i] = Integer.parseInt(hexInput, 16);
      

      try {
      
        double value = (double) Integer.parseInt(hexInput, 16);

        if (value == END_OF_INPUT) {
          break;
        }

        MEMORY[i] = value;
        i ++;
      } catch (NumberFormatException e) {
        System.out.println("Invalid input, please enter a hex value or -99999 to stop.");
      }
      i ++;
    }
  }

  // This method is to print the computer dump after the program has been completely executed
  public void printOut () {

    // A sample dump method
    System.out.println();System.out.println();System.out.println();
    System.out.println("\n  REGISTERS: ");System.out.println();
    System.out.printf("%-25s %+05.2f%n","  accumulator ", accumulator);
    System.out.printf("%-27s %03d\n","  instructionCounter  ",instructionCounter);
    System.out.printf("%-25s %+05d\n", "  instructionRegister", instructionRegister);
    System.out.printf("%-28s %02d\n","  operationCode  ", operationCode);
    System.out.printf("%-28s %03d\n\n","  operand  ", operand);
    System.out.println("  MEMORY: ");
    System.out.print("\t\t");

    // loop to printout the memory of the simpletron
    for (int i = 0; i < 10; i ++) {
      System.out.printf("%5d\t", i);
    }
    
    int label = 0;
    for (int i = 0; i < SIZE; i ++) {

      if (i % 10 == 0){
        System.out.printf("\n\t%3d\t", label);
        label += 10;
      }
        double val = MEMORY[i];

        if (val == (long) val) {
          System.out.printf("+07d\t", (long) val);
        } else {
        System.out.printf("%+05.2f\t", val);
        }
    }
    System.out.println();
  }

  // This method has the logic which is used to execute the user instructions 
  public void executeInstructions() {

    // variable used to control my loop
    boolean keepRunning = true;

    // loop that start the execution of instruction from location 00 (instruction-execution cycle)
    while (keepRunning  && instructionCounter < SIZE) {

      // fetch      
      instructionRegister = (long) MEMORY[instructionCounter];

      // extractions of operation code and operand from the instruction register by the following statements below
      operationCode = (int) instructionRegister / DENOMINATOR;
      operand = (int) instructionRegister % DENOMINATOR;

      // The switch statement which is used to determine the nature of the operation code
      switch (operationCode) {

        // First executable instruction used to read user input
        case READ:
          boolean validInput = false;

          while (!validInput) {

            System.out.print("Enter hexadecimal value: ");
            String value = input.next();
            try {
              double tempValue = (double) Integer.parseInt(value, 16);

              if (tempValue < -9999 || tempValue > 9999) {
                System.out.print("Error: Value out of range (-9999 to 9999): ");
              } else {
                  MEMORY[operand] = tempValue;
                  validInput = true;
              }
            } catch (NumberFormatException e) {
              System.out.println("Invalid Hexadecimal format.");
            }
          }

          instructionCounter ++;
          break;

        // Write to the screen
        case WRITE:
         double outputValue = MEMORY[operand];
         if (outputValue == (long) outputValue) {
          System.out.printf("Value: %d", (long) outputValue);
         } else {
          System.out.printf("Value: %.2f", (long) outputValue);
         }

          instructionCounter ++;
          break;
        
        // Loading into memory
        case LOAD:
          accumulator = MEMORY[operand];
          instructionCounter ++;
          break;
        
        // Store into accumulator
        case STORE:
          if ( accumulator > -9999 && accumulator < 9999) {
            MEMORY[operand] = accumulator;
            instructionCounter ++;
          }
          else {
            System.out.println("*** Accumulator overflow ***");
            System.out.println("***Simpletron execution abnormally terminated ***");
            keepRunning = false;
            
          }
          break;

        // adding from a specific location to accumulator
        case ADD:
          accumulator += MEMORY[operand];

          if ( accumulator <= -9999.99 || accumulator >= 9999.99) {
            System.out.println("*** Accumulator overflow ***");
            System.out.println("***Simpletron execution abnormally terminated ***");
            keepRunning = false;
          }
          instructionCounter ++;
          break;

        // subtracting from a specific location to accumulator
        case SUBTRACT:
          accumulator -= MEMORY[operand];
          
          if ( accumulator <= -9999.99 || accumulator >= 9999.99) {
            System.out.println("*** Accumulator overflow ***");
            System.out.println("***Simpletron execution abnormally terminated ***");
            keepRunning = false;
          }

          instructionCounter ++;
          break;

        // dividing from a specific location to accumulator
        case DIVIDE:
          if (MEMORY[operand] == 0) {
            System.out.println("*** Attempt to divide by zero ***");
            System.out.println("***Simpletron execution abnormally terminated ***");
            keepRunning = false;

          } else {
            accumulator /= MEMORY[operand];
            instructionCounter ++;
          }
          break;
          
        // Multiply from specific location to accumulator
        case MULTIPLY:
          accumulator *= MEMORY[operand];

          if ( accumulator <= -9999.99 || accumulator >= 9999.99) {
            System.out.println("*** Accumulator overflow ***");
            System.out.println("***Simpletron execution abnormally terminated ***");
            keepRunning = false;
          }
            instructionCounter ++;
            break;

        // remainder calculation
        case REMAINDER:
          if (MEMORY[operand] == 0) {
            System.out.println("*** Attempt to divide by zero ***");
            System.out.println("***Simpletron execution abnormally terminated ***");
            keepRunning = false;

          } else {
            accumulator %= MEMORY[operand];
            instructionCounter ++;
          }
          break;

        // exponential which will be used to calculate exponent
        case EXPONENTIAL:
          accumulator = Math.pow(accumulator, MEMORY[operand]); 
          instructionCounter ++;
          break;        

          

        // Unconditional branching
        case BRANCH:
          instructionCounter = operand;
          break;

        // Conditional branching
        case BRANCHZERO:
          if (accumulator == 0)
            instructionCounter = operand;
          break;

        // conditional branching for negative numbers
        case BRANCHNEG:
          if (accumulator < 0) {
            instructionCounter = operand; 
          } else {
            instructionCounter ++;
          }
          break;

        // opcode for new line
        case NEWLINE:
          System.out.println();
          instructionCounter ++;
          break;

        // halt
        case HALT:
          System.out.println("*** Simpletron execution terminated ***");
          keepRunning = false;
          break;

        // read string from the user
        case READ_STRING:
          System.out.print("Enter string: ");
          input.nextLine(); // clear the buffer
          String stringInput = input.nextLine();
          
          MEMORY[operand] = stringInput.length();

          for (int j = 0; j < stringInput.length(); j += 2) {
            int char1 = (int) stringInput.charAt(j);
            int char2 =(j + 1 < stringInput.length()) ? (int) stringInput.charAt(j + 1): 0;

            MEMORY[operand + 1 + (j / 2)] = (char1 * 100) + char2;
          }
          instructionCounter ++;
          break;

        // display or write string to the screen or cmd
        case WRITE_STRING:
          int length = (int) MEMORY[operand];

          for (int k = 0; k < length; k +=2 ) {

            int packedWord = (int) MEMORY[operand + 1 + (k / 2)];

            char char1 = (char) (packedWord / 100);
            System.out.print(char1);

            if (k + 1 < length) {
              char char2 = (char) (packedWord % 100);

              System.out.print(char2);
            }
          }
          instructionCounter ++;
          break;


        default:
          System.out.println("*** Invalid operation code ***");
          System.out.println("*** Simpletron execution abnormally terminated ***");
          keepRunning = false;
          break;
      }
    }
  }
  public static void main(String[] args) {

     Simpletron TestOne = new Simpletron();
     TestOne.welcomeMessage();
     TestOne.getInput();
     System.out.println(); System.out.println();

    // Display confirmation messages to the user to assure them that their program was taken and recorded successfully
    TestOne.displayConfirmationMessage();
    TestOne.executeInstructions();

    // calling the printOut method to display the status of each register, memory and the computer as whole
    TestOne.printOut();
  }
}