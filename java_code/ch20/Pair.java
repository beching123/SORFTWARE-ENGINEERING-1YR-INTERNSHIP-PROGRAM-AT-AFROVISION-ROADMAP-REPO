package java_code.ch20;
// Exercise 20.8 Pair.java

public class Pair<F, S> {

    // instance variable for the pair
    public F pair1;
    public S pair2;

    // constructor that set the default pair values
    public Pair(F pair1, S pair2) {

        // set pairs
        setFirstPair(pair1);
        setSecondPair(pair2);
    }

    // set method for pair F
    public void setFirstPair(F pair) {

        pair1 = pair;
    }

    // set method for pair S
    public void setSecondPair(S pair) {

        pair2 = pair;
    }

    // get method for F pair
    public F getFPair() {
        return pair1;
    }

    // get method to get S pair
    public S getSpair() {
        return pair2;
    }
}
