package com.chainsys.jfs.skillmatrixproblem;

import java.util.Scanner;

public class SkillMatrix2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a number N: ");
		int N = scanner.nextInt();
		int n = N;

		System.out.print("Enter a digit D (0-9): ");
		int D = scanner.nextInt();

		char NumChar = (char) (D + '0');

		int count = 0;
		while (N > 0) {
			int lastNum = N % 10;
			char lastNumChar = (char) (lastNum + '0');
			if (lastNumChar == NumChar) {
				count++;
			}
			N = N / 10;
		}

		System.out.println("The digit " + D + " occurs " + count + " times in " + n);


	}

}
