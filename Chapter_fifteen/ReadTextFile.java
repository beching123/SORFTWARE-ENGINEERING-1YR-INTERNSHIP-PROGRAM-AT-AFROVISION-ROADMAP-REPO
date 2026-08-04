// Fig. 15.6: ReadTextFile.java
// This program reads a text file and displays each records.
package Chapter_fifteen;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile {

    private static Scanner input;
    private static void main(String[] args){

        openFile();
        readRecord();
        closeFile();
    }

    // open file clients.txt
    public static void openFile()  {

        try {

            input = new Scanner(Paths.get("clients.txt"));
        }
    }
}
