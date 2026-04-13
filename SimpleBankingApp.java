import java.util.Scanner;

public class SimpleBankingApp {

    // A static variable to hold the account balance. Using static allows methods to
    // access and modify it without passing it as an argument.
    private static double balance = 1000.00; // initial balance

    public static void main(String[] args) {
        // Create a Scanner object to read user input from the console.
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Simple Banking Application!");
        System.out.println("Your initial balance is: $" + balance);
         System.out.println("\n--- Main Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

        // Use a do-while loop to repeatedly display the menu until the user chooses to exit.
        do {
            // Display the menu of banking options.
           
            System.out.print("Please enter your choice: ");

            // Read the user's choice using the Scanner object.
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 4.");
                scanner.next(); // Clear the invalid input from the scanner buffer.
                continue; // Skip the rest of the loop and show the menu again.
            }

            // Use a switch statement to perform an action based on the user's choice.
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    exit = true; // Set the flag to exit the loop.
                    System.out.println("Thank you for using the Simple Banking App. Goodbye!");
                    break;
                default:
                    // Handle invalid choices.
                    System.out.println("Invalid choice. Please select a valid option (1-4).");
                    break;
            }
        } while (!exit);

        // Close the scanner object to prevent resource leaks.
        scanner.close();
    }

    /**
     * Method to handle a deposit operation.
     * It updates the global 'balance' variable.
     * @param amount The amount to deposit.
     */
    public static void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposit successful. Your new balance is $%.2f%n", balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    /**
     * Method to handle a withdrawal operation.
     * It checks if there is sufficient balance before deducting the amount.
     * @param amount The amount to withdraw.
     */
    public static void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else {
            balance -= amount;
            System.out.printf("Withdrawal successful. Your new balance is $%.2f%n", balance);
        }
    }

    /**
     * Method to display the current account balance.
     */
    public static void checkBalance() {
        System.out.printf("Your current balance is: $%g%n", balance);
    }
}
