import java.util.Scanner;

public class ATM {
    private double balance;
    private int pin;

    public ATM(double balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin == pin) {
            int choice;
            do {
                System.out.println("\n--- ATM Menu ---");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> checkBalance();
                    case 2 -> deposit(sc);
                    case 3 -> withdraw(sc);
                    case 4 -> System.out.println("Thank you for using the ATM!");
                    default -> System.out.println("Invalid choice!");
                }
            } while (choice != 4);
        } else {
            System.out.println("Incorrect PIN!");
        }
        sc.close();
    }

    private void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    private void deposit(Scanner sc) {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        balance += amount;
        System.out.println("Deposited $" + amount + ". New balance: $" + balance);
    }

    private void withdraw(Scanner sc) {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + ". Remaining balance: $" + balance);
        } else {
            System.out.println("Insufficient funds!");
