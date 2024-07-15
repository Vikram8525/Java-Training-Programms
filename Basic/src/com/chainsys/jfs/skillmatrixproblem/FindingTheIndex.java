package com.chainsys.jfs.skillmatrixproblem;

import java.util.Scanner;

public class FindingTheIndex {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter array length:");
        int length = sc.nextInt();
        
        int[] arr = new int[length];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }
        
        int[] originalArr = arr.clone();
        
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        
        System.out.println("Sorted array:");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        System.out.println("Indices of original array elements in sorted order:");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (arr[i] == originalArr[j]) {
                    System.out.print(j + " ");
                    originalArr[j] = Integer.MAX_VALUE; 
                    break;
                }
            }
        }
        
    }
}
