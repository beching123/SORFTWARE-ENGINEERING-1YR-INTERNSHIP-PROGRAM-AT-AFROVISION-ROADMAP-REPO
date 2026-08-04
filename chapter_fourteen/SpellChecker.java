package chapter_fourteen;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SpellChecker {

    // dictionary lookup
    public static boolean exactMatch(String[] dict, String word) {

        for (String w: dict) {
            if (w.equals(word)) {  
                return true;
            }
        }

        return false;
    }

    // transposition build from all single adjacent swaps then test each dictionary word against it.
    public static Pattern buildTranspositionPattern(String typed) {

        // for word of length n, there are n - 1 swaps
        int n = typed.length();
        if (n < 2) {

            // can't swap anything return pattern that marches nothing
            return Pattern.compile("(?!)"); // negative lookahead, never matches

        }

        String[] swaps = new String[n - 1];
        for (int i = 0; i < n - 1; i ++) {

            // swap char at i and i + 1
            swaps[i] = typed.substring(0, i) + typed.charAt(i + 1) + typed.charAt(i) + typed.substring(i + 2);
        }

        // joining all the candidates with '|' (regex OR)
        String regex = String.join("|", swaps);
        return Pattern.compile(regex);
    }

    public static void suggestTransposition (String typed, String[] dict) {

        Pattern swapPattern = buildTranspositionPattern(typed);
        for(String word: dict) {
            Matcher m = swapPattern.matcher(word);
            if (m.matches()) {
              System.out.println("Did you mean \"" + word);
            }
        }
    }


    // double letter fix - regex 9(.) \1 finds any repeated char.
    // for each occurrence we generate a candidate by removing one.
    public static void suggestDoubleLetterFix(String typed, String[] dict) {

        // pattern to find two consecutive identical characters
        Pattern doublePat = Pattern.compile("(.)\\1");
        Matcher doubleMat = doublePat.matcher(typed);

        // use find() to locate each run; we'll generate all unique candidates
        while (doubleMat.find()) {
            int start = doubleMat.start(); // index of first char of the pair 
            // candidate: skip the character at 'start' (remove one of the double)
            String candidate = typed.substring(0, start) + typed.substring(start + 1);
            if (exactMatch(dict, candidate)) {
                System.out.print("Did you mean \"" + candidate);
            }
        }
    } 

    // Frequency based similarity fall back (no regex here, it's counting)
    // This implements the idea: count how many letters of the typed word appear
    // in each dictionary word, respect multiplicities.
    public static int commonLetterCount (String typed, String dictWord) {
        
        // convert both to character arrays and count frequencies
        int[] freqTyped = new int[26]; 
        int[] freqDict = new int[26];
        for (char c: typed.toCharArray()) {
            if (c >= 'a' && c <= 'z') freqDict[c - 'a'] ++;
        }

        // common count = sum of minima per letter
        int common = 0;
        for (int i = 0; i < 26; i ++) {
            common += Math.min(freqTyped[i], freqDict[i]);
        }
        return common;
    }

    public static void suggestByFrequency (String typed, String[] dict) {
        
        int bestScore = 0;
        // first pass: find max score
        for (String w: dict) {
            int score = commonLetterCount(typed, w);
            if (score > bestScore) {
                bestScore = score;
            }
        }

        // only suggest if bestScore is at least half the length of the longer word 
        int minLength = Math.min(typed.length(), bestScore > 0 ? Integer.MAX_VALUE: 0);
        // to avoid dumb suggestions, require at least 2 common letters or something .
        if (bestScore < 2) return;

        // second pass print all words achieving bestScore
        System.out.println("Maybe you meant one of these (similarity score " + bestScore + "):");
        for (String w: dict) {
            if (commonLetterCount(typed, w) == bestScore) {
                System.out.println("  \"" + w + "\"");
            }
        }
    }

    // main function for dictionary entry and interactive check
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // building the dictionary
        System.out.print("How many words in your dictionary? ");
        int size = input.nextInt();
        input.nextLine(); // consume the new line character

        String[] wordList = new String[size];
        System.out.println("Enter the words, one per line: ");
        for (int i = 0; i < size; i ++) {
            // store as lower-case for case insensitivity 
            wordList[i] = input.nextLine().trim().toLowerCase();
        }

        // interactive spelling checker
        while(true) {
            System.out.print("\nEnter a word to check (or 'quit' to stop): ");
            String useWord = input.nextLine().trim().toLowerCase();

            if (useWord.equals("quit")) {
                break;
            }

            // exact match?
            if (exactMatch(wordList, useWord)) {
                System.out.println("Word is spelled correctly.");
                continue; // move to next word
            }

            System.out.println("Word is not spelled correctly.");

            // try transposition (regex powered)
            suggestTransposition(useWord, wordList);
            // try double letter
            suggestDoubleLetterFix(useWord, wordList);

            // if still nothing , the we used frequency fallback
            suggestByFrequency(useWord, wordList);
        }

        input.close();
        System.out.println("Spell checker terminated");
    }
}