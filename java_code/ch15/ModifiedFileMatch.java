package Chapter_fifteen;

import java.io.IOException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ModifiedFileMatch {

    private static Account account;
    private static TransactionRecord  transactionRecord;
    private static ObjectInputStream  transaction;
    private static ObjectInputStream  oldMast;
    private static ObjectOutputStream newMast;
    private static ObjectOutputStream log;

    public static void main(String[] args) {

        openFile();
        readRecords();
        closeFile();

    }

    // open files all the text
    public static void openFile() {

        try {

            transaction = new ObjectInputStream(new FileInputStream("trans.ser"));
            oldMast = new ObjectInputStream(new FileInputStream("oldMast.ser"));
            newMast = new ObjectOutputStream(new FileOutputStream("newMast.ser"));
            log = new ObjectOutputStream(new FileOutputStream("log.ser"));

        } catch (IOException ioException) {

            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
    }

    // read record from file
    public static void readRecords() {

        try {

            // Read first records
            account = (Account) oldMast.readObject();
            transactionRecord = (TransactionRecord) transaction.readObject();

            while (true) {

                if (account.getAccount() == transactionRecord.getAccountNumber()) {

                    while (account.getAccount() == transactionRecord.getAccountNumber()) {

                        account.combine(transactionRecord);

                        // Read next transaction
                        if (transaction.hasNext()) {
                            transactionRecord = (TransactionRecord) transaction.readObject();
                        } else {
                            transactionRecord = null;
                        }
                    }

                    newMast.writeObject(account);

                    // Read next account
                    if (oldMast.hasNext()) {
                        account = (Account) oldMast.readObject();
                    } else {
                        account = null;
                    }

                }

                else if (account.getAccount() < transactionRecord.getAccountNumber()) {

                    newMast.writeObject(account);

                    if (oldMast.hasNext()) {
                        account = (Account) oldMast.readObject();
                    } else {
                        account = null;
                    }

                }

                else {

                    log.writeObject("Unmatched transaction record for the account number" + transactionRecord.getAccountNumber());

                    if (transaction.hasNext()) {
                        transactionRecord = (TransactionRecord) transaction.readObject();
                    } else {
                        transactionRecord = null;
                    }

                }

                // Stop when one file finishes
                if (account == null || transactionRecord == null)
                    break;
            }

            // Write remaining master records
            while (account != null) {

                newMast.writeObject(account);

                if (oldMast.hasNext()) {
                    account = (Account) oldMast.readObject();
                } else {
                    account = null;
                }
            }

            // Log remaining transaction records
            while (transactionRecord != null) {

                log.writeObject("Unwanted transaction record for account number" + transactionRecord.getAccountNumber());

                if (transaction.hasNext()) {
                    transactionRecord = (TransactionRecord) transaction.readObject();
                } else {
                    transactionRecord = null;
                }
            }

        } catch (NoSuchElementException e) {

            System.err.println("Error reading file.");

        } catch (IllegalStateException e) {

            System.err.println("Error processing file.");
        }
    }

    // closing files.
    public static void closeFile() {

        if (newMast != null && log != null) {

            newMast.close();
            log.close();

        }
    }
}
