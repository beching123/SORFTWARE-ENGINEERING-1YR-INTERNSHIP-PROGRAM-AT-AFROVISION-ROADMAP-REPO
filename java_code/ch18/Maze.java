package java_code.ch18;

import java.security.SecureRandom;

public class Maze {

    // recursive maze method
    public static boo mazeTraversal(char[][] board, int startRow, int startCol) {

        // base case
        if (startCol == 11)
            return true;

        // recursive case
        for (int i = startCol; i < 12; i ++) {
            for (int j = startRow; j < 12; j ++) {

                if (isSafe(i, j))


            }
        }
    }

    // helper method used to set up the maze
    public static void setMaze() {

        char[][] board = new char[12][12];
        SecureRandom random = new SecureRandom();
        boolean elementIndex;
        int startRow = 0;
        int startCol = 0;
        boolean stop = false;
        // char element;

        for (int i = 0; i < 12; i++) {

            for (int j = 0; j < 12; j++) {

                elementIndex = random.nextBoolean();

                if (elementIndex)
                    board[i][j] = '.';
                else
                    board[i][j] = '#' 
            }

        }

        // getting the starting position
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {

                if (board[j][i] == '.') {
                    startRow = j;
                    startCol = i;

                    stop = true;
                    break;
                }

            } 
            if (stop)
                break;
        }

        mazeTraversal(board, startRow, startCol);
    }

}
