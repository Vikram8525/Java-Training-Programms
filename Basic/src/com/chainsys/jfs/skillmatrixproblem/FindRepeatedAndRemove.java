package com.chainsys.jfs.skillmatrixproblem;

import java.util.Arrays;
import java.util.Scanner;


public class FindRepeatedAndRemove {

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        System.out.println("Enter array length:");
	        int length = sc.nextInt();
	        
	        int[] arr = new int[length];
	        System.out.println("Enter the array elements:");
	        for (int i = 0; i < length; i++) {
	            arr[i] = sc.nextInt();
	        }
	        Arrays.sort(arr);
	        
	        int uniqueCount = 0;
	        for (int i = 0; i < arr.length; i++) {
	            if (i == 0 || arr[i] != arr[i - 1]) {
	                uniqueCount++;
	            }
	        }
	        
	        int[] finalArr = new int[uniqueCount];
	        int j = 0;
	        for (int i = 0; i < arr.length; i++) {
	            if (i == 0 || arr[i] != arr[i - 1]) {
	                finalArr[j++] = arr[i];
	            }
	        }
	        System.out.println("Final array length: " + finalArr.length);
	        System.out.println("Final array elements:");
	        for (int num : finalArr) {
	            System.out.print(num + " ");
	        }
	        
	    }
}
