package com.chainsys.jfs.skillmatrixproblem;

import java.util.Scanner;

public class ProductOfArray {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter array length:");
        int length = sc.nextInt();
        
        int[] arr = new int[length];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }
        int totalProduct = 1;
        for (int num : arr) {
            totalProduct *= num;
        }
        
        System.out.println("Product of the array:");
        for (int i = 0; i < length; i++) {
            int productExceptSelf = totalProduct / arr[i];
            System.out.print(productExceptSelf + " ");
        }
        
    }
}
