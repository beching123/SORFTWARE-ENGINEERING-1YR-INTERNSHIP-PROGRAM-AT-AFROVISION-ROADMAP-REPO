// exercise 7.22 knight tour

import java.util.Scanner;

public class KnightTour {
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


  public KnightTour () {
    
    board = new int[ROWS][COLUMNS];

    for (int i = 0; i < ROWS; i ++){ 
      for (int j = 0; j < COLUMNS; j ++){
        board[i][j] = 0;
      }
    }

    horizontal = new int[] {2, 1, -1, -2, -2, -1, 1, 2};
    vertical = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
    currentRow = 4;
    currentColumn = 4;
    moveNumber = 0;
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

  public void displayBoard() {

    for (int i = 0; i < ROWS; i ++) {
      for (int j = 0; j < COLUMNS; j ++) {
        System.out.printf("|%3d", board[i][j]);
      }

      System.out.println();
    }
  }
public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    KnightTour knight = new KnightTour();
    

    int currentMove = 0;
    int currentRow;
    int currentColumn;
    int moveNumber = 0;

    for (int i = 1, j = 0; i <= 64; i ++) {
    
      currentRow = knight.getCurrentRow();
      currentColumn = knight.getCurrentColumn();
      
      if (currentRow < 0 || currentColumn < 0) {
        knight.unMoveKnight();
      }
      else if (knight.board[currentRow][currentColumn] == 0) {

        knight.board[currentRow][currentColumn] = ++ j;

      }

      knight.setMoveNumber(  ++ moveNumber);
      knight.moveKnight();

      if (moveNumber == 7) {
        moveNumber = 0;
      }
    }
    knight.displayBoard();
    return;
  }
}
