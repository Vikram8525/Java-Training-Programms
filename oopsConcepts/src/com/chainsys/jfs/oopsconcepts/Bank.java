package com.chainsys.jfs.oopsconcepts;

public class Bank {

    public void deposit(String accountType) {
        System.out.println("Opening a " + accountType + " account");
    }

    public void deposit(String accountType, String accountNumber) {
        System.out.println("Opening a " + accountType + " for account number " + accountNumber);
    }

    public void deposit(double accountNumber) {
        System.out.println("Checking balance for account " + accountNumber);
    }

    public void deposit(int amount) {
        System.out.println("Depositing $" + amount);
    }

    public void deposit(int amount, String accountNumber) {
        System.out.println("Depositing $" + amount + " into account " + accountNumber);
    }

    public void deposit(double amount, String accountNumber) {
        System.out.println("Withdrawing $" + amount + " from account " + accountNumber);
    }

    public void deposit(double amount, String fromAccount, String toAccount) {
        System.out.println("Transferring $" + amount + " from account " + fromAccount + " to account " + toAccount);
    }

    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.deposit("Savings");
        bank.deposit("Savings", "123456789");
        bank.deposit("123456789");
        bank.deposit(1000.00);
        bank.deposit(500.00, "123456789");
        bank.deposit(200.00);
        bank.deposit(100.00, "987654321");
        bank.deposit(300.00, "123456789", "987654321");
    }
}
