package java_code.ch20;

// exception to handle the invalid subscript
public class InvalidSubscriptException extends RuntimeException {
    
    public InvalidSubscriptException(String message) {
        
        super(message);
    }
}
