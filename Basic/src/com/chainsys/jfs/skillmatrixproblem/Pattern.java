package com.chainsys.jfs.skillmatrixproblem;

public class Pattern {

	 public static void main(String[] args) {
	        String input = "saravana";
	        printPattern(input);
	    }

	    public static void printPattern(String input) {
	    	int str=0;
	    	
	        // Iterate through each character in the input string
	        for (int i = 0; i < input.length(); i++) {
	            
	            for (int j = i; j < input.length() - 1; j++) {
	                System.out.print(" ");
	            }
	            
	            
	            for (int k = 0; k < 2 * i - 1; k++) {
	                System.out.print(" ");
	            }
	            
	            if (i < input.length() - 1) {
	                System.out.print(input.charAt(str++));
	            }
	            
	            System.out.println();
	        }
	    }
}
