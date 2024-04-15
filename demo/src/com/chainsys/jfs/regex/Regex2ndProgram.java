package com.chainsys.jfs.regex;

import java.util.Scanner;

public class Regex2ndProgram {

	public static void main(String[] args) {
		 Scanner input=new Scanner(System.in);
	        String emailPattern="^[a-z0-9]+@[a-z]+\\.[a-z]{2,}$";
	        System.out.println("Enter your UserName:");
	        String name=input.next();
	        System.out.println("Enter your emailID :");
	        String email=input.next();
	        
	        while(!email.matches(emailPattern)) {
	            System.out.println("Give the correct emailID");
	            System.out.print("Enter your email(eg: puli@gmail.com):all character should be small");
	            email=input.next();
	        }
	        System.out.println("You have entered a valid Email id");
	        System.out.println("Your e mail id is "+ email);
	        System.out.println("Enter Your Password");
	        String passWordpattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

	        String password=input.next();
	        while(!password.matches(passWordpattern)){
	            System.out.println("Give the correct password");
	            System.out.print("Enter your Password(eg:P@ssWord123");
	            password=input.next();
	        }
	        System.out.println("You have entered a valid password");
	        System.out.println("Your password is "+ password);
	        System.out.println("your name is "+name);
	        System.out.println("your e mail id is " +email);
	        System.out.println("your password is " +password);
	        System.out.println("Dont forget your password  ");
	        
	        
	}

}
