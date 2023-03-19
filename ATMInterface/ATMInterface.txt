import java.util.ArrayList;
import java.util.Scanner;

public class ATMInterface {

    private static double balance = 1000.0; // initial balance
    
    private static ArrayList<String> transactions = new ArrayList<>(); // transaction history
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        int choice = 0;
        
        while (choice != 5) {
            
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            
            System.out.print("Enter choice: ");
            choice = input.nextInt();
            
            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = input.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = input.nextDouble();
                    deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient's account number: ");
                    String recipient = input.next();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = input.nextDouble();
                    transfer(recipient, transferAmount);
                    break;
                case 5:
                    System.out.println("Have a Great Day!");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
                    break;
            }
            
            System.out.println();
        }
        
        input.close();
    }
    
    private static void showTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }
    
    private static void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            String transaction = String.format("Withdraw: $%.2f", amount);
            transactions.add(transaction);
            System.out.println("Withdrawal Successful.");
        }
    }
    
    private static void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            balance += amount;
            String transaction = String.format("Deposit: $%.2f", amount);
            transactions.add(transaction);
            System.out.println("Deposit Successful.");
        }
    }
    
    private static void transfer(String recipient, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            String transaction = String.format("Transfer to %s: $%.2f", recipient, amount);
            transactions.add(transaction);
            System.out.println("Transfer successful.");
        }
    }
}
