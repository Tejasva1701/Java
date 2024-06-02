package main;

import bank.BankAccount;
import bank.SavingsAccount;
import bank.CurrentAccount;

public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount savingsAccount = new SavingsAccount("SA1087", 6.0);
        BankAccount currentAccount = new CurrentAccount("CA1087", 720.0);

        savingsAccount.deposit(1000);
        savingsAccount.withdraw(200);
        ((SavingsAccount) savingsAccount).addInterest();

        currentAccount.deposit(500);
        currentAccount.withdraw(700);

        System.out.println("Savings Account Balance: Rs." + savingsAccount.getBalance());
        System.out.println("Current Account Balance: Rs." + currentAccount.getBalance());
    }
}
