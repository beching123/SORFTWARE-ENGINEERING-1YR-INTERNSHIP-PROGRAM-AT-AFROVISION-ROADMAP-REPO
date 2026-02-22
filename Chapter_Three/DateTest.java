//Exercise 3.14 DateTest.java

import java.util.Scanner;

public class DateTest {
  
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
  
    System.out.print("Enter the day: ");
    int day = input.nextInt();

    System.out.print("Enter the month: ");
    int month = input.nextInt();

    System.out.print("Enter the year: ");
    int year = input.nextInt();

    Date todayDate = new Date(month, day, year);
    todayDate.displayDate();

    
  }
}
