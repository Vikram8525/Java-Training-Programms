package com.chainsys.jfs.day3;
import java.util.*;
public class FindEvenDigitNumber {

	public static void main(String[] args) {
		
	        // TODO Auto-generated method stub
	         Scanner sc = new Scanner(System.in);
	         System.out.println("Enter a num :");
	         int n=sc.nextInt();
	         while(n<10) {
	             System.out.println("Invalid , please enter a number greater than 10");
	             n=sc.nextInt();
	         }
	         int num=n;
	         System.out.println("Even digits :");
	         int noOfDigits=0;
	         while(num>0) {
	             num=num/10;
	             noOfDigits++;
	         }
	         int place;
	         if(noOfDigits%2==0) {
	             
	             while(n>0) {
	                 place=10;
	                 int digit=n%place;
	             System.out.println(digit);
	                
	                 n/=100;
	             }
	         }
	        
	         else {
	             while(n>0) {
	                 n/=10;
	                 place=10;
	                 int digit=n%place;
	                if(n>0) {
	                 System.out.println(digit);
	                 n=n/10;
	                }
	                 
	                 
	                
	             }
	         }
	    

	}

}
