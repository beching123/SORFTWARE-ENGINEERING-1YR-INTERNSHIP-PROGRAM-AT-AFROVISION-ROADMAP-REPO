//Exercise 3.17 HealthProfileTest.java

import java.util.Scanner;

public class HealthProfileTest {
  
  //main function where the excution begins
  public static void main (String[] args){
    
    //input variable used to collect user input
    Scanner input = new Scanner(System.in);
    
    //declaring variables that will be used to collect user's records and store in the Health profile class and will be used to calculate necessary information
    String firstName;
    String lastName;
    String gender;
    int day;
    int month;
    int year;
    double height;
    double weight;

    //Collecting user input
    System.out.print("Enter your First Name: ");
    firstName = input.nextLine();
    System.out.print("Enter your Last Name: ");
    lastName = input.nextLine();
    System.out.print("Enter your Gender: ");
    gender = input.nextLine();
    System.out.print("Enter your Day of Birth: ");
    day = input.nextInt();
    System.out.print("Enter your Month of Birth: ");
    month = input.nextInt();
    System.out.print("Enter your Year of Birth: ");
    year = input.nextInt();
    System.out.print("Enter your Height(in Meters): ");
    height = input.nextDouble();
    System.out.print("Enter your weight(in Kg): ");
    weight = input.nextDouble();

    // Creating and taking the records of our first patient
    HealthProfile person1 = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);
    

    // displaying person 1 info
    System.out.printf("%n%s %s:%n 1. DOT: %d /%d / %d%n 2. AGE: %dyrs%n 3. Height: %.2finches%n 4. Weight: %.2fpounds%n 5. Body Mass Index (BMI): %.2fkgm^-2%n 6. Maximum Heart Rate: %dbpm%n 7. Target Heart Rate: %dbpm%n", person1.getFirstName(), person1.getLastName(), person1.getDay(), person1.getMonth(), person1.getYear(), person1.personAge(), person1.ConversionOfHeight(), person1.ConversionOfWeight(), person1.bodyMassIndex(), person1.MaximumHeartRate(), person1.targetHeartRates());
  }
}
