package com.chainsys.jfs.day3;

import java.util.Scanner;

public class FascinatingNumber {

	public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        System.out.print("Enter any Number: ");
		        int num = scanner.nextInt();

		        int n2 = num * 2;
		        int n3 = num * 3;

		        // Concatenate num, n2, and n3
		        String concatStr = num + "" + n2 + n3;

		        boolean found = true;

		        // Check if all digits from 1 to 9 are present exactly once
		        for (char c = '1'; c <= '9'; c++) {
		            int count = 0;
		            for (int i = 0; i < concatStr.length(); i++) {
		                char ch = concatStr.charAt(i);
		                if (ch == c) {
		                    count++;
		                }
		            }
		            if (count > 1 || count == 0) {
		                found = false;
		                break;
		            }
		        }

		        if (found) {
		            System.out.println("The given number " + num + " is a fascinating number.");
		        } else {
		            System.out.println("The given number " + num + " is not a fascinating number.");
		        }

	}

}
