package com.chainsys.jfs.skillmatrixproblem;

import java.util.Scanner;

public class Sample1 {

	 public static void main(String[] args) {
	        int n = 5; 
	        for (int i = 1; i <= n; i++) {
	            int start = (i * (i - 1)) / 2 + 1; 
	            
	            for (int j = 0; j < i; j++) {
	                System.out.print(start + j + " ");
	            }
	            
	            System.out.println(); 
	        }
	    
	}

}
