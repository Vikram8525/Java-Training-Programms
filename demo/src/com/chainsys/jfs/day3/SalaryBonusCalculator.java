package com.chainsys.jfs.day3;

import java.util.Scanner;

public class SalaryBonusCalculator {

	public static void main(String[] args) {
		String name;
		double salary;
		int yearofxp;
		double bonus , amt;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Name ");
		name = sc.nextLine();
		System.out.println("enter your salary ");
		salary = sc.nextDouble();
		System.out.println("enter your total year of experiance ");
		yearofxp = sc.nextInt();
		
		if(yearofxp >= 5)
		{
			System.out.println("Congrats you have earned 5% bonus for your service");
			bonus = salary*5/100;
			System.out.println("your bonus amount is " + bonus);
			amt = salary + bonus;
			System.out.println("total after bonus is  " + amt);
			
		}
		else {
		 System.out.println("you dont have enough experiance for bonus");
		}
	

	}

}
