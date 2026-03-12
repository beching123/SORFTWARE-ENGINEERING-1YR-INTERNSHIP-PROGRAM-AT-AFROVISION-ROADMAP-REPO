// Exercise 6.8 Calculating parking charges for cars
import java.util.Scanner;

public class ParkingCharges {

  private static final double MAX_FEE = 2.0;
  private static final double ADDITIONAL_FEE = 0.50;
  private static final double MAX_CHARGES = 10.0;

  
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    int carID;
    int counter;
    double hours;
    double currentCharges;
    double charges;

    charges = 0;
    counter = 0;


    do {
      System.out.print("Enter car ID or -1 to stop: ");
      carID = input.nextInt();

      if (carID == -1);

      else {
      
        System.out.print("Enter hours parked: ");
        hours = input.nextFloat();
        currentCharges = calculateCharges(hours);

        System.out.printf("Your receipt: %n\tCar Number: %d%n\t Charges: %f%n%n ", carID, currentCharges);

        charges += currentCharges;
        counter ++;
        
      }
    }
    while (carID != -1);

    System.out.printf("Total number of car parked yesterday: %d%nTotal Charges: %f", counter, charges);
    
  }

  public static double calculateCharges(double hours){

    double charges;
    
    
    if (Math.ceil(hours) > 3)
      charges = MAX_FEE + (ADDITIONAL_FEE * (Math.ceil(hours) - 3)); 

    else 
      charges = MAX_FEE;

    if (charges > MAX_CHARGES)
      return MAX_CHARGES;

    else 
      return charges;
  }
}
