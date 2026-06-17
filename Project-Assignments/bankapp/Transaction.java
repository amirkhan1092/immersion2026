package bankapp;

public class Transaction {

    private int fromAccount;
    private int toAccount;
    private double amount;

    public Transaction(int fromAccount,
                       int toAccount,
                       double amount) {

        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    public void displayTransaction() {

        System.out.println("\nTransaction Details");
        System.out.println("From Account : " + fromAccount);
        System.out.println("To Account   : " + toAccount);
        System.out.println("Amount       : Rs." + amount);
    }
}