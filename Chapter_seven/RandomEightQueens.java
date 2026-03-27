import java.util.Arrays;
import java.security.SecureRandom;

/* 
* Exercise 7.24: Eight Queens (Heuristic) 
* This program used a difficulty map (accessibility) to place 8 queens 
* on a chessboard such that no two queens attack each other
*/

public class RandomEightQueens {

  private static final int SIZE = 8;
  private int[][] board = new int[SIZE][SIZE];
  private int[][] accessibility = new int[SIZE][SIZE];
  private boolean[][] isAttacked = new boolean[SIZE][SIZE];

  public static void main(String[] args) {

    RandomEightQueens game = new RandomEightQueens();

    game.runSolver();
  }

  public void runSolver() {

    int queensPlaced = 0;
    int[] frequency = new int[SIZE + 1];
    SecureRandom randomNumber  = new SecureRandom();

  // while ( queensPlaced != 8) {
    //resetBoard();
    //queensPlaced = 0;
    for (int j = 0; j < 1000; j ++) {
      resetBoard();
      queensPlaced = 0;

      for (int q = 0; q < SIZE; q ++) {

        updateAccessibility();
        int attemptsThisQueen = 0;
        boolean foundSpot = false;

        while (!foundSpot && attemptsThisQueen < 100){

          int bestRow = randomNumber.nextInt(SIZE);
          int bestCol = randomNumber.nextInt(SIZE);

          if (!isAttacked[bestRow][bestCol] && board[bestRow][bestCol] == 0) {

            board[bestRow][bestCol] = 1;
            markAttackedSquares(bestRow, bestCol);
            foundSpot = true;
            queensPlaced ++;
          }
          attemptsThisQueen ++;
        }
        if (!foundSpot) {
          break;
        }
      }
        ++ frequency[queensPlaced];
    }
    int max = 0;
    int indexMax = 0;
    
    System.out.printf("%8s%18s\n", "Number", "Number of times");
    for (int i = 0; i <= SIZE; i ++) {

      System.out.printf("%8d%9d\n", i, frequency[i]);

      if (max < frequency[i]){
        max = frequency[i];
        indexMax = i;
      }
    }
  }

  private void updateAccessibility() {

    for (int i = 0; i < SIZE; i ++) {
      for (int j = 0; j < SIZE; j ++) {

        if (isAttacked[i][j] || board[i][j] == 1) {
          accessibility[i][j] = 99;
          continue;
        }
        int count = 0;
        for (int r = 0; r < SIZE; r ++) {
          for (int c = 0; c < SIZE; c ++) {
            
            if (r == i && c == j) continue;
            if (!isAttacked[r][c]){

              if (r == i || c == j || Math.abs(r - i) == Math.abs(c - j)){
                count ++;
              }
            }
          }
        }
        accessibility[i][j] = count;
      }
    }
  }

  private void markAttackedSquares(int row, int col) {

    for (int r = 0; r < SIZE; r ++) {
      for (int c = 0; c < SIZE; c ++) {

        if (r == row || c == col || Math.abs(r - row) == Math.abs(c - col)) {
          isAttacked[r][c] = true;
        }
      }
    }
  }

  public void displayResults(int total) {

    System.out.println("\n Final Board (1 = Queen, 0 = Empty): ");

    for (int[] row : board) {
      for (int cell: row) {
        System.out.print(cell + " ");
      }
      System.out.println();
    }
    System.out.println("\tTotal Queens Placed: " + total);
  }

  public void resetBoard() {

    for (int i = 0; i < SIZE; i ++) {
      for (int j = 0; j < SIZE; j ++) {
        board[i][j] = 0;
        isAttacked[i][j] = false;
      }
    }
    updateAccessibility();
  }

}
