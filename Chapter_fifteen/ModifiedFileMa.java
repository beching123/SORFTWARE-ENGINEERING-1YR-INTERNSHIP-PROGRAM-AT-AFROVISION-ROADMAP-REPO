package Chapter_fifteen;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ModifiedFileMa {

    private static Account account;
    private static TransactionRecord transactionRecord;
    private static ObjectInputStream transaction;
    private static ObjectInputStream oldMast;
    private static ObjectOutputStream newMast;
    private static ObjectOutputStream log;

    public static void main(String[] args) {
        openFile();
        readRecords();
        closeFile();
    }

    // Open files for object serialization
    public static void openFile() {
        try {
            transaction = new ObjectInputStream(new FileInputStream("trans.ser"));
            oldMast = new ObjectInputStream(new FileInputStream("oldMast.ser"));
            newMast = new ObjectOutputStream(new FileOutputStream("newMast.ser"));
            log = new ObjectOutputStream(new FileOutputStream("log.ser"));
        } catch (IOException ioException) {
            System.err.println("Error opening files. Terminating.");
            System.exit(1);
        }
    }

    // Helper method: Reads the next Account, returns null if end of file
    private static Account getNextAccount() {
        try {
            return (Account) oldMast.readObject();
        } catch (EOFException e) {
            return null; // End of file reached naturally
        } catch (ClassNotFoundException | IOException e) {
            System.err.println("Error reading account.");
            return null;
        }
    }

    // Helper method: Reads the next TransactionRecord, returns null if end of file
    private static TransactionRecord getNextTransaction() {
        try {
            return (TransactionRecord) transaction.readObject();
        } catch (EOFException e) {
            return null; // End of file reached naturally
        } catch (ClassNotFoundException | IOException e) {
            System.err.println("Error reading transaction.");
            return null;
        }
    }

    // Read records and match them
    public static void readRecords() {
        try {
            // Read first records using our helper methods
            account = getNextAccount();
            transactionRecord = getNextTransaction();

            // Main matching loop
            while (account != null && transactionRecord != null) {
                
                if (account.getAccount() == transactionRecord.getAccountNumber()) {
                    // Process multiple transactions for the same account
                    while (transactionRecord != null && account.getAccount() == transactionRecord.getAccountNumber()) {
                        account.combine(transactionRecord);
                        transactionRecord = getNextTransaction(); // Replaces hasNext() check
                    }
                    newMast.writeObject(account);
                    account = getNextAccount();
                } 
                else if (account.getAccount() < transactionRecord.getAccountNumber()) {
                    // No transactions for this master record, write it to new file as-is
                    newMast.writeObject(account);
                    account = getNextAccount();
                } 
                else {
                    // Transaction account number is less than master (Unmatched transaction)
                    log.writeObject("Unmatched transaction record for account number: " + transactionRecord.getAccountNumber());
                    transactionRecord = getNextTransaction();
                }
            }

            // Write remaining master records if transaction file ends first
            while (account != null) {
                newMast.writeObject(account);
                account = getNextAccount();
            }

            // Log remaining transaction records if master file ends first
            while (transactionRecord != null) {
                log.writeObject("Unmatched transaction record for account number: " + transactionRecord.getAccountNumber());
                transactionRecord = getNextTransaction();
            }

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Close all streams properly
    public static void closeFile() {
        try {
            if (oldMast != null) oldMast.close();
            if (transaction != null) transaction.close();
            if (newMast != null) newMast.close();
            if (log != null) log.close();
        } catch (IOException e) {
            System.err.println("Error closing files.");
        }
    }
}