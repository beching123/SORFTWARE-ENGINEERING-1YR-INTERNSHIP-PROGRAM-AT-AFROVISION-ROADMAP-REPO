package Chapter_Three;
//Application to test the HearRate class

import java.util.Scanner;// used to collect user input

import HeartRates;

import Chapter_Three.HeartRates;

// main class used to run and make use of our hearRate class
public class HeartRateTest {
  
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    HeartRates  person1 = new HeartRates("Beching", "Rexzy", 16, 10,2006);

    System.out.printf("%n%s %s:%n 1. DOT: %d /%d / %d%n 2. AGE: %dyrs%n 3. Maximum Heart Rate: %dbpm%n 3. Target Heart Rate: %dbpm%n", person1.getFirstName(), person1.getLastName(), person1.getDay(), person1.getMonth(), person1.getYear(), person1.personAge(), person1.MaximumHeartRate(), person1.targetHeartRates());

  }

}
