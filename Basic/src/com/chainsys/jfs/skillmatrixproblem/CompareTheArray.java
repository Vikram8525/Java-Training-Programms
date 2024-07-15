package com.chainsys.jfs.skillmatrixproblem;

import java.util.Scanner;

public class CompareTheArray {

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        System.out.println("Enter the 1st triplet (three integers):");
	        int[] arrA = new int[3];
	        for (int i = 0; i < 3; i++) {
	            arrA[i] = sc.nextInt();
	        }
	        
	        System.out.println("Enter the 2nd triplet (three integers):");
	        int[] arrB = new int[3];
	        for (int i = 0; i < 3; i++) {
	            arrB[i] = sc.nextInt();
	        }
	        
	        int alice = 0, bob = 0;
	        for (int i = 0; i < 3; i++) {
	            if (arrA[i] > arrB[i]) {
	                alice++;
	            } else if (arrA[i] < arrB[i]) {
	                bob++;
	            }
	        }
	        
	        System.out.println("the score is " + alice + " - " + bob);
	        
	    }
}
