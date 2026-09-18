//exercise 21.17: ModifiedTreeTest.java
// Binary tree test program, for line of text
package java_code.ch21;

import java.util.Scanner;

public class ModifiedTreeTest {

    public static void main(String[] args) {

        Tree<String> tree = new Tree<String>();
        Scanner input = new Scanner(System.in);
        String text; 

        System.out.printf("Enter your text: ");
        text = input.nextLine();

        // tokenizing text into words and storing in an array
        String[] words = text.split(" ");

        // insert 10 random integers from 0-99 in tree
        for (int i = 0; i <= words.length - 1; i++) {

           
            System.out.printf("%s ", words[i]);
            tree.insertNode(words[i]);
        }

        System.out.printf("%n%nPreorder traversal%n");
        tree.preorderTraversal();

        System.out.printf("%n%nInorder traversal%n");
        tree.inorderTraversal();

        System.out.printf("%n%nPostorder traversal%n");
        tree.postorderTraversal();
        System.out.println();

        input.close();
    }
} // end class ModifiedTreeTest
