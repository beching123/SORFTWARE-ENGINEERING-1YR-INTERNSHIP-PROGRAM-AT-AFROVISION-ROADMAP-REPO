// Exercise 17.12 UniqueWords.java
// Duplicate word removal
package Chapter_17;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Map;
import java.util.List;
import java.util.stream.Stream;

public class UniqueWords {
    
    public static void main(String[] args) {
        
        // collecting the inputted sentence
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a sentence: \n\t> ");
        String sentence = input.nextLine();

        // creating a pattern
        Pattern pattern = Pattern.compile("\\s+");

        // mapping to the number of times they occur in  a word 
        Map<String, Long> wordCounts = sentence.lines()

        
            

    }
}
