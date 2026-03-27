// Special exercise 7.36 machine learning programming and the implementation of the SML.

// importing the Scanner class used to collect keyboard input
import java.util.Scanner; 

public class Simpletron {
  
  // Instance variable used as opcode for the simpletron computer
  
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

  // 4. Transfer-of-control operations: 
  private final int BRANCH = 40;    // Branch to a specific location in memory.
  private final int BRANCHNEG = 41;   // Branch to a specific location in memory if the accumulator is negative.
  private final int BRANCHZERO = 42;    // Branch to a specific location in memory if the accumulator is zero.
  private final int HALT = 43;    // Halt, The program has completed its task.

  // 5. Sentinel variable used for the terminating of input from the user
  private final long END_OF_INPUT = -99999;

  // 6. Simpletron memory.
  private final double[] MEMORY = new double[100];

  // 7. Creating an input object from class Scanner which was imported for the collection of user input
  Scanner input = new Scanner(System.in);

  // 8. Instance special variable used as registers (special registers)
  private double accumulator;   // all the data after any operation will be stored here
  private int instructionCounter;    // will be used to keep track of the location in memory that contains the instruction being performed
  private int operationCode;   // used to represent the of the operation currently being performed
  private int operand;   // register that is used to indicate the memory location on which the current instruction operates.
  private long instructionRegister;   // used to hold the next instruction to be performed

  // 9. Constant denominator variable which will be used when dividing our instructions to get operand and operation code
  private int DENOMINATOR = 100;


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
    System.out.println("*** Type -999999 to stop entering your program.   ***");
    System.out.println();System.out.println();
  }

  // Method which is called to display some message after the all user input has been taken and stored
  public void displayConfirmationMessage () {

    // displaying messages
    System.out.println();System.out.println();
    System.out.println("*** Program loading completed ***");
    System.out.println(" Program execution begins ***");

  }

  // 8. This methods will be used to collect user input
  public void getInput() {

    // Declaring and initializing the Index variable used in our sentinel-controlled while loop
    int i;
    i = 0;

    // Sentinel controlled while loop used to collect user input
    while (true) {

      System.out.printf("  %02d ? ", i);
      MEMORY[i]  = input.nextLong();
      
      if (MEMORY[i] == END_OF_INPUT)
        break;
      i ++;
    }

  }

  // This method is to print the computer dump after the program has been completely executed
  public void printOut () {

    // A sample dump method
    System.out.println();System.out.println();System.out.println();
    System.out.println("  REGISTERS: ");
    System.out.printf("  accumulator        %+04d\n", accumulator);
    System.out.printf("  instructionCounter     %02d",instructionCounter);
    System.out.printf("  instructionRegister  +04d", instructionRegister);
    System.out.printf("  operationCode        %02d", operationCode);
    System.out.printf("  operand            %02d", operand);
    System.out.println("MEMORY: ");

    // loop to printout the memory of the simpletron
    for (int i = 0; i < 100; i ++) {
  

    }

  }

  // This method has the logic which is used to execute the user instructions 
  public void executeInstructions() {

    // loop that start the execution of instruction from location 00 (instruction-execution cycle)
    while (MEMORY[instructionCounter] != END_OF_INPUT) {

      // fetch      
      instructionRegister = (long) MEMORY[instructionCounter];

      // extractions of operation code and operand from the instruction register by the following statements below
      operationCode = (int) instructionRegister / DENOMINATOR;
      operand = (int) instructionRegister % DENOMINATOR;

      // The switch statement which is used to determine the nature of the operation code
      switch (operationCode) {

        // First 
        case READ:
          System.out.print("Enter an integer: ");
          MEMORY[operand] = input.nextLong();
          break;

        // Write to the screen
        case WRITE:
          System.out.printf("Value: %d", MEMORY[operand]);
          break;
        
        // Loading into memory
        case LOAD:
          accumulator = MEMORY[operand];
          break;
        
        // Store into accumulator
        case STORE:
          MEMORY[operand] = accumulator;
          break;

        // adding from a specific location to accumulator
        case ADD:
          accumulator += MEMORY[operand];
          break;

        // subtracting from a specific location to accumulator
        case SUBTRACT:
          accumulator -= MEMORY[operand];
          break;

        // dividing from a specific location to accumulator
        case DIVIDE:
          if (MEMORY[operand] == 0)
            System.out.println("Error!. Division by 0 is not possible");
          else 
            accumulator /= MEMORY[operand];
          break;
          
          // Multiply from specific location to accumulator
        case MULTIPLY:
            accumulator *= MEMORY[operand];
            break;


        // halt
        case HALT:
          System.out.println("*** Simpletron execution terminated ***");
          break;

      }

      // Incrementing the instruction counter to point to the next location
      instructionCounter ++;
    }

    // calling the printOut method to display the status of each register, memory and the computer as whole
    printOut();

  }

  public static void main(String[] args) {

     Simpletron TestOne = new Simpletron();
     TestOne.welcomeMessage();
     TestOne.getInput();
     System.out.println(); System.out.println();

    // Display confirmation messages to the user to assure them that their program was taken and recorded successfully
    TestOne.displayConfirmationMessage();
    TestOne.executeInstructions();
  }
}
  
