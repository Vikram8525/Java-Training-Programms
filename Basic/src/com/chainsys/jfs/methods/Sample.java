package com.chainsys.jfs.methods;

public class Sample {

	    public static void main(String[] args) {
	        int[] arr = {1, 2, 3, 4, 5};
	        int[] result = getProductArray(arr);

	        for (int num : result) { 
	            System.out.print(num + " ");
	        }
	    }

	    public static int[] getProductArray(int[] arr) {
	        int n = arr.length;
	        int[] result = new int[n];
	        int[] left = new int[n];
	        int[] right = new int[n];

	        left[0] = 1;
	        right[n - 1] = 1;

	        for (int i = 1; i < n; i++) {
	            left[i] = arr[i - 1] * left[i - 1];
	        }

	        for (int j = n - 2; j >= 0; j--) {
	            right[j] = arr[j + 1] * right[j + 1];
	        }

	        for (int i = 0; i < n; i++) {
	            result[i] = left[i] * right[i];
	        }

	        return result;
	    }
	}



