import java.util.Scanner;

class FoodItem {
    private int itemId;
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(int itemId, String itemName, double price, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Calculate Amount
    public double calculateAmount() {
        return price * quantity;
    }

    // Display Item Details
    public void displayItemDetails() {
        System.out.println("\nItem ID      : " + itemId);
        System.out.println("Item Name    : " + itemName);
        System.out.println("Price        : " + price);
        System.out.println("Quantity     : " + quantity);
        System.out.println("Amount       : " + calculateAmount());
    }

    public double getAmount() {
        return calculateAmount();
    }
}

class Customer {
    private int customerId;
    private String customerName;
    private String mobileNumber;

    // Constructor
    public Customer(int customerId, String customerName, String mobileNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
    }

    // Display Customer Details
    public void displayCustomerDetails() {
        System.out.println("\n========== CUSTOMER DETAILS ==========");
        System.out.println("Customer ID   : " + customerId);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Mobile Number : " + mobileNumber);
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Customer Input
        System.out.println("Enter Customer ID:");
        int customerId = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Customer Name:");
        String customerName = sc.nextLine();

        System.out.println("Enter Mobile Number:");
        String mobileNumber = sc.nextLine();

        Customer customer = new Customer(
                customerId,
                customerName,
                mobileNumber
        );

        System.out.println("\nEnter Number of Food Items:");
        int n = sc.nextInt();

        FoodItem[] items = new FoodItem[n];

        double totalBill = 0;

        // Input Food Items
        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter Details for Item " + (i + 1));

            System.out.print("Item ID: ");
            int itemId = sc.nextInt();

            sc.nextLine();

            System.out.print("Item Name: ");
            String itemName = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            items[i] = new FoodItem(
                    itemId,
                    itemName,
                    price,
                    quantity
            );

            totalBill += items[i].getAmount();
        }

        // Display Order Summary
        customer.displayCustomerDetails();

        System.out.println("\n========== ORDER SUMMARY ==========");

        for (int i = 0; i < n; i++) {
            items[i].displayItemDetails();
        }

        System.out.println("\n==================================");
        System.out.println("Total Bill Amount : " + totalBill);
        System.out.println("==================================");

        sc.close();
    }
}