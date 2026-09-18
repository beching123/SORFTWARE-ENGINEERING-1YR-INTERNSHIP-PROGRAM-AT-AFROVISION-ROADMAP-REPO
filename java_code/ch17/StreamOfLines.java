package Chapter_17;

// Fig. 17.17: StreamOfLines.java
// Couting word occurrences in a text file.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamOfLines {

    public static void main(String[] args) {

        // Regex that matches or more consecutive whitespace characters
       // Pattern pattern = Pattern.compile("\\s+");

        // count occurrences of each word in a Stream<String> sorted by word
        try {
            Map<Character, Long> letterCounts = Files.lines(Paths.get("Chapter2Paragraph.txt"))
                    .flatMap(line -> line.chars().mapToObj(c -> (char) c))
                    .filter(Character::isLetter)
                    .map(Character::toLowerCase)
                    .collect(Collectors.groupingBy(Function.identity(),TreeMap::new, Collectors.counting()));

            // display the words grouped starting letter
            letterCounts.forEach((letter, frequency) -> {
                System.out.printf("Letter %c appears %d times%n", letter, frequency);
            });
        } catch (IOException e) {
            System.out.println("Error!");
        }

    }
}
