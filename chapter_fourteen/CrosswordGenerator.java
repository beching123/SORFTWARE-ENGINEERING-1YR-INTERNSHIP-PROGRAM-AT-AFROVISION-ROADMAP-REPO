package chapter_fourteen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PlacedWord {
    String word;
    int row, col;
    String dir;

    PlacedWord(String w, int r, int c, String d) {
        word = w;
        row = r;
        col = c;
        dir = d;
    }
}

public class CrosswordGenerator {
    static final int ROWS = 15, COLS = 15;
    static char[][] grid = new char[ROWS][COLS];
    static String[] dict = { "hello", "world", "apple", "lemon", "help", "loop", "open", "eagle", "melon", "leap",
            "peach", "chair", "happen", "plan", "lane", "panel" };
    static boolean[] used = new boolean[dict.length]; // track placed words
    static List<PlacedWord> placedWords = new ArrayList<>();
    static Random rand = new Random();


    static void initGrid() {
        for (int r = 0; r < ROWS; r++)
            for (int c = 0; c < COLS; c++)
                grid[r][c] = ' ';
    }

    static void placeFirstWord() {
        int idx = rand.nextInt(dict.length);
        String word = dict[idx];
        used[idx] = true;
        int midRow = ROWS / 2;
        // mark as used
        int startCol = (COLS - word.length()) / 2;
        for (int i = 0; i < word.length(); i++)
            grid[midRow][startCol + i] = word.charAt(i);
        placedWords.add(new PlacedWord(word, midRow, startCol, "across"));
        System.out.println("First word: " + word);
    }

 
    // Example: length=5, k=2, ch='e' → regex "..e.."
    static Pattern buildPattern(int length, int k, char ch) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == k) sb.append(ch);
            else  sb.append('.');
        }

    return Pattern.compile(sb.toString());

    }

    
    static boolean canPlace(String word, int startRow, int startCol, String dir) {
        int len = word.length();
        if (dir.equals("across")) {
            if (startCol < 0 || startCol + len > COLS)
                return false;
            for (int i = 0; i < len; i++) {
                char cell = grid[startRow][startCol + i];
                if (cell != ' ' && cell != word.charAt(i))
                    return false;
            }
        } else {
            if (startRow < 0 || startRow + len > ROWS)
                return false;
            for (int i = 0; i < len; i++) {
                char cell = grid[startRow + i][startCol];
                if (cell != ' ' && cell != word.charAt(i))
                    return false;
            }
        }
        return true;
    }

   
    static void placeWord(String word, int startRow, int startCol, String dir, int dictIdx) {
        int len = word.length();
        if (dir.equals("across")) {
            for (int i = 0; i < len; i++)
                grid[startRow][startCol + i] = word.charAt(i);
        } else {
            for (int i = 0; i < len; i++)
                grid[startRow + i][startCol] = word.charAt(i);
        }
        used[dictIdx] = true;
        // mark dictionary word used
        placedWords.add(new PlacedWord(word, startRow, startCol, dir));
        System.out.println("Placed: " + word);
    }

    // ---------- Try to add one intersecting word (uses regex)----------
    static boolean tryAddWord() {
        if (placedWords.isEmpty())
            return false;
        PlacedWord existing = placedWords.get(rand.nextInt(placedWords.size()));
        int i = rand.nextInt(existing.word.length());
        char crossChar = existing.word.charAt(i);
        int crossRow, crossCol;
        if (existing.dir.equals("across")) {
            crossRow = existing.row;
            crossCol = existing.col + i;
        } else {
            crossRow = existing.row + i;
            crossCol = existing.col;
        }
        String newDir = existing.dir.equals("across") ? "down" : "across";
        // For each unused dictionary word, see if it can intersect at crossChar
        for (int idx = 0; idx < dict.length; idx++) {
            if (used[idx])
                continue;
            String candidate = dict[idx];
            // already placed
            // Find all positions of crossChar in candidate using Matcher
            // We'll build a regex that matches the character itself.
            Pattern charPattern = Pattern.compile(Pattern.quote(String.valueOf(crossChar)));
            Matcher m = charPattern.matcher(candidate);
            while (m.find()) {
                int k = m.start();
                // occurrence index in candidate
                // Calculate start coordinates so that character k lands on crossing cell
                int startRow, startCol;
                if (newDir.equals("down")) {
                    startRow = crossRow - k;
                    startCol = crossCol;
                } else {
                    startRow = crossRow;
                    startCol = crossCol - k;
                }

                if (canPlace(candidate, startRow, startCol, newDir)) {
                    // Optional: also verify using buildPattern (redundant but shows regex)
                    int len = candidate.length();
                    Pattern pattern = buildPattern(len, k, crossChar);
                    if (pattern.matcher(candidate).matches()) {
                        placeWord(candidate, startRow, startCol, newDir, idx);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static void printGrid() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                System.out.print(grid[r][c] == ' ' ? '.' : grid[r][c]);
                System.out.print(' ');
            }
            System.out.println();
        }
        System.out.println("\nWords placed:");
        for (PlacedWord pw : placedWords)
            System.out.println(pw.word + " at (" + pw.row + "," + pw.col + ") " + pw.dir);
    }

    // ---------- Main loop----------
    public static void main(String[] args) {
        initGrid();
        placeFirstWord();
        int maxAttempts = 500;
        int attempt = 0;

        while (attempt < maxAttempts && placedWords.size() < dict.length) { // also stop if all

            if (tryAddWord()) {
                attempt = 0;
            } else {
                attempt++;
            }
        }
        System.out.println("\nFinal crossword:");
        printGrid();
    }
}