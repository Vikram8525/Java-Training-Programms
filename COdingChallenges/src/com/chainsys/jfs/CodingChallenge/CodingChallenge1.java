package com.chainsys.jfs.CodingChallenge;
import java.util.*;
import java.util.Scanner;
public class CodingChallenge1 {

	public static void main(String[] args) {
		System.out.println("to cheeck the given number is prime or not");
		System.out.println("enter a number :");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		for(int i=2; i<a ;i++)
		{
			if(a % i != 0){
			System.out.println("the given number is prime");
			break;
			}
			else;
			{
				System.out.println("the number is not a prime number");
				break;
			}
		}
		
		

	}

}
