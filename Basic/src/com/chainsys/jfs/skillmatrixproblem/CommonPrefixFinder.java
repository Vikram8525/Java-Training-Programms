package com.chainsys.jfs.skillmatrixproblem;

import java.util.Scanner;

public class CommonPrefixFinder {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of strings:");
        int numStrings = sc.nextInt();

        System.out.println("Enter the strings:");
        String[] strArr = new String[numStrings];
        for (int i = 0; i < numStrings; i++) {
            strArr[i] = sc.next();
        }

        String commonPrefix = "";
        if (strArr.length > 0) {
            int minLength = Integer.MAX_VALUE;
            for (String str : strArr) {
                minLength = Math.min(minLength, str.length());
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < minLength; i++) {
                char currentChar = strArr[0].charAt(i); 
                boolean allMatch = true;
                for (String str : strArr) {
                    if (str.charAt(i) != currentChar) {
                        allMatch = false;
                        break;
                    }
                }

                if (allMatch) {
                    sb.append(currentChar); 
                } else {
                    break; 
                }
            }

            commonPrefix = sb.toString();
        }

        System.out.println("Common prefix: " + commonPrefix);

    }
}
