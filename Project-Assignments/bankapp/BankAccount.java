package bankapp;

public class BankAccount {

    private int accountNumber;
    private String accountHolderName;
    private String accountType;
    private double balance;

    public BankAccount(int accountNumber,
                       String accountHolderName,
                       String accountType,
                       double balance) {

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount)
            throws InsufficientBalanceException {

        if(amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient Balance");
        }

        balance -= amount;
    }

    public void displayDetails() {

        System.out.println("--------------------------------");
        System.out.println("Account No : " + accountNumber);
        System.out.println("Name       : " + accountHolderName);
        System.out.println("Type       : " + accountType);
        System.out.println("Balance    : Rs." + balance);
    }
}