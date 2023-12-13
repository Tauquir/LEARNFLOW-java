package internship;

import java.util.Scanner;

public class bankingSystem {
    public static void main(String[] args) {
        BankAccount user1 = new BankAccount("123456789", "Tauquir", 1000.0);
        BankAccount user2 = new BankAccount("987654321", "Muzammil", 500.0);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println();
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            System.out.println();

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Account Balance: " + user1.getBalance()+" Rs");
                    break;
                case 2:
                    System.out.print("Enter deposit amount: "+"Rs");
                    double depositAmount = sc.nextDouble();
                    user1.deposit(depositAmount);
                    System.out.println("Deposit successful. New balance: " + user1.getBalance()+" Rs");
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: "+" Rs");
                    double withdrawalAmount = sc.nextDouble();
                    user1.withdraw(withdrawalAmount);
                    System.out.println("Withdrawal successful. New balance: " + user1.getBalance()+" Rs");
                    break;
                case 4:
                    System.out.print("Enter recipient's account number: ");
                    String recipientAccountNumber = sc.next();
                    BankAccount recipient = (recipientAccountNumber.equals(user2.getAccountNumber())) ? user2 : null;

                    if (recipient != null) {
                        System.out.print("Enter transfer amount: "+"Rs");
                        double transferAmount = sc.nextDouble();
                        user1.transfer(recipient, transferAmount);
                        System.out.println("Transfer successful. New balance: " + user1.getBalance()+" Rs");
                    } else {
                        System.out.println("Recipient not found.");
                    }
                    break;
                case 5:
                    System.out.println("Transaction History:");
                    for (Transaction transaction : user1.getTransactionHistory()) {
                        System.out.println(transaction.getDescription() + ": "+"Rs" + transaction.getAmount());
                    }
                    break;
                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
