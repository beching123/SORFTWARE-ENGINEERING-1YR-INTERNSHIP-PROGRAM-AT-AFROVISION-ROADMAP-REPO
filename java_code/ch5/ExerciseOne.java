// Exercise 5.3 Multiple statements 

public class ExerciseOne {

  public static void main(String[] args){

    int sum = 0;
    for (int i = 0; i < 100; i ++){
      if (i % 2 != 0)
        sum += i;
    }
    System.out.printf("The sum of odd number from 0 to 99 is: %d", sum);
    System.out.printf("%n%f", Math.pow(2.5, 3));

    int i;
    i = 0;
    while (i <= 20) {
      System.out.printf("%02d", i);
      if (i % 5 == 0)
        System.out.println();
      else 
        System.out.print('\t');
      i ++;
      
    }
    for (int j = 1; j <= 20; j ++){

      System.out.printf("%02d", j);
      if (j % 5 == 0)
        System.out.println();
      else 
        System.out.print('\t');
    }
    switch (i % 2) 
    {
      case 0:
        System.out.println("Even integer");
        break;
      case 1:
        System.out.println("Odd integer");
    } 
  }
}