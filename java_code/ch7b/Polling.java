package ContinuationOfChapter7;
// Exercise 7.40 Polling.java
// A program that allows user to rate the severeness of world most popular causes
import java.util.Scanner;

public class Polling {

  public String[]  topics = {"Climate change and Environmental Restoration", "Global Health and Pandemic Preparedness", "Eradication of Extreme Poverty and Hunger", "Universal Education and Digital Literacy", "Global Peace, Justice and Strong Institution"};
  public int[][] responses = new int[5][10];


  public void displayReport() {

    System.out.printf("%n%-4s%10s%10s%10s%10s%10s%10s%10s%10s%12s%n", "Topic", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Average");

    int highestPointTotal = 0;
    int lowestPointTotal = Integer.MAX_VALUE;

    String highestTopic = "";
    String lowestTopic = "";

    for (int i = 0; i < topics.length; i ++) {

      int rowTotal = 0;
      int ratingCount = 0;

      System.out.printf("%445s", topics[i]);

      for (int j = 0; j < responses[i].length; j ++) {

        int count = responses[i][j];
        System.out.printf("%10d", count);

        rowTotal += count * (j + 1);
        ratingCount += count;
      }

      double average = (ratingCount == 0) ? 0: (double) rowTotal / ratingCount;
      System.out.printf("%12.2f%n", average);

      if (rowTotal < lowestPointTotal && ratingCount > 0) {
        lowestPointTotal = rowTotal;
        lowestTopic = topics[i];
      }
    }

    System.out.printf("%nIssue with Highest Point: %s (%d points)%n", highestTopic, highestPointTotal);
    System.out.printf("Issue with Lowest Points: %s (%d points)%n", lowestTopic, lowestPointTotal);
  }

  public static void main(String[] args) {

    Polling poll = new Polling();
    Scanner input = new Scanner(System.in);
    boolean continuePolling = true;

    System.out.println("Welcome to the Global Issues Poll!");
    String choice = "yes";

    while (continuePolling) {

      for (int i = 0; i < poll.topics.length; i ++) {
        System.out.printf("Rate the importance of [%s] (1 - 10): ", poll.topics[i]);
        int rating = input.nextInt();

        if (rating >= 1 && rating <= 10){
          poll.responses[i][rating - 1] ++;

        } else {
          System.out.println("Invalid rating. please Enter 1 - 10."); 
          i --;
        }
      }

      System.out.print("\nEnter another response? (yes/no): ");
      choice = input.next();
      if (choice == "yes") {
        continuePolling = true;
      } else {
        continuePolling = false;
      }
    }
    
    poll.displayReport();
  }
}