package com.chainsys.jfs.day3;

import java.util.Scanner;

public class Pattern1 {

	public static void main(String[] args) {
		        int n ;
		        Scanner sc = new Scanner(System.in);
		        do {
				    System.out.println("Please enter a positive number!");
				    while (!sc.hasNextInt()) {
				        System.out.println("That's not a number!");
				        sc.next(); // this is important!
				    }
				    n = sc.nextInt();
				} while (n <= 0);
				System.out.println("You have Entered " + n);
		        for (int i = 1; i <= n; i++) {
		            for (int j = 1; j <= i; j++) {
		                System.out.print("*");
		            }
		            System.out.println();
		        }

	}

}
