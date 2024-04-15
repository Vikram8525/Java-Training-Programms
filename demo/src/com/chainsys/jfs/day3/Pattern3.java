package com.chainsys.jfs.day3;

import java.util.Scanner;

public class Pattern3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j,n;
		Scanner sc = new Scanner(System.in);
	     System.out.println("Enter the no of lines");
	     n = sc.nextInt();
		for(i=n;i>=1;i--)
	     {
	         for(j=i;j<n;j++)
	            System.out.print(" ");
	         
	         for(j=1;j<=(2*i-1);j++)
	        	 if(j%2!=0)
	            System.out.print("1");
	        	 else
	        		 System.out.print("0");
	         
	       System.out.println("");
	     } 
	}

}
