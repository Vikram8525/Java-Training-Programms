package com.chainsys.jfs.CodingChallenge;

import java.util.Scanner;

public class CodingChallenge8 {

	 public static void main(String[] args) {
	        
	        Scanner sc=new Scanner(System.in);
	        String A=sc.next();
	        /* Enter your code here. Print output to STDOUT. */
	         StringBuilder strBuilder = new StringBuilder(A);
	         
	        String s =  strBuilder.reverse().toString();
	         if(A.equals(s))
	         {
	             System.out.println("Yes");
	         }
	         else
	         {
	             System.out.println("No");
	         }
	    }
}
