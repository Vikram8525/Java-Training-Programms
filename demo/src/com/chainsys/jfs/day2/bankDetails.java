package com.chainsys.jfs.day2;

import java.util.Scanner;

public class bankDetails {

	public static void main(String[] args) {
		long accountnum ;
		String bankname;
		String bankbranch;
		String ifsccode;
		boolean isgoodbank;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the name of the bank");
		bankname = sc.nextLine();
		System.out.println("enter the account num");
		accountnum = sc.nextLong();
		System.out.println("enter the bank branch name");
		bankbranch = sc.next();
		System.out.println("enter the ifsc code");
		ifsccode = sc.next();
		System.out.println("bank rating");
		isgoodbank = sc.hasNext();
		System.out.println( "\n" + bankname  +"\n"+ accountnum  +"\n"+ bankbranch +"\n"+ ifsccode +"\n"+  isgoodbank);


	}

}
