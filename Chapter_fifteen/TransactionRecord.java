package Chapter_fifteen;

import java.io.Serializable;

public class TransactionRecord implements Serializable {

    private int accountNumber;
    private double amount;

    public TransactionRecord(int accountNumber, double amount) {

        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    // setters and getters
    public void setAmount(double amount) {

        this.amount = amount;
    }

    public void setAccountNumber(int accountNumber) {

        this.accountNumber = accountNumber;
    }

    // getters
    public int getAccountNumber() {

        return accountNumber;
    }

    public double getAmount() {

        return amount;
    }
}
