// Fig. 4.17 Calculation of fuel efficiency of an automobile
import java.util.Scanner; // class that will take user input from the keyboard

public class CarMileage {

  public static void main (String[] args){

    Scanner input = new Scanner(System.in); // input will be used to take user input

    // declaring our miles covered and number of gallons used throughout the trip and the total.
    int miles ;
    int gallonsUsed;
    float total;

    // initializing them to zero
    miles = 0;
    gallonsUsed = 0;
    total = 0;
    
    // Prompting the user to input miles covered and taking the input from the user
    System.out.println("Trip 1:");
    System.out.print(" Enter miles covered: ");
    miles = input.nextInt();

    // Prompting the user to enter the gallons used  for that number of miles and -1 if non.
    System.out.print(" Enter the number of gallons (or -1 to exit): ");
    gallonsUsed = input.nextInt();

    int counter = 1; // just to used to track and display the number of trip so far
    float temp = 0; // temporal variable used to hold the milespergallons used thats the automobile efficiency 


    // while loop to take and gather all the miles per gallons used to display to user and calculate the total
    while (gallonsUsed != -1){

      if (gallonsUsed == 0);
      else temp = (float) miles / gallonsUsed;

      total += temp;
      System.out.printf("%n Fuel-efficiency for Trip %d: %.2f%n", counter, temp);
      System.out.printf("%nTrip %d:%n" , ++counter);
      System.out.print(" Enter miles covered: ");
      miles = input.nextInt();
      System.out.print(" Enter the number of gallons (or -1 to exit): ");
      gallonsUsed = input.nextInt();

    }

    System.out.printf("%nTotal Fuel-efficiencies: %.3f", total);

  }
  
}
