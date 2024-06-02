package bank;

public class CurrentAccount extends BankAccount {
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
