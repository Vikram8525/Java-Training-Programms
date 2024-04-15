package com.chainsys.jfs.day3;
 import java.util.Scanner;
 
public class OddAndEvenNumber {

	public static void main(String[] args) {
		int number, i;
		Scanner sc = new Scanner(System.in);
		
		System.out.print(" Please Enter any Number : ");
		number = sc.nextInt();	
		System.out.println("even numbers " + "\n");
		for(i = 1; i <= number; i++)
		{
			if(i % 2 == 0)
			{
				System.out.print( i +"\t"); 
			}
		}
		System.out.println("\n" + "odd numbers " + "\n");
		
		for(i = 1; i <= number; i++) {
			 if(i % 2 != 0) {
				System.out.print( i +"\t");
			}
		}	
		System.out.println("\n"+ "cube of n =" + number*number*number);

	}

}
