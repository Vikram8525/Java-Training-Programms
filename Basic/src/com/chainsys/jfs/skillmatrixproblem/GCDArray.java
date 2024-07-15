package com.chainsys.jfs.skillmatrixproblem;

import java.util.Scanner;

public class GCDArray {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the length of the array:");
        int len = sc.nextInt();
        
        int[] arr = new int[len];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        
        int gcd = arr[0];
        for (int i = 1; i < len; i++) {
            gcd = findGCD(gcd, arr[i]);
        }
        
        System.out.println("GCD: " + gcd);
        
        System.out.println("Array after division by GCD:");
        for (int i = 0; i < len; i++) {
            arr[i] /= gcd;
            System.out.print(arr[i] + " ");
        }
        
    }
    
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
