1 // Fig. 6.8: Craps.java
1 // Fig. 6.8: Craps.java
2 // Craps class simulates the dice game craps.
3 import java.security.SecureRandom;
4
5 public class Craps 
6 {
7  
 // create secure random number generator for use in method rollDice
8   
private static final SecureRandom randomNumbers = new SecureRandom();
Fig. 6.8 | Craps class simulates the dice game craps. (Part 1 of 3.)
6.10 Case Study: A Game of Chance; Introducing enum Types 219
9
10   
11   
12
13   // constants that represent common rolls of the dice
14   
15   
16   
17   
18   
19
20   // plays one game of craps
21   public static void main(String[] args)
22   {
23      int myPoint = 0; // point if no win or loss on first roll
24      
25
26      
27
28      // determine game status and point based on first roll 
29      switch (sumOfDice) 
30      {
31         
32         
33            
34            break;
35         
36         
37         
38            
39            break;
40         
41            
42            
43            System.out.printf("Point is %d%n", myPoint);
44            break; 
45      }
46
47      // while game is not complete
48      while ( ) // not WON or LOST
49      { 
50         
51
52         // determine game status
53         if (sumOfDice == myPoint) // win by making point
54            ;
55         else
56            if (sumOfDice == SEVEN) // lose by rolling 7 before point
57               
58      } 
59
Fig. 6.8| Craps class simulates the dice game craps. (Part 2 of 3.)
// enum type with constants that represent the game status
private enum Status { CONTINUE, WON, LOST };              
private static final int SNAKE_EYES = 2;
private static final int TREY = 3;      
private static final int SEVEN = 7;     
private static final int YO_LEVEN = 11; 
private static final int BOX_CARS = 12; 
Status gameStatus; // can contain CONTINUE, WON or LOST
int sumOfDice = rollDice(); // first roll of the dice
case SEVEN: // win with 7 on first roll    
case YO_LEVEN: // win with 11 on first roll
gameStatus = Status.WON;
case SNAKE_EYES: // lose with 2 on first roll
case TREY: // lose with 3 on first roll      
case BOX_CARS: // lose with 12 on first roll 
gameStatus = Status.LOST;
default: // did not win or lose, so remember point
gameStatus = Status.CONTINUE; // game is not over
myPoint = sumOfDice; // remember the point       
gameStatus == Status.CONTINUE
sumOfDice = rollDice(); // roll dice again
gameStatus = Status.WON
gameStatus = Status.LOST;
220 Chapter 6 Methods: ADeeperLook
Method rollDice 
In the rules of the game, the player must roll two dice on the first and all subsequent rolls.
We declare method rollDice (lines 68-81) to roll the dice and compute and print their
sum. Method rollDice is declared once, but it's called from two places (lines 26 and 50)
in main, which contains the logic for one complete game of craps. Method rollDice takes
60      // display won or lost message
61      if ( )
62         System.out.println("Player wins");
63      else
64         System.out.println("Player loses");
65   } 
66
67   // roll dice, calculate sum and display results
68   
69   {
70      // pick random die values
71      int die1 = 1 + randomNumbers.nextInt(6); // first die roll
72      int die2 = 1 + randomNumbers.nextInt(6); // second die roll
73
74      int sum = die1 + die2; // sum of die values
75
76      // display results of this roll
77      System.out.printf("Player rolled %d + %d = %d%n", 
78         die1, die2, sum);
79
80       
81   } 
82 } // end class Craps














y
n
a
all
cls
