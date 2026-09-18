// test application for knight tour
import java.util.Scanner;
import java.security.SecureRandom;

public class BruteForceApplication {

  // constant variables, initialized on declaration
  private final int ROWS = 8;
  private final int COLUMNS = 8;

  // instance variable.
  public int[][] board;
  private int[] horizontal;
  private int[] vertical;
  private int currentRow;
  private int currentColumn;
  private int moveNumber;
  private int[][] accessibility;


  public BruteForceApplication () {
    
    accessibility = new int[ROWS][COLUMNS];
    board = new int[ROWS][COLUMNS];

    for (int i = 0; i < ROWS; i ++){ 
      for (int j = 0; j < COLUMNS; j ++){
        board[i][j] = 0;
      }
    }

    horizontal = new int[] {2, 1, -1, -2, -2, -1, 1, 2};
    vertical = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
    currentRow = 0;
    currentColumn = 0;
    moveNumber = 0;

    setAccessibility();
  }

  public void moveKnight() {

    currentRow += vertical[moveNumber];
    currentColumn += horizontal[moveNumber];

  }

  public void unMoveKnight() {

    currentRow -= vertical[moveNumber];
    currentColumn -= horizontal[moveNumber];
  }

  public void setMoveNumber(int moveNumber) {

    this.moveNumber = moveNumber;

  }

  public int getMoveNumber() {
    
    return moveNumber;
  }

  public int getCurrentRow() {

    return currentRow;

  }

  public int getCurrentColumn() {

    return currentColumn;

  }

  public void clearBoard() {
     for (int i = 0; i < ROWS; i ++){ 
      for (int j = 0; j < COLUMNS; j ++){
        board[i][j] = 0;
      }
    }
  }

  public void displayBoard() {

    for (int i = 0; i < ROWS; i ++) {
      for (int j = 0; j < COLUMNS; j ++) {
        System.out.printf("|%3d", board[i][j]);
      }

      System.out.println();
    }
  }

  public void setAccessibility() {

    for (int row = 0; row < ROWS; row ++) {

      for (int col = 0; col < COLUMNS; col ++) {

        int validMoves = 0;

        for (int i = 0; i < ROWS; i ++){

          int testRow = row + vertical[i];
          int testCol = col + horizontal[i];

          if (testRow >= 0 && testRow < ROWS && testCol >= 0 && testCol < ROWS ) {

            validMoves ++;
          }
        }

        accessibility[row][col] = validMoves;
      }
    }
    
  }
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    BruteForceApplication knight = new BruteForceApplication();
    SecureRandom randomNumber = new SecureRandom();
    

    int currentMove = 0;
    int currentRow = 0;
    int currentColumn = 0;
    int moveNumber = 0;
    int bestRow = 0;
    int bestCol = 0;
    int counter = 1;
    int[] frequency = new int[65];
/*  int newMin1;
    int newMin2;
    int newMin3;
    int optionalRow = 0;
    int optionalColumn = 0;  */

     knight.board[currentRow][currentColumn] = counter; 

    for (int j = 0; ; j ++) {
    for (int i = 1; i <= 64; i ++) {
 
      //int min = 9;
      //newMin1 = 9;
    
      //for (int j = 0; j < knight.ROWS; j ++) {

        int testRow = currentRow + knight.vertical[randomNumber.nextInt(7)];
        int testCol = currentColumn + knight.horizontal[randomNumber.nextInt(7)];

        if (testRow >= 0 && testRow < knight.ROWS && testCol >= 0 && testCol < knight.ROWS && knight.board[testRow][testCol] == 0 ) {

         // if (min > knight.accessibility[testRow][testCol] &&knight.board[testRow][testCol] == 0){

          //  min = knight.accessibility[testRow][testCol];
            //bestRow = testRow;
            //bestCol = testCol;
        
          //}
            currentRow = testRow;
            currentColumn = testCol;

            knight.board[currentRow][currentColumn] = ++ counter; 

          //else if (min == knight.accessibility[testRow][testCol] && knight.board[testRow][testCol] == 0) {

           // newMin1 = knight.accessibility[testRow][testCol];
           // optionalRow = testRow;
            //optionalColumn = testCol;

        //  }
        }
      }

      ++ frequency[counter];
      knight.clearBoard();

      if (counter == 64)
        break;
      counter = 1;
    }

      /*if (min == newMin1) {

        newMin2 = 9;
        newMin3 = 9;

        for (int l = 0; l < knight.ROWS; l ++) {

          int testRow = optionalRow + knight.vertical[l];
          int testCol = optionalColumn + knight.horizontal[l];

          if (testRow >= 0 && testRow < knight.ROWS && testCol >= 0 && testCol < knight.ROWS ) {

            if (newMin2 > knight.accessibility[testRow][testCol] && knight.board[testRow][testCol] == 0){

              newMin2 = knight.accessibility[testRow][testCol];
            }
          }

        testRow = bestRow + knight.vertical[l];
        testCol = bestCol + knight.horizontal[l];

        if (testRow >= 0 && testRow < knight.ROWS && testCol >= 0 && testCol < knight.ROWS ) {

          if (newMin2 > knight.accessibility[testRow][testCol] && knight.board[testRow][testCol] == 0){

            newMin3 = knight.accessibility[testRow][testCol];

          }
        }
      }
    }

      else if (min == 9)
        break;

      if (min <= newMin1) {
*/

  //    }

    //  else if (newMin1 < min) {
      //  bestRow = optionalRow;
        //bestCol = optionalColumn;
     // }



      /*for (int k = 0; k < knight.ROWS; k ++) {
        
        int testRow = currentRow + knight.vertical[k];
        int testCol = currentColumn + knight.horizontal[k];

        if (testRow >= 0 && testRow < knight.ROWS &&    testCol >= 0 && testCol < knight.ROWS ) {

          -- knight.accessibility[testRow][testCol];

        }
      }*/
    //}

    knight.displayBoard();
    System.out.println();
    System.out.println();
    
    int max = 0;
    int indexMax = 0;
    
    System.out.printf("%8s%18s\n", "Number", "Number of times");
    for (int i = 1; i <= 64; i ++) {

      System.out.printf("%8d%9d\n", i, frequency[i]);

      if (max < frequency[i]){
        max = frequency[i];
        indexMax = i;
      }

    }

    System.out.printf("The best result was %d, went %d times", indexMax, max);
    return;
  }
}
