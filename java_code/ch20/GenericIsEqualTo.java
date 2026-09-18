package java_code.ch20;

public class GenericIsEqualTo {

    public static <T> boolean isEqualTo(T a, T b) {

        if (a.equals(b))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        Integer a = 2;
        Object b = "Hello";

        System.out.print(isEqualTo(a, b));

    
    }
}
