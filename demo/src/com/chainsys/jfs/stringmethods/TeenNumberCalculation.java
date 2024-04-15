package com.chainsys.jfs.stringmethods;

import java.util.Scanner;

public class TeenNumberCalculation {
	public static boolean hasTeen(int num1, int num2, int num3) {
		return (isTeen(num1) || isTeen(num2) || isTeen(num3));
	}

	public static boolean isTeen(int num) {
		return (num >= 13 && num <= 19);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number 1:");
		int n1 = sc.nextInt();

		System.out.println("Enter number 2:");
		int n2 = sc.nextInt();

		System.out.println("Enter number 3:");
		int n3 = sc.nextInt();

		System.out.println("the three number : " + n1 + " " + n2 + " " + n3 + " \n hasTeen : " + hasTeen(n1, n2, n3));
	}

}
