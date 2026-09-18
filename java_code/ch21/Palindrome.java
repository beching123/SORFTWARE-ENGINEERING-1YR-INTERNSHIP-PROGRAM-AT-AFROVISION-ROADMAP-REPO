// exercise 21.11 
// Palindrome.java
package java_code.ch21;

//import java.util.Scanner;

public class Palindrome<T> {

    // isPalindrome takes a string
    public boolean isPalindrome(String text) {

        // temporal array that holds our text, splited into words if any
        String[] temp = text.split(" ");

        // two stacks, which will be used for our comparison
        StackInheritance<Character> stack1 = new StackInheritance<>();
        StackInheritance<Character> stack2 = new StackInheritance<>();

        // we copy each words, split them into charachers, and
        // store in stack one, in the normal order as the text
        for (int j = temp.length - 1; j >= 0; j --) {

            // stores word. 
            String word = temp[j];

            for (int i = word.length() - 1; i >= 0; i --) {

                // pushing each character to stack
                stack1.push(word.charAt(i));
            }
        }

        // for stack2
        for (String word : temp) {

            for (int i = 0; i < word.length(); i ++) {

                // pushing each character to stack
                stack2.push(word.charAt(i));
            }
        }

        System.out.println();
        stack1.print();System.out.println();
        stack2.print();


        // time to check if the text is palindrome
        // since both stacks are of the same size
        while(!stack1.isEmpty()) {

            Character c1 = stack1.pop();
            Character c2 = stack2.pop();

            if (c1.compareTo(c2) != 0) {
                
                return false;
            }
        }

        return true;

    }

    // main method
    public static void main(String[] args) {

        Palindrome<String> text = new Palindrome<>();

//        Scanner input = new Scanner(System.in);

        System.out.printf("%ntext %s Palindrome", (text.isPalindrome("Hello") == true) ? "is": "is not");
        System.out.println();
    }
}