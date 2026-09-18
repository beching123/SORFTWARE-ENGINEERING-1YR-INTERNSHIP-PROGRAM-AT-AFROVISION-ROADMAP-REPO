// Fig.21.10 StackInheritance.java
// StackInheritance extends class List.
package java_code.ch21;

public class StackInheritance<T extends Comparable<T>> extends List<T> {

    // constructor
    public StackInheritance() {
        super("stack");
    }

    // add object to stack
    public void push(T object) {

        insertAtFront(object);
    }

    // remove object from stack
    public T pop() throws EmptyListException {
        return removeFromFront();
    }

    // peak to see what element is at the top
    public T peakAtTop() throws EmptyListException {

        T element = pop(); // first we remove the element at store a copy of it.
        push(element); // we push the element back

        return element; // return the copy
    }

    // get current node data
    public T getNodeData(ListNode<T> node) {
        
        return node.data;
    }

    // get current node
    public ListNode<T> getCurrentNode() {
        return getFirstNode();
    }

    // get reference to the nextNode
    public ListNode<T> getNextNode(ListNode<T> currentNode) {
        return currentNode.nextNode;
    }
} // end class StackInheritance
