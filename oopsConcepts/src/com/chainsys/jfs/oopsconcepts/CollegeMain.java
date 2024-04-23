package com.chainsys.jfs.oopsconcepts;

import java.util.Scanner;

public class CollegeMain {


	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Welcome to College Information System\n");
	        System.out.println("1. Engineering College");
	        System.out.println("2. Medical College");
	        System.out.print("Enter your choice: ");
	        int choice = scanner.nextInt();

	        CollegeInformation college;

	        switch (choice) {
	            case 1:
	                college = new EngineeringCollege();
	                break;
	            case 2:
	                college = new MedicalCollege();
	                break;
	            default:
	                System.out.println("Invalid choice!");
	                return;
	        }

	        college.getInput();
	        college.displayDetails();
	    }
	}



