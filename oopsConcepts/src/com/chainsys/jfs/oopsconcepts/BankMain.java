package com.chainsys.jfs.oopsconcepts;

import java.util.Scanner;

public class BankMain {
	 double amount;
	 public void getUserDetails(BankInformation input) {
	     ValidationClass vc =new ValidationClass();
	     
	     Scanner sc=new Scanner(System.in);
	     System.out.println("Enter a UserName :");
	     input.setUserName(sc.next());
	     if(!vc.numberchecker(input.userName)) {
	         return;
	     }
	     
	     System.out.println("Enter a Account Number:");
	     input.setAccountNo( sc.next());

	     System.out.println("Enter your Bank Location:");
	     input.setBankLocation(sc.next());

	     System.out.println("Enter your Account Type:");
	     input.setAccountType(sc.next());
	     
	     System.out.println("Enter your Amount:");
	     input.setAmount(sc.nextInt());
	   
	     
	 }
	 public  void printUserDetails(BankInformation input) {
	     System.out.println(input);

	     System.out.println("UserName:"+input.getUserName());
	     System.out.println("AccountNumber:"+input.getAccountNo());
	     System.out.println("Bank Location:"+input.getBankLocation());
	     System.out.println("Account Type:"+input.getAccountType());

	     System.out.println("Amount:"+input.getAmount());
	 }
	 public void deposit(double amount) {
	      int totalAmount=20000;
	     double total=amount+totalAmount;
	     System.out.println("Total amount in your account is:"+total);
	 }
	 public void deposit(double amount, String userName) {
	      int totalAmount=20000;
	     double total=amount+totalAmount;
	     System.out.println("Total amount in your account is:"+total +" depositer Name :" +userName);
	 }
	     public static void main(String[] args) {
	 BankMain bm=new BankMain();
	 BankInformation input=new BankInformation();

	 bm.getUserDetails(input);
	 bm.printUserDetails(input);
	 bm.deposit(input.getAmount());
	 bm.deposit(input.getAmount(),input.getUserName());
	     }

}
