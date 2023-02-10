package pset;

import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private static double annualInterestRate = 0;
    private Date dateCreated;

    Account() {
        // can also invoke the other constructor
         this(0,0.0);
    }

    Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }

    // creating getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public static double getMonthlyInterestRate() {
        return getAnnualInterestRate() / 12.0;
    }

    public double getMonthlyInterest() {
        return getBalance() * getMonthlyInterestRate() / 100.0;
    }

    public void withdraw(double amount) {
        setBalance(getBalance() - amount);
    }

    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }
}
