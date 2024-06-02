import java.util.Scanner;

class BankAccount {
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

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest of Rs." + interest + " added to the account.");
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double overdraftLimit) {
        super(accountNumber);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() + overdraftLimit >= amount) {
            super.withdraw(amount);
        } else {
            System.out.println("Transaction declined. Overdraft limit exceeded.");
        }
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SavingsAccount savingsAccount = new SavingsAccount("SA1087", 7.0);

        CurrentAccount currentAccount = new CurrentAccount("CA1087", 640.0);

        savingsAccount.deposit(1000);
        savingsAccount.addInterest();
        System.out.println("Savings Account Balance: Rs." + savingsAccount.getBalance());

        currentAccount.deposit(500);
        currentAccount.withdraw(700);
        System.out.println("Current Account Balance: Rs." + currentAccount.getBalance());

        scanner.close();
    }
}
