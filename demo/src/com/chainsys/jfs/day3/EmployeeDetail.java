package com.chainsys.jfs.day3;

import java.util.Scanner;

public class EmployeeDetail {

	public static void main(String[] args) {
		
		String name;
		int age;
		char sex;
		char marital;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Name ");
		name = sc.nextLine();
		do {
			System.out.println("Please enter a positive number for age!");
			while (!sc.hasNextInt()) {
				System.out.println("That's not a valid age!");
				sc.next(); // this is important!
			}
			age = sc.nextInt();
		} while (age <= 0);
		System.out.println("your age is " + age);

		System.out.println("enter your gender (only m or f) ");
		sex = sc.next().charAt(0);

		switch (sex) {

		case 'm':
			System.out.println(" you are Male");
			break;

		case 'f':
			System.out.println("you are Female");
			break;

		default:
			System.out.println("enter either m or f only");
			sex = sc.next().charAt(0);
			switch (sex) {

			case 'm':
				System.out.println(" you are Male");
				break;

			case 'f':
				System.out.println("you are Female");
				break;

			default:
				System.out.println("enter either m or f only");
			}
		}
		System.out.println("enter your marital (y or n)");
		marital = sc.next().charAt(0);
		switch (marital) {

		case 'y':
			System.out.println("you are married");
			break;

		case 'n':
			System.out.println("you are unmarried");
			break;

		default:
			System.out.println("enter either y or n only");
			marital = sc.next().charAt(0);
			switch (marital) {

			case 'y':
				System.out.println("you are married");
				break;

			case 'n':
				System.out.println("you are unmarried");
				break;

			default:
				System.out.println("enter either y or n only");
			}

		}
		if (sex == 'm' && age >= 20 && age <= 40) {
			System.out.println("you can work anywhere");

		} else if (sex == 'm' && age >= 40 && age <= 60) {
			System.out.println("you can work in urban region only");

		} else if (sex == 'f') {
			System.out.println(" womwn can only work in urban region");
		} else {
			System.out.println(" Error");
		}
	}

}
