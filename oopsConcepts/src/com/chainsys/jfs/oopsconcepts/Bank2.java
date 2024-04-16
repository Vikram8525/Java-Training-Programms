package com.chainsys.jfs.oopsconcepts;

public class Bank2 {
	
	public static void depsoit(int amount, int accountNumber) {
        if(amount>0 && accountNumber>0) {
        int balance =0;
        balance =balance + amount;
        System.out.println(" your current balance : "+balance+" after depsoit of"+amount);
        }else {
            System.out.println("Please Enter valid amount or account number");
        }
        
    }
    public static void depsoit(int amount, int accountNumber,String accountName) {
        if(amount>0 && accountNumber>0 && !accountName.isEmpty()) {
        int balance = 0;
        balance =balance + amount;
        System.out.println(" your current balance : "+balance+" after depsoit of"+amount);
        }else {
            System.out.println("Please enter valid data");
        }
    }
    
    public static void depsoit(int amount,int ifscCode, int accountNumber ) {
        
        if(amount>0 && accountNumber>0 && ifscCode==1234) {
        int balance = 0;
        balance =balance +amount;
        System.out.println(" your current balance : "+balance+" after depsoit of"+amount);
        }else {
            System.out.println("Please enter valid data");
        }
    }

}


