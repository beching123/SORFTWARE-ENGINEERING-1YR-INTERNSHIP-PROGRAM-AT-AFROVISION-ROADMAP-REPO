// Fig. 23.26: PrimeCalculator.java
// Calculates the First n prime, displaying them as they are found.
package java_code.ch23;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingWorker;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class PrimeCalculator extends SwingWorker<Integer, Integer> {

    private static final SecureRandom generator = new SecureRandom();
    private final JTextArea intermidiateJTextArea; // displays found primes
    private final JButton getPrimesJButton;
    private final JButton cancelJButton;
    private final JLabel statusJLabel; // displays status of calculation
    private final boolean[] primes; // boolean array for finding primes

    // constructor
    public PrimeCalculator(int max, JTextArea intermidiateJTextArea, JLabel statusJLabel, JButton getPrimeJButton,
            JButton cancelJButton) {

        this.intermidiateJTextArea = intermidiateJTextArea;
        this.statusJLabel = statusJLabel;
        this.getPrimesJButton = getPrimeJButton;
        this.cancelJButton = cancelJButton;
        primes = new boolean[max];

        Arrays.fill(primes, true); // initialize all primes elements to true
    }

    // finds all primes up to max using the Sieve of Eratosthenes
    public Integer doInBackground() {

        int count = 0; // the number of primes found

        // starting at the third value, cycle through the array and put
        // false as the value of any greater number that is a multiple
        for (int i = 2; i < primes.length; i++) {

            if (isCancelled()) // if calculaiton has been canceled
                return count;
            else {

                setProgress(100 * (i + 1) / primes.length);

                try {

                    Thread.sleep(generator.nextInt(5));
                }

                catch (InterruptedException ex) {

                    statusJLabel.setText("Worker thread interrupted");
                    return count;
                }

                if (primes[i]) // i is prime
                {
                    publish(i); // make i available for display in prime list
                    ++count;

                    for (int j = i + i; j < primes.length; j += i)
                        primes[j] = false; // i is not prime
                }
            }
        }

        return count;
    }

    // displays published values in primes list
    protected void process(List<Integer> publishedValue) {

        for (int i = 0; i < publishedValue.size(); i++)
            intermidiateJTextArea.append(publishedValue.get(i) + "\n");
    }

    // code to execute when doInBackground completes
    protected void done() {

        getPrimesJButton.setEnabled(true); // enable Get Primes button

        cancelJButton.setEnabled(false); // disable Cancel button

        try {

            // retrieve and display doInBackground return value
            statusJLabel.setText("Fount " + get() + " Primes.");
        }

        catch (InterruptedException | ExecutionException | CancellationException ex) {
            statusJLabel.setText(ex.getMessage());
        }
    }
} // end class PrimeCalculator