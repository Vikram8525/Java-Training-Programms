package com.chainsys.jfs.day2;

import java.util.Scanner;

public class AllOperations {

	public static void main(String[] args) throws Exception {

		    int operator;
		    Double a, b, result;
		    String c;

		   
		    Scanner input = new Scanner(System.in);



		   
		    System.out.println("Enter first number");
		    a = input.nextDouble();

		    System.out.println("Enter second number");
		    b = input.nextDouble();
		    
	
		    System.out.println("Wait dont click any number now :)");
		    Thread.sleep(2000);
		    System.out.println("for additition click 1");
		   
			   Thread.sleep(2000);
		   
		    System.out.println("for subtraction click 2");
		    Thread.sleep(2000);
		    System.out.println("for multiplication click 3");
		    Thread.sleep(2000);
		    System.out.println("for Division click 4");
		    Thread.sleep(2000);
		    System.out.println("You can Choose an Number now ");
		  
		    operator = input.nextInt();
		    switch (operator) {

		      case 1:
		    	  result = a + b;
			        System.out.println("Addition: " + result);
		        break;

		      
		      case 2:
		    	  result = a - b;
			        System.out.println("Subtraction: " + result);
		        break;

		      
		      case 3:
		    	  result = a * b; 
			        System.out.println("Multiplication: " + result);
		        break;

		      
		      case 4:
		    	  result = a / b; 
			        System.out.println("Integer Division: " + result);
		        break;

		      default:
		        System.out.println("Invalid operator!");
		        break;
		    }

		    input.close();
		  }
	

	}

