
# Project: Bank Transaction Management System

## Package Structure

```text
bankapp
│
├── BankAccount.java
├── Bank.java
├── Transaction.java
├── AccountNotFoundException.java
├── InsufficientBalanceException.java
└── BankApplication.java
```

---
# Java OOP Project: Bank Transaction Management System

## Problem Statement

A bank wants to automate its daily customer transactions through a console-based application. Currently, customers must visit the bank branch or contact customer support to know their account balance and perform fund transfers. To improve customer convenience and reduce manual work, the bank has decided to develop a Java application using Object-Oriented Programming principles.

The application should maintain customer account information and provide basic banking services such as checking account balance and transferring money between accounts.

Each customer account should have details such as account number, account holder name, account type, and account balance.

The system must allow customers to:

* View the balance of a specific account.
* Transfer money from one account to another account.

Before a transfer is performed, the application must validate the transaction according to banking rules.

### Conditions for Successful Transfer

1. The sender account number must exist.
2. The receiver account number must exist.
3. Transfer amount must be greater than zero.
4. Sender account must have sufficient balance.
5. The transfer should update both account balances correctly.
6. Appropriate success or error messages should be displayed.

The application should be developed using classes, objects, constructors, encapsulation, and object interaction.

---

# Functional Requirements

## Class: BankAccount

### Data Members

```java
accountNumber
accountHolderName
accountType
balance
```

### Methods

```java
BankAccount()           // Constructor
deposit()
withdraw()
displayAccountDetails()
getBalance()
transferAmount()
```

---

## Class: Bank

### Data Members

```java
BankAccount[] accounts
```

### Methods

```java
searchAccount()
viewBalance()
transferMoney()
displayAllAccounts()
```

---

## Operations to Perform

1. Create at least 5 bank accounts.
2. Display account details.
3. View balance using account number.
4. Transfer money between accounts.
5. Validate account numbers.
6. Validate sufficient balance.
7. Display updated balances after transfer.
8. Exit from application.

---

# Sample Input/Output

```text
=========== BANK MENU ===========
1. View Balance
2. Transfer Amount
3. Display All Accounts
4. Exit

Enter Choice: 1

Enter Account Number:
1001

Current Balance: Rs.50000.0
```

---

```text
=========== BANK MENU ===========
1. View Balance
2. Transfer Amount
3. Display All Accounts
4. Exit

Enter Choice: 2

Enter Sender Account Number:
1001

Enter Receiver Account Number:
1002

Enter Amount:
10000

Transfer Successful.

Amount Transferred : Rs.10000

Updated Sender Balance : Rs.40000

Updated Receiver Balance : Rs.35000
```

---

```text
Enter Sender Account Number:
1001

Enter Receiver Account Number:
1002

Enter Amount:
100000

Insufficient Balance.
Transfer Failed.
```

---

# Complete Java Solution

```java
import java.util.Scanner;

class BankAccount {

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

    public boolean withdraw(double amount) {

        if (amount <= balance) {
            balance = balance - amount;
            return true;
        }

        return false;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void displayAccountDetails() {

        System.out.println("---------------------------");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Account Type   : " + accountType);
        System.out.println("Balance        : Rs." + balance);
    }
}

class Bank {

    private BankAccount[] accounts;

    public Bank(BankAccount[] accounts) {
        this.accounts = accounts;
    }

    public BankAccount searchAccount(int accountNumber) {

        for (BankAccount account : accounts) {

            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }

    public void viewBalance(int accountNumber) {

        BankAccount account = searchAccount(accountNumber);

        if (account != null) {
            System.out.println("Current Balance : Rs."
                    + account.getBalance());
        } else {
            System.out.println("Invalid Account Number");
        }
    }

    public void transferMoney(int senderAcc,
                              int receiverAcc,
                              double amount) {

        BankAccount sender =
                searchAccount(senderAcc);

        BankAccount receiver =
                searchAccount(receiverAcc);

        if (sender == null) {
            System.out.println("Sender Account Not Found");
            return;
        }

        if (receiver == null) {
            System.out.println("Receiver Account Not Found");
            return;
        }

        if (amount <= 0) {
            System.out.println("Invalid Amount");
            return;
        }

        if (sender.withdraw(amount)) {

            receiver.deposit(amount);

            System.out.println("\nTransfer Successful");
            System.out.println("Transferred Amount : Rs."
                    + amount);

            System.out.println("Sender Balance : Rs."
                    + sender.getBalance());

            System.out.println("Receiver Balance : Rs."
                    + receiver.getBalance());

        } else {

            System.out.println(
                    "Insufficient Balance. Transfer Failed.");
        }
    }

    public void displayAllAccounts() {

        for (BankAccount account : accounts) {
            account.displayAccountDetails();
        }
    }
}

public class BankTransactionSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount[] accounts = {

            new BankAccount(
                    1001,
                    "Rahul Sharma",
                    "Savings",
                    50000),

            new BankAccount(
                    1002,
                    "Priya Verma",
                    "Savings",
                    25000),

            new BankAccount(
                    1003,
                    "Amit Kumar",
                    "Current",
                    80000),

            new BankAccount(
                    1004,
                    "Neha Singh",
                    "Savings",
                    45000),

            new BankAccount(
                    1005,
                    "Arjun Patel",
                    "Current",
                    60000)
        };

        Bank bank = new Bank(accounts);

        int choice;

        do {

            System.out.println("\n========== BANK MENU ==========");
            System.out.println("1. View Balance");
            System.out.println("2. Transfer Amount");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print(
                            "Enter Account Number: ");

                    int accNo = sc.nextInt();

                    bank.viewBalance(accNo);
                    break;

                case 2:

                    System.out.print(
                            "Enter Sender Account Number: ");

                    int sender = sc.nextInt();

                    System.out.print(
                            "Enter Receiver Account Number: ");

                    int receiver = sc.nextInt();

                    System.out.print(
                            "Enter Amount: ");

                    double amount = sc.nextDouble();

                    bank.transferMoney(
                            sender,
                            receiver,
                            amount);

                    break;

                case 3:

                    bank.displayAllAccounts();
                    break;

                case 4:

                    System.out.println(
                            "Thank You For Using Bank System");
                    break;

                default:

                    System.out.println(
                            "Invalid Choice");
            }

        } while (choice != 4);

        sc.close();
    }
}
```

---

# OOP Concepts Covered

| Concept             | Implementation                         |
| ------------------- | -------------------------------------- |
| Class               | BankAccount, Bank                      |
| Object              | Multiple BankAccount objects           |
| Encapsulation       | Private data members                   |
| Constructor         | Account initialization                 |
| Methods             | deposit(), withdraw(), transferMoney() |
| Association         | Bank manages BankAccount objects       |
| Array of Objects    | Multiple accounts stored in array      |
| Menu Driven Program | User interaction through console       |
| Validation          | Account existence and balance checks   |

### Marks Distribution (100 Marks)

| Criteria              | Marks |
| --------------------- | ----- |
| Class Design          | 15    |
| Constructors          | 10    |
| Encapsulation         | 10    |
| Object Creation       | 10    |
| Transfer Logic        | 20    |
| Balance Validation    | 10    |
| Menu Driven Interface | 10    |
| Output & Formatting   | 5     |
| Code Quality          | 10    |

This project is suitable for a **3-hour OOP practical exam** and assesses classes, objects, constructors, encapsulation, arrays of objects, and object interaction in a realistic banking scenario.
