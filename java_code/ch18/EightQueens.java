// exercise 18.15 EightQueens.java
// solving the eight queens problem using recursive backtracking
package java_code.ch18;

public class EightQueens {
    
    // declaring static variables which will be used
    public static final int BOARD_SIZE = 8;
    public static final int[] board = new int[BOARD_SIZE];

    // helper method to check for safe locations on the board
    public static boolean isSafe(int row, int col) {

        // our check that checks two conditions 
        // the first is if they share same row, and the second is if they share same diagonal   
        for (int previousCol = 0; previousCol < col; previousCol ++) {

            if (board[previousCol] == row) {

                return false;

            } else if (Math.abs(row - board[previousCol]) == Math.abs(col - previousCol)) {
                
                return false;
            }
        }
        
        return true;
    }

    // the method which will be used to solve the queens problem
    public static boolean solve (int col)  {

        // 1.Base case which determines how we know we have succeeded
        if (col >= BOARD_SIZE) {
            //printBoard();
            return true;
        }

        // 2. loop used to place the quee in every row of the col passed in
        for (int i = 0; i < BOARD_SIZE; i ++) { 
            if(isSafe(i, col)) {
                board[col] = i;

                // recursively call 
                if (solve(col + 1)) {
                    return true;
                }
            }
        }

        // end of the solve method indicates no safe spot.
        return false;
    }

    public static void printBoar() {

        for (int i = 0; i < BOARD_SIZE; i ++) {

            for (int j = 0; j < BOARD_SIZE; j ++) {

                if (board[j] == i) {
                    System.out.print(" Q ");
                }else {
                    System.out.print(" . ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
         
        if (solve(0)) {
            printBoar();
        } else {
            System.out.println("NO solution found!!!");
        }
    }
}
