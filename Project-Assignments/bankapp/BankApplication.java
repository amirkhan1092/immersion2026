package bankapp;

import java.util.Scanner;

public class BankApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();

        bank.addAccount(
                new BankAccount(
                        1001,
                        "Rahul Sharma",
                        "Savings",
                        50000));

        bank.addAccount(
                new BankAccount(
                        1002,
                        "Priya Verma",
                        "Savings",
                        30000));

        bank.addAccount(
                new BankAccount(
                        1003,
                        "Amit Kumar",
                        "Current",
                        70000));

        int choice;

        do {

            System.out.println(
                    "\n===== BANK MENU =====");

            System.out.println(
                    "1. View Balance");

            System.out.println(
                    "2. Transfer Amount");

            System.out.println(
                    "3. Display Accounts");

            System.out.println(
                    "4. Exit");

            System.out.print(
                    "Enter Choice : ");

            choice = sc.nextInt();

            try {

                switch(choice) {

                    case 1:

                        System.out.print(
                                "Enter Account No : ");

                        int accNo =
                                sc.nextInt();

                        bank.viewBalance(accNo);
                        break;

                    case 2:

                        System.out.print(
                                "Sender Account : ");

                        int sender =
                                sc.nextInt();

                        System.out.print(
                                "Receiver Account : ");

                        int receiver =
                                sc.nextInt();

                        System.out.print(
                                "Amount : ");

                        double amount =
                                sc.nextDouble();

                        bank.transferAmount(
                                sender,
                                receiver,
                                amount);

                        break;

                    case 3:

                        bank.displayAllAccounts();
                        break;

                    case 4:

                        System.out.println(
                                "Thank You");
                        break;

                    default:

                        System.out.println(
                                "Invalid Choice");
                }

            } catch(Exception e) {

                System.out.println(
                        "Error : "
                        + e.getMessage());
            }

        } while(choice != 4);

        sc.close();
    }
}