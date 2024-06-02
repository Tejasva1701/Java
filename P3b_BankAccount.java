package bank;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of Rs." + amount + " successful.");
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal of Rs." + amount + " successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }
}
