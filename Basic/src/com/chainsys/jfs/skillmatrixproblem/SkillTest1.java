package com.chainsys.jfs.skillmatrixproblem;

import java.util.Scanner;

public class SkillTest1 {

    public static void main(String[] args) {
        String name;
        long accountNumber;
        String IFSC;
        double existingBalance = 10000;
        double deposit;
        int withdrawal;

        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("---------------------------------------------------");
            System.out.println("For balance checking, press B/b");
            System.out.println("For Deposit, press D/d");
            System.out.println("For Withdrawal, press W/w");
            System.out.println("To exit, press E/e");
            System.out.println("Enter your choice:");

            String method = sc.next().toLowerCase();

            switch (method) {
                case "b":
                    System.out.println("Your available balance is " + existingBalance);
                    break;

                case "d":
                    System.out.println("Enter amount to be added to your account:");
                    deposit = sc.nextDouble();
                    existingBalance = existingBalance + deposit;
                    System.out.println("The amount after deposit is " + existingBalance);
                    break;

                case "w":
                    System.out.println("Enter amount to be withdrawn:");
                    withdrawal = sc.nextInt();
                    if (withdrawal > existingBalance) {
                        System.out.println("Insufficient balance. Withdrawal cannot be processed.");
                    } else {
                        existingBalance = existingBalance - withdrawal;
                        System.out.println("The amount after withdrawal is " + existingBalance);
                    }
                    break;

                case "e":
                    System.out.println("Thank you for using our banking services. Goodbye!");
                    loop = false; 
                    break;

                default:
                    System.out.println("Invalid choice. Please enter B, D, W, or E.");
                    break;
            }
        }
      
    }
}
