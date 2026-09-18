// Exercise 21.7: SortList.java
// ListNode declaration and SortList. 
package java_code.ch21;

// class to represent one node in a list
class ListNode<T> {

    // package access members; List can access these directly
    T data; // data for this node
    ListNode<T> nextNode; // reference to the next node in the list

    // constructor creates a ListNode that refers to object
    ListNode(T object) {
        this(object, null);
    }

    // constructor creates ListNode that refers to the specified
    // object and to the next ListNode
    ListNode(T object, ListNode<T> node) {
        data = object;
        nextNode = node;
    }

    // return reference to data in node
    T getData() {
        return data;
    }

    // return reference to next node in list
    ListNode<T> getNext() {
        return nextNode;
    }
} // end class ListNode<T>

// class List definition
public class SortList<T extends Comparable<T>> {
    private ListNode<T> firstNode;
    private ListNode<T> lastNode;
    private String name; // string like "list" used in printing
    // extra variable to deal with duplicates
    private String duplicate = "Duplicates: [ ";
    

    // constructor creates empty List with "list" as the name
    public SortList() {
        this("list");
    }

    // constructor creates an empty List with a name
    public SortList(String listName) {
        name = listName;
        firstNode = lastNode = null;
    }

    // insert items in order
    public void sortedInsert(T insertItem) {

        if (isEmpty()) // firstNode and lastNode refer to same object
            firstNode = lastNode = new ListNode<T>(insertItem);

        else {

            // insert as the new first node in the list
            if (insertItem.compareTo(firstNode.data) < 0) {

                insertAtFront(insertItem);
            }

            // else if to the first if
            else if (insertItem.compareTo(firstNode.data) == 0) {
                duplicate += insertItem + " ";
                return;
            }

            // insert as the new last node in the list.
            else if (insertItem.compareTo(lastNode.data) > 0) {

                insertAtBack(insertItem);
            }

            // a check for the last node to avoid duplicate values
            else if (insertItem.compareTo(lastNode.data) == 0) {
                duplicate += insertItem + " ";
                return;
            }

            // insert inside the list at an appropriate sorted location
            else if (insertItem.compareTo(firstNode.data) > 0) {

                ListNode<T> currentNode = firstNode.nextNode;
                ListNode<T> previouseNode = firstNode;

                while (currentNode != null) {

                    // if the current data is greater than the new one
                    if (insertItem.compareTo(currentNode.data) < 0) {

                        insertAtTheBackOfANode(insertItem, previouseNode);
                        break;
                    }

                    else if (insertItem.compareTo(currentNode.data) > 0) {

                        previouseNode = currentNode;
                        currentNode = currentNode.nextNode;
                    }

                    else {

                        duplicate += insertItem + " ";
                        break;
                    }
                }
            }
        }

    }

    // insert item at front of List
    public void insertAtFront(T insertItem) {

        // firstNode refers to new node
        firstNode = new ListNode<T>(insertItem, firstNode);
    }

    // insert item at end of List
    public void insertAtBack(T insertItem) {

        // lastNode's nextNode refers to new node
        lastNode = lastNode.nextNode = new ListNode<T>(insertItem);
    }

    // insert at a particular node
    public void insertAtTheBackOfANode(T insertItem, ListNode<T> currentNode) {

        // declaration and initializing temporal node and a new node
        ListNode<T> tempNode = currentNode.nextNode; // holds the link to the next node after the current one
        ListNode<T> newNode = new ListNode<T>(insertItem); // creating a new node

        // assigning values
        newNode.data = insertItem; // giving it our new value.
        newNode.nextNode = tempNode; // its next node points the next node after the current node

        currentNode.nextNode = newNode; // currentNode nextNode now point to our new nodes, as it is now the node behind
                                        // it.

    }

    // remove first node from List
    public T removeFromFront() throws EmptyListException {
        if (isEmpty()) // throw exception if LIst is empty
            throw new EmptyListException(name);

        T removedItem = firstNode.data; // retrieve data being removed

        // update references firstNode and lastNode
        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else
            firstNode = firstNode.nextNode;

        return removedItem; // return removed node data
    }

    // remove last node from List
    public T removeFromBack() throws EmptyListException {
        if (isEmpty()) // throw exception if List is empty
            throw new EmptyListException(name);

        T removedItem = lastNode.data; // retrieve data being removed

        // update references firstNode and lastNode
        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else // locate new last node
        {
            ListNode<T> current = firstNode;

            // loop while current node does not refer to lastNode
            while (current.nextNode != lastNode)
                current = current.nextNode;

            lastNode = current; // current is new lastNode
            current.nextNode = null;
        }

        return removedItem; // return removed node data
    }

    // determine whether list is Empty
    public boolean isEmpty() {
        return firstNode == null; // return ture if list is empty
    }

    // output list contents
    public void print() {
        if (isEmpty()) {
            System.out.printf("Empty %s%n", name);
            return;
        }

        System.out.printf("This %s is: ", name);
        ListNode<T> current = firstNode;

        // while not at end of list, output current node's data
        while (current != null) {
            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }

        System.out.println();
    }

    // return the location of the lastnode of the list.
    public ListNode<T> getLastNode() {
        return lastNode;
    }

    // get the duplicates
    public void getDuplicate() {
        System.out.printf("%n%n%s]%n", duplicate);
    }

    // merge method to merge two or more list
    public void mergeSortedList(SortList<T> list) throws EmptyListException {

        // check if list is empty
        if (list == null) {
            throw new EmptyListException("list ");
        }

        // used to hold the data which are remove from the list
        T node;

        // loop used to traverse the list
        while (!list.isEmpty()) {

            node = list.removeFromFront();
            sortedInsert(node); // calls this method to insert in order
        }
    }

    // method to reverse a list
    public SortList<T> reverseCopy(SortList<T> list) {

        // holds a the reverse copy of our list. 
        SortList<T> copy = new SortList<>();
        T elements;

        while(!list.isEmpty()) {

            elements = list.removeFromFront();
            copy.insertAtFront(elements);
        }

        return copy;
    }
} // end class List<T>
