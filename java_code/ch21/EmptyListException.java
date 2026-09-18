// Fig. 21.4: EmptyListException.java
// Class EmptyListException declaration.
package java_code.ch21;

public class EmptyListException extends RuntimeException {
    
    // constructor
    public EmptyListException() {
        this("List"); // call other EmptyListException constructor
    }

    // constructor
    public EmptyListException(String name) {
        super(name + "is empty"); // call superclass constructor
    }
} // end class EmptyListException 
