package com.chainsys.jfs.skillmatrixproblem;

import java.util.Scanner;

public class CountOfLastWord {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the string:");
        String word = sc.nextLine().trim(); 
        int len = 0;
        for (int i = word.length() - 1; i >= 0; i--) {
            if (word.charAt(i) == ' ') {
                len = word.length() - i - 1;
                break;
            }
            len++;
        }
        
        System.out.println("Length of the last word: " + len);
    }
}
