package java_code.ch21;

import java.util.Scanner;

public class StackReverse<T> {
    
    // method that receives the line of text and uses a stack to reverse it. 
    public void reverseLineOfWords(String lineOfWords) {

        // Our stack that will store our words
        StackInheritance<String> stack = new StackInheritance<>();

        // array that stores our words temporarily
        String[] temp = lineOfWords.split(" ");

        for (int i = 0; i < temp.length; i ++) {

            // copy and inputing to the stack
            stack.push(temp[i]);
        }

        // now poping and displaying to the screen
        while(!stack.isEmpty()) {

            System.out.print(stack.pop() + "  ");
        }
        
    }

    // main method that test our class
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter you line of text: ");
        String lineOfText = input.nextLine();

        // reference to our class
        StackReverse<String> reverseText = new StackReverse<>();
        System.out.println();System.out.println();


        // reversing the line of text
        System.out.print("Reversed sentence: ");
        reverseText.reverseLineOfWords(lineOfText);

        input.close();

    }
}
