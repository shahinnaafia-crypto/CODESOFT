// Author: Shahin Naafia S
// College: Sona College of Technology
// Internship: CodSoft Java Development Internship
// Task 3: ATM Interface

import java.util.Scanner;

class ShahinBankAccount {
    private double accountBalance;
    private String accountHolder;

    public ShahinBankAccount(String name, double startingBalance) {
        this.accountHolder = name;
        this.accountBalance = startingBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public boolean withdrawMoney(double withdrawAmount) {
        if (withdrawAmount <= 0) {
            System.out.println("Invalid amount entered!");
            return false;
        }
        if (withdrawAmount > accountBalance) {
            System.out.println("Sorry! Not enough balance.");
            return false;
        }
        accountBalance -= withdrawAmount;
        return true;
    }

    public boolean depositMoney(double depositAmount) {
        if (depositAmount <= 0) {
            System.out.println("Invalid amount entered!");
            return false;
        }
        accountBalance += depositAmount;
        return true;
    }
}

public class ATMInterface {

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        ShahinBankAccount myAccount = new ShahinBankAccount("Shahin Naafia", 15000.00);

        System.out.println("*********************************************");
        System.out.println("       WELCOME TO SHAHIN'S ATM SYSTEM        ");
        System.out.println("*********************************************");
        System.out.println("Account Holder : " + myAccount.getAccountHolder());
        System.out.println("*********************************************");

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--------- MAIN MENU ---------");
            System.out.println("1. Check Account Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit ATM");
            System.out.println("------------------------------");
            System.out.print("Enter your choice (1-4): ");

            int userChoice = inputReader.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println("\nCurrent Balance: Rs." + 
                        String.format("%.2f", myAccount.getAccountBalance()));
                    break;

                case 2:
                    System.out.print("\nEnter amount to deposit: Rs.");
                    double depositAmt = inputReader.nextDouble();
                    if (myAccount.depositMoney(depositAmt)) {
                        System.out.println("Successfully deposited Rs." + depositAmt);
                        System.out.println("New Balance: Rs." + 
                            String.format("%.2f", myAccount.getAccountBalance()));
                    }
                    break;

                case 3:
                    System.out.print("\nEnter amount to withdraw: Rs.");
                    double withdrawAmt = inputReader.nextDouble();
                    if (myAccount.withdrawMoney(withdrawAmt)) {
                        System.out.println("Successfully withdrawn Rs." + withdrawAmt);
                        System.out.println("Remaining Balance: Rs." + 
                            String.format("%.2f", myAccount.getAccountBalance()));
                    }
                    break;

                case 4:
                    System.out.println("\nThank you for using Shahin's ATM!");
                    System.out.println("Have a great day! Goodbye!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Wrong choice! Please enter 1 to 4 only.");
            }
        }

        inputReader.close();
    }
}