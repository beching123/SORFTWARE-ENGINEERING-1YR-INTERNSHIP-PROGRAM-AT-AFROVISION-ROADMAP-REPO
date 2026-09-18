// Fig. 21.5: ListTest.java
// ListTest class to demonstrate List capabilities.
package java_code.ch21;

//import java_code.ch21.List;
//import java_code.ch21.EmptyListException;

public class ListTest {

    public static void main(String[] args) {
        
        List<Integer> list = new List<>();

        // insert integers in list
        list.insertAtFront(-1);
        list.print();
        list.insertAtFront(0);
        list.print();
        list.insertAtBack(1);
        list.print();
        list.insertAtBack(5);
        list.print();

        System.out.print("list backwards: ");
        list.printListBackward(list.getFirstNode());System.out.println();
        System.out.printf("found at: %s",list.search(list.getFirstNode(), 1));

        /* remove objects from list; print after each removal
        try {
            int removedItem = list.removeFromFront();
            System.out.printf("%n%d removed%n", removedItem);
            list.print();

            removedItem = list.removeFromFront();
            System.out.printf("%n%d removed%n", removedItem);
            list.print();

            removedItem = list.removeFromBack();
            System.out.printf("%n%d removed%n", removedItem);
            list.print();

            removedItem = list.removeFromBack();
            System.out.printf("%n%d removed%n", removedItem);
            list.print();
        }
        catch (EmptyListException emptyListException) {
            emptyListException.printStackTrace();
        }*/
    } 
} // end class ListTest
