// exercise 7.28 Simulation of the Tortoise and the Hare race to the finished favouring the tortoise.
import java.security.SecureRandom;

public class Contestant {
  
  private int tortoiseCurrentPosition;
  private int hareCurrentPosition;
  private boolean hasStarted;

  public Contestant () {

    tortoiseCurrentPosition = 1;
    hareCurrentPosition = 1;

  }

  public void updateTortoisePosition(int steps) {
    
    hasStarted = true;

    if (steps >= 1 && steps <= 5) 
      tortoiseCurrentPosition += 3;

    else if (steps >= 6 && steps <= 7)
      tortoiseCurrentPosition -= 6;
    
    else 
      tortoiseCurrentPosition += 1; 
  }

  public void updateHaresPosition(int steps) {

    if (steps >= 1 && steps <= 2) 
      hareCurrentPosition += 0;

    else if (steps >= 3 && steps <= 4)
      hareCurrentPosition += 9;

    else if (steps == 5) 
      hareCurrentPosition -= 12;

    else if (steps >= 6 && steps <= 8)
      hareCurrentPosition += 1;

    else {
      hareCurrentPosition -= 2;
    }
  }

  public void moveContestants(int steps, char contestant, boolean isHare) {

    steps = (steps <= 0) ? 1: steps;

    for (int i = 1; i <= 70; i ++)  {

      for (int j = 0; j <= 20000000; j ++) {

        if (i < steps && j == 2000000)
          System.out.print("..");

        else if (i == steps  && j == 2000000)
          System.out.printf("|%c|", contestant);

        else if ((i > steps && j == 2000000) && ((tortoiseCurrentPosition == hareCurrentPosition ) || (tortoiseCurrentPosition <= 0 && hareCurrentPosition <= 0) ) && 
        (isHare) && hasStarted)
          System.out.print("OUCH !!! ");
        
        else 
          continue;
      }
    }
  }

  public static void systemClear(int end) {

    for (int i = 0; i < end; i ++) {
      System.out.println();
    }
  }
  public static void main(String[] args) {

    Contestant tortoise = new Contestant();
    Contestant hare = new Contestant();
    SecureRandom randomNumber = new SecureRandom();

    int tortoiseSteps;
    int hareSteps;
    int space = 26;

    for (int i = 1; i <= 70; i ++) {

      systemClear(space);
      tortoise.moveContestants(tortoise.tortoiseCurrentPosition, 'T', false);

      System.out.println();System.out.println();

      hare.moveContestants(hare.hareCurrentPosition, 'H', true);
      systemClear(space - 10);

      if (i == 1) {

        System.out.println("\n\n");

        int j = 0;

        do {
          if (j == 8000000) 
            System.out.print("BANG !!!\t");

          else if (j == 12000000) {System.out.print("AND THEY'RE OF !!!");
          }

          else System.out.print("");
          j ++;

        }

        while (j <= 20000000);

      }

      tortoiseSteps = 1 + randomNumber.nextInt(10);
      hareSteps = 1 + randomNumber.nextInt(10);
        
      tortoise.updateTortoisePosition(tortoiseSteps);
      hare.updateHaresPosition(hareSteps);
      
      if ((hare.hareCurrentPosition >= 70) || (tortoise.tortoiseCurrentPosition >= 70)) 
        break;     

    } 

    if (hare.hareCurrentPosition == tortoise.tortoiseCurrentPosition){
      int favor = 1 + randomNumber.nextInt(2);

      if (favor == 1)

       System.out.println("Tortoise Wins. YAY !!!");

      else System.out.print("It's a tie");
    }
    else if (hare.hareCurrentPosition > tortoise.hareCurrentPosition)
      System.out.println("Hare Wins. Yuch");
    else System.out.println("Tortoise Wins. YAY !!!");

  }  
}
