package Chapter_sixteen;
// Fig. 16.3: ListTest.java
// Lists, LinkedLists and ListIterators.
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class ListTest {
    
    public static void main(String[] args) {
        // add colors elements to list1
        String[] colors = {"black", "yellow", "green", "blue", "violet", "silber"};
        List<String> list1 = new LinkedList<>(Arrays.asList(colors));

        for (String color: colors)
            list1.add(color);

        // add colors2 elements to list2
        String[] colors2 = {"gold", "white", "brown", "blue", "voilet", "silver"};
        List<String> list2 = new LinkedList<>(Arrays.asList(colors2));

        for (String color: colors2) 
            list2.add(color);

        list1.addAll(list2); // concatenate lists
        list2 = null; // release resources 
        printList(list1); // print list1 elements

        converToUppercaseString(list1); // convert to uppercase string
        printList(list1); // print list1 elements

        System.out.printf("%nDeleting elements 4 to 6...");
        removeItems(list1, 4, 7); // remove items 4-6 from list
        printList(list1); // print list1 elements 
        printReversedList(list1); // print list in reverse order
        
    }

    // output list contents
    private static void printList(List<String> list) {
        
        System.out.printf("%nlist:%n");

        for (String color: list)
            System.out.printf("%s  ", color);
        
        System.out.println();
    }

    // locate String objects and covert to uppercase
    private static void  converToUppercaseString(List<String> list) {

        ListIterator<String> iterator = list.listIterator();

        while(iterator.hasNext()) {

            String color = iterator.next(); // get item
            iterator.set(color.toUpperCase()); // convert to upper case
        }
    }

    // obtain sublist and use clear method to delte sublist itmes
    private static void removeItems(List<String> list, int start , int end) {

        list.subList(start, end).clear(); // remove items
    }

    // print reversed list
    private static void printReversedList(List<String> list) {

        ListIterator<String> iterator = list.listIterator(list.size());

        System.out.printf("%nReversed list:%n");

        // print list in reverse order
        while (iterator.hasPrevious()) 
            System.out.printf("%s  ", iterator.previous());
    }
} // end class ListTest
