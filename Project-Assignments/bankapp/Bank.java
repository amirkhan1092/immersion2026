package bankapp;

import java.util.ArrayList;

public class Bank {

    private ArrayList<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount searchAccount(int accountNo)
            throws AccountNotFoundException {

        for(BankAccount account : accounts) {

            if(account.getAccountNumber() == accountNo) {
                return account;
            }
        }

        throw new AccountNotFoundException(
                "Account Not Found");
    }

    public void viewBalance(int accountNo)
            throws AccountNotFoundException {

        BankAccount account =
                searchAccount(accountNo);

        System.out.println(
                "Current Balance : Rs."
                + account.getBalance());
    }

    public void transferAmount(int sender,
                               int receiver,
                               double amount)
            throws AccountNotFoundException,
                   InsufficientBalanceException {

        BankAccount senderAcc =
                searchAccount(sender);

        BankAccount receiverAcc =
                searchAccount(receiver);

        senderAcc.withdraw(amount);

        receiverAcc.deposit(amount);

        Transaction t =
                new Transaction(sender,
                                receiver,
                                amount);

        t.displayTransaction();

        System.out.println(
                "\nTransfer Successful");
    }

    public void displayAllAccounts() {

        for(BankAccount account : accounts) {
            account.displayDetails();
        }
    }
}