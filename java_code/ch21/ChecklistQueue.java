// exercise 21.15 ChecklistQueue.java
// simulating a real life super market queue
package java_code.ch21;

import java.security.SecureRandom;

public class ChecklistQueue {

    // instance variables that will be used for our simulation
    private Queue<Integer> line;
    private int arrivalTime;
    private int nextArrivalTime;
    private int serviceTime;

    // constructor
    public ChecklistQueue() {

        line = new Queue<>();
        arrivalTime = 0;
        serviceTime = 0;
    }

    // simulations method
    public void superMarket() {

        int customerNumber = 0; // keep track of the customers
        int peakQueueTime = 0; // keep track of the number of customers at peak time
        int length = 0; // keeps track of our queue length

        // random variable which will aid in generating
        // random numbers used for minutes
        SecureRandom random = new SecureRandom();

        // generating random times
        arrivalTime = random.nextInt(3) + 1;
        nextArrivalTime = arrivalTime;

        // our loop where each iteration is equivalent to a minute
        for (int i = 1; i <= 720; i++) {

            // if the customer arrives
            if (i == nextArrivalTime) {

                line.enqueue(++customerNumber); // adding one new customer to the queue

                // save the longest length of the queue
                if (customerNumber > length) {
                    length = customerNumber;
                    peakQueueTime = i;
                }

                // serviceTime = random.nextInt(4) + 1 + i; // picking the customer service
                // time,
                nextArrivalTime = random.nextInt(3) + 1 + i;// get next arrivalTime for next customer

            }

            // if the time to serve the customer ellapse
            if (i == serviceTime) {

                line.dequeue(); // removing one customer from the line

                if (line.isEmpty()) {
                    serviceTime = 0; // the cashier is now free and waiting
                } else {

                    serviceTime = i + 1 + random.nextInt(4); // start serving the next customer if the line is still
                                                             // occupied
                }

                // decrement customerNumber
                customerNumber--;
            }

            // is line is empty service time is finish but people are waiting
            if (serviceTime == 0 && !line.isEmpty()) {

                serviceTime = random.nextInt(4) + 1 + i; // start serving , when there are people in queue
            }

            System.out.printf("Time: \t\t     %1d minutes%n", i);
            System.out.printf("Number of customers: %d customers", customerNumber);
            System.out.println();System.out.println();
        }

        System.out.println();
        System.out.printf("Peak queue line had %d customers, at the %d minutes of the day", length, peakQueueTime);System.out.println();
        
    }


    public static void main(String[] args) {

        ChecklistQueue RDC = new ChecklistQueue();
        RDC.superMarket();
    }

}
