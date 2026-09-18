// Fig. 21.18: TreeTest.java
// Binary tree test program.
package java_code.ch21;

import java.security.SecureRandom;

public class TreeTest {

    public static void main(String[] args) {

        Tree<Integer> tree = new Tree<Integer>();
        SecureRandom randomNumber = new SecureRandom();
        int value;

        System.out.println("Inserting the following values: ");
        int deleteOne = 0, deleteTwo = 0;

        // insert 10 random integers from 0-99 in tree
        for (int i = 1; i <= 20; i++) {

            value = randomNumber.nextInt(100);

            if (i == 5)
                deleteOne = value;
            if (i == 15)
                deleteTwo = value;
            System.out.printf("%d ", value);
            tree.insertNode(value);
        }

        tree.insertNode(49);
        tree.insertNode(83);
        tree.insertNode(28);
        tree.insertNode(97);
        tree.insertNode(71);
        tree.insertNode(40);
        tree.insertNode(18);
        tree.insertNode(99);
        tree.insertNode(92);
        tree.insertNode(72);
        tree.insertNode(69);
        tree.insertNode(44);
        tree.insertNode(32);
        tree.insertNode(19);

        System.out.printf("%n%nPreorder traversal%n");
        tree.preorderTraversal();

        System.out.printf("%n%nInorder traversal%n");
        tree.inorderTraversal();

        System.out.printf("%n%nPostorder traversal%n");
        tree.postorderTraversal();
        System.out.println();

        System.out.println();
        System.out.println();
        System.out.printf("Depth: %d", tree.getDepth());
        System.out.println();

        System.out.println("Deleting " + deleteOne);
        tree.delete(deleteOne);
        System.out.println("Deleting " + deleteTwo);
        tree.delete(deleteTwo);
        tree.inorderTraversal();
        System.out.println();
        tree.preorderTraversal();
        System.out.println();

        System.out.println();
        System.out.println("Level order traversal: ");
        tree.levelorderTraversal();

        System.out.println();System.out.println();
        tree.outputTree();

    }
} // end class TreeTest
