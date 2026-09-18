package java_code.ch21;

public class ListConcatenation<T extends Comparable<T>> {

    // throws an exception
    public static <T extends Comparable<T>> void concatenate(List<T> list1, List<T> list2) throws EmptyListException {

        // declaring and initializing a node variable
        // that will be used to traverse the second list for concatenation
        List<T> node = new List<T>(); // this will point to the first node of the second list.

        // checking if the first list empty, then we return the second list as the
        // output.
        if (list1.isEmpty() && !list2.isEmpty()) {

            System.out.print("%n%nOutput: ");
            list2.print();

            throw new EmptyListException("list2");
        }

        // checking if the second list is empty so we return the firs tas the outpu
        else if (!list1.isEmpty() && list2.isEmpty()) {

            System.out.print("%n%nOutput: ");
            list1.print();

            throw new EmptyListException("list2");
        }

        // checking if both are not empty
        else if (!list1.isEmpty() && !list2.isEmpty()) {

            node = list2;
            T item;
            while (!node.isEmpty()) {
                item = node.removeFromFront();
                list1.insertAtBack(item);
            }

            list1.print();
        } else
            throw new EmptyListException("List1 and List2: ");
    }
}
