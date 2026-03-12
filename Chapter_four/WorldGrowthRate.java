// Exercise 4.40 World growth rate
import java.util.Scanner;

public class WorldGrowthRate {
  
  public static void main(String[] args){

    int year;
    double currentPopulation;
    double nextYearPopulation;
    double numericalIncrease;
    int counter;

    year = 2025;
    currentPopulation = nextYearPopulation = 8300000000.0;

    counter = 1;
    System.out.printf("%4s|%8s|%30s|%30s%n%n","SN","YEAR","TOTAL POPULATION","ANNUAL INCREASE");
    System.out.printf("%4s|%8s|%30s|%30s%n","0","2025","8300000000.000000","-");

    while (counter <= 75){
      nextYearPopulation = currentPopulation + (currentPopulation * 0.84 / 100);
      numericalIncrease = nextYearPopulation - currentPopulation;
      System.out.printf("%4d|%8d|%30f|%30f%n",counter, (year + counter),nextYearPopulation,numericalIncrease);

      currentPopulation = nextYearPopulation;
      counter ++;

    }
  }
}
