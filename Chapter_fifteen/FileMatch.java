package Chapter_fifteen;

import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Formatter;
import java.util.Scanner;

public class FileMatch {
    
    private static Account account;
    private static TransactionRecord transactionRecord;
    private static Scanner transaction;
    private static Scanner oldMast;
    private static Formatter newMast;
    private static Formatter log;

    public static void main(String[] args) {

        openFile();
        readRecords();
        closeFile();

    }

    // open files all the text
    public static void openFile() {
        

        try {

            transaction = new Scanner(Paths.get("trans.txt"));
            oldMast = new Scanner(Paths.get("oldMast.txt"));
            newMast = new Formatter("newMast.txt");
            log = new Formatter("log.txt");
        } catch (IOException ioException) {

            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
    }
   
    // read record from file
    public static void readRecords() {

        try {

            // Read first records
            account = new Account(
                    oldMast.nextInt(),
                    oldMast.next(),
                    oldMast.next(),
                    oldMast.nextDouble());

            transactionRecord = new TransactionRecord(
                    transaction.nextInt(),
                    transaction.nextDouble());

            while (true) {

                if (account.getAccount() == transactionRecord.getAccountNumber()) {

                    while(account.getAccount() == transactionRecord.getAccountNumber()) {

                        account.combine(transactionRecord);


                        // Read next transaction
                        if (transaction.hasNext()) {
                            transactionRecord = new TransactionRecord(
                                    transaction.nextInt(),
                                    transaction.nextDouble());
                        } else {
                            transactionRecord = null;
                        }
                    }

                    
                    newMast.format("%d %s %s %.2f%n",
                        account.getAccount(),
                        account.getFirstName(),
                        account.getLastName(),
                        account.getBalance());

                    // Read next account
                    if (oldMast.hasNext()) {
                        account = new Account(
                                oldMast.nextInt(),
                                oldMast.next(),
                                oldMast.next(),
                                oldMast.nextDouble());
                    } else {
                        account = null;
                    }


                }

                else if (account.getAccount() < transactionRecord.getAccountNumber()) {

                    newMast.format("%d %s %s %.2f%n",
                            account.getAccount(),
                            account.getFirstName(),
                            account.getLastName(),
                            account.getBalance());

                    if (oldMast.hasNext()) {
                        account = new Account(
                                oldMast.nextInt(),
                                oldMast.next(),
                                oldMast.next(),
                                oldMast.nextDouble());
                    } else {
                        account = null;
                    }

                }

                else {

                    log.format(
                            "Unmatched transaction record for account number %d%n",
                            transactionRecord.getAccountNumber());

                    if (transaction.hasNext()) {
                        transactionRecord = new TransactionRecord(
                                transaction.nextInt(),
                                transaction.nextDouble());
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

                newMast.format("%d %s %s %.2f%n",
                        account.getAccount(),
                        account.getFirstName(),
                        account.getLastName(),
                        account.getBalance());

                if (oldMast.hasNext()) {
                    account = new Account(
                            oldMast.nextInt(),
                            oldMast.next(),
                            oldMast.next(),
                            oldMast.nextDouble());
                } else {
                    account = null;
                }
            }

            // Log remaining transaction records
            while (transactionRecord != null) {

                log.format(
                        "Unmatched transaction record for account number %d%n",
                        transactionRecord.getAccountNumber());

                if (transaction.hasNext()) {
                    transactionRecord = new TransactionRecord(
                            transaction.nextInt(),
                            transaction.nextDouble());
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
