package com.chainsys.jfs.skillmatrixproblem;

import java.util.Scanner;

public class NonRepeatingNumberCount {

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        System.out.println("Enter the range start:");
	        int start = sc.nextInt();
	        
	        System.out.println("Enter the range end:");
	        int end = sc.nextInt();
	        
	        int count = 0;
	        for (int i = start; i <= end; i++) {
	            if (!repeatFinder(i)) {
	                count++;
	            }
	        }
	        
	        System.out.println("Count of non-repeating numbers: " + count);
	        
	    }
	    
	    private static boolean repeatFinder(int num) {
	        String numStr = String.valueOf(num);
	        
	        for (int i = 0; i < numStr.length(); i++) {
	            char currentChar = numStr.charAt(i);
	            for (int j = i + 1; j < numStr.length(); j++) {
	                if (currentChar == numStr.charAt(j)) {
	                    return true;
	                }
	            }
	        }
	        
	        return false;
	    }
}
