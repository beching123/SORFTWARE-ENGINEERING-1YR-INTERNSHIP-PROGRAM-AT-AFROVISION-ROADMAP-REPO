    package Chapter_fifteen;

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTransTextFiles {
    
    private static Formatter output; // outputs text to a file
    public static void main(String[] args) {

        
            openFile();
            addRecords();
            closeFile();
        
    }

    // open file trans.txt and oldMast.txt secondly
    public static void openFile() {

        Scanner input = new Scanner(System.in);

        try {

            //System.out.print("Enter the file name: ");
            //String name = input.nextLine();

            output = new Formatter("trans.txt"); // open the file
            
        } catch(SecurityException securityException) {

            System.err.println("Write permission denied. Terminating.");
            System.exit(1); // terminate the program

        } catch (FileNotFoundException fileNotFoundException) {

            System.err.println("Error opening file. Terminating.");
            System.exit(1); // terminating the program
        }
    }

    // add records to files
    public static void addRecords() {

        Scanner input = new Scanner(System.in);

        System.out.printf("%s%n%s%n%s%n?", "Enter account number", "Enter amount", "Enter end-of-file indicator" );

        while (input.hasNext()) // loop until end-of-ile. indicator 
        {
            try {
                //output new record to file; assumes valid input
                output.format("%d %.2f%n", input.nextInt(), input.nextDouble());
            } 
            catch(FormatterClosedException formatterClosedException) {

                System.err.println("Error writing to file. terminating");
                break;
            } catch( NoSuchElementException elementException){
                System.err.println("Invalid input, Please try again.");
                input.nextLine(); // discard unit so user can try again
            }

            System.out.print(" ?  ");
        } // end while
    } // end method addRecords

    // close file
    public static void closeFile(){

        if (output != null)
            output.close();
    }
} // end class CreateTextFile
