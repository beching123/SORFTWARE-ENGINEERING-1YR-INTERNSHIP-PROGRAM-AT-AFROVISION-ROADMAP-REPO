package java_code.ch20;

public class PairTest {
    
    public static void main(String[] args) {
        
        Pair<Double, Integer> pair = new Pair(1.1, "hello");

        System.out.print(pair.getFPair());
        System.out.print(pair.getSpair());

    }
}
