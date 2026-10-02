// Fig. 23.14: BlockingBuffer.java
// Creating a synchronized buffer using an ArrayBlockingQueue.
package java_code.ch23;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer {

    private final ArrayBlockingQueue<Integer> buffer; // shared buffer

    // constructor
    public BlockingBuffer() {

        buffer = new ArrayBlockingQueue<>(1);
    }

    // place vlaue into buffer
    public void blockingPut(int value) throws InterruptedException {

        buffer.put(value); // place value in buffer
        System.out.printf("%s%2d\t%s%d%n", "Producer writes ", value, "Buffer cells occupied: ", buffer.size());

    }

    // return value from buffer
    public int blockingGet() throws InterruptedException {

        int readValue = buffer.take(); // remove value from buffer
        System.out.printf("%s %2d\t%s%d%n", "Consumer reads ", readValue, "Buffer cells occupied: ", buffer.size());

        return readValue;
    }
} // end class BlockBuffer
