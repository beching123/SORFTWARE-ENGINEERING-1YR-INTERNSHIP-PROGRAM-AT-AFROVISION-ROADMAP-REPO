// exercise 7.19 airline reservations system
import java.util.Scanner;
import java.security.SecureRandom;

public class AirlineReservationSystem {
  
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    boolean[] seats = new boolean[11];
    int i = 0;
    int choice  = 0;
    int seat = 0;

    while (i <= 10) {
      System.out.print("Please Type 1 for First Class and Type 2 for Economy: ");
      choice = input.nextInt();
      
      switch(choice) {
        
        case 1: 
          for (int j = 1; j <= 5; j ++) {
            if (seats[j] == false) {
              seat = j;
              seats[j] = true;
              break;
            }
          }
          if (seat == 0) {
            System.out.println("No first class seats available.");
            System.out.print("Is it ok to assign a seat for you in the Economy Area\nEnter 1 to approve or zero to refuse: ");
            int OK = input.nextInt();
            if (OK == 1){
              for (int j = 6; j <= 10; j ++) {
                if (seats[j] == false) {
                  seat = j;
                  seats[j] = true;
                  break;
                }
              }
              if (seat == 0) System.out.print("No seats available!\n\n");
              else {
                System.out.printf("\nYour seat Number: %d\n\n", seat);
                seat = 0;
              }
              break;
            }
            else System.out.print("\nVery Well Then. The next flight is in 3hrs time.\n\n");
          }
          else {
            System.out.printf("\nYour seat Number: %d\n\n", seat);
            seat = 0;
          }
        break;

        case 2: 
          for (int j = 6; j <= 10; j ++) {
            if (seats[j] == false) {
              seat = j;
              seats[j] = true;
              break;
            }
          }
          if (seat == 0) {
            System.out.println("No Economy class seats available.");
            System.out.print("Is it ok to assign a seat for you in the First Class Area\nEnter 1 to approve or 0 to refuse: ");
            int OK = input.nextInt();
            if (OK == 1){
              for (int j = 1; j <= 5; j ++) {
                if (seats[j] == false) {
                  seat = j;
                  seats[j] = true;
                  break;
                }
              }
              if (seat == 0) System.out.print("No seats available!\n\n");
              else {
                System.out.printf("\nYour seat Number: %d\n\n", seat);
                seat = 0;
              }
              break;
            }
            else System.out.print("\nVery Well Then. The next flight is in 3hrs time.\n\n");
          }
          else {
            System.out.printf("\nYour seat Number: %d\n\n", seat);
            seat = 0;
          }
          break;

        default: 
         System.out.print("\nInvalid option!\n");
      }

      i ++;
    }
  }
}

