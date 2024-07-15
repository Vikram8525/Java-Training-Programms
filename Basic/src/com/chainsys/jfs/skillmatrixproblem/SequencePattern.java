package com.chainsys.jfs.skillmatrixproblem;

import java.util.Scanner;

public class SequencePattern {

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	
	        System.out.println("Enter the main string:");
	        String number = sc.next();
	        System.out.println("Enter the substring to find:");
	        String findNum = sc.next();
	        
	        int index = number.indexOf(findNum);
	        if (index != -1 && index > 0) {
	            char precedingChar = number.charAt(index - 1);
	            System.out.println("Character preceding the substring: " + precedingChar);
	        } else {
	            System.out.println("Substring not found or is at the beginning.");
	        }
	    }
}
