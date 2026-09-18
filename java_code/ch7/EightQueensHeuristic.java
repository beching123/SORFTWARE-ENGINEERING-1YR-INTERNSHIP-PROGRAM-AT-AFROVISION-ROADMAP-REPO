/* // exercise 7.24 eight queens


public class EightQueen {
  

  // declaring and initializing constant;
  private final int ROWS = 8;
  private final int COLS = 8;
  
  // declaring instant variables
  private int[][] board;
  private int[][] accessibility;

  public EightQueen () {

    // initializing variables in constructor
    board = new int[ROWS][COLS];

    // used to initialized the board
    for (int i = 0; i < ROWS; i ++) {
      
      for (int j = 0; j < COLS; j ++) {

        board[i][j] = 0;

      }
    }

    // initializing accessibility
    accessibility = new int[ROWS][COLS];

    // for loop used to fill the accessibility array with heuristic values
    for (int i = 0; i < ROWS; i ++) {

      for (int j = 0; j < COLS; j ++) {

        int counter = 1;

        for (int r = 0; r < ROWS; r ++) {
          for (int c = 0; c <COLS; c ++) {

            if (r == i && c == j ) 
              continue;

            if (r == i || c == j || Math.abs(r - i) == Math.abs(c - j)) {
              counter ++;
            }
          }
        }
        accessibility[i][j] = counter;
      }  
    }
  }



  public void displayArray(int[][] array) {

    for (int i = 0; i < ROWS; i ++) {

      for (int j = 0; j < COLS; j ++) {

        System.out.printf("%2d|", array[i][j]);
      }

      System.out.println();
    }
  }
  public static void main(String[] args) {

    EightQueen queen = new EightQueen();
    queen.fillAccessibility();

    for (int i = 1; i <= ROWS; i ++) {

      queen.findBestPosition()

    }

    
  }
}
*/



import java.util.Arrays;

/* 
* Exercise 7.24: Eight Queens (Heuristic) 
* This program used a difficulty map (accessibility) to place 8 queens 
* on a chessboard such that no two queens attack each other
*/

public class EightQueensHeuristic {

  private static final int SIZE = 8;
  private int[][] board = new int[SIZE][SIZE];
  private int[][] accessibility = new int[SIZE][SIZE];
  private boolean[][] isAttacked = new boolean[SIZE][SIZE];

  public static void main(String[] args) {

    EightQueensHeuristic game = new EightQueensHeuristic();

    game.runSolver();
  }

  public void runSolver() {

    int queensPlaced = 0;

    while ( queensPlaced != 8) {
      resetBoard();
      queensPlaced = 0;
      for (int q = 0; q < SIZE + 1; q ++) {

        updateAccessibility();

        int minVal = 99;
        int bestRow = -1;
        int bestCol = -1;

        for (int r = 0; r < SIZE; r ++) {
          for (int c = 0; c < SIZE; c ++) {

            if (!isAttacked[r][c] && board[r][c] == 0) {
              if (accessibility[r][c] < minVal) {

                minVal = accessibility[r][c];
                bestRow = r;
                bestCol = c;
              }
              else if (Math.random() > 0.5) {
                bestRow = r;
                bestCol = c;
              }
            }
          }
        }

        if (bestRow != -1) {
          board[bestRow][bestCol] = 1;

          markAttackedSquares(bestRow, bestCol);
          queensPlaced ++;
        } else {
          break;
        }
      }
    }

    displayResults(queensPlaced);
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



