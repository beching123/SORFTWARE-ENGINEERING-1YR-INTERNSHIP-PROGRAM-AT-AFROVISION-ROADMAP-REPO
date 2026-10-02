// Fig. 23.9: Buffer.java
// Buffer interface specifies methods called by Producer and Consumer.
package java_code.ch23;

public interface Buffer {

    // place int value to Buffer
    public void blockingPut(int value) throws InterruptedException;

    // return int value from Buffer
    public int blockingGet() throws InterruptedException;

} // end interface Buffer
