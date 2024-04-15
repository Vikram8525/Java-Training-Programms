package com.chainsys.jfs.day3;

import java.util.Scanner;

public class AttendenceCalculation {

	public static void main(String[] args) {
		String name;
		double noofclass;
		double noofattended;
		double percentage;
		char cause;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Students Name ");
		name = sc.nextLine();
		System.out.println("enter Total number of class held ");
		noofclass = sc.nextDouble();
		while(noofclass<0)
		{
			System.out.println("please enter the correct no of class held (only +ve numbers)");
			noofclass = sc.nextDouble();
		}
		System.out.println("enter number of class the student attended ");
		noofattended = sc.nextDouble();
		while(noofattended<0)
		{
			System.out.println("please enter the correct no of class attended by the student (only +ve numbers)");
			noofattended = sc.nextDouble();
		}
		System.out.println(name +" you have attended " + noofattended +" out of " + noofclass);
		percentage = noofattended/noofclass*100;
		System.out.println("your attendence percentage for " + noofclass + " days is : " +percentage);
		if(percentage < 75 ) {
			System.out.println("You are not allowed to attend the exam ");
			System.out.println("Do you have any medical cause");
			System.out.println("for Yes give 'y' ");
			System.out.println("for No give 'n' ");
			cause = sc.next().charAt(0);
			switch (cause) {
			
			case 'y':
				System.out.println("you can attend the exam");
				break;
				
			case 'n':
				System.out.println("you can not attend the exam");
				break;
			
			default:
				System.out.println("enter either y or n only");
			}
				
			}
		else {
			System.out.println("You have enough % to attend the exam");
			
		}
		
	}

}
