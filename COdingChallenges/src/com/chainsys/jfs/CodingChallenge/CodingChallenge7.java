package com.chainsys.jfs.CodingChallenge;

import java.util.Scanner;

public class CodingChallenge7 {

	 public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        String s = scan.nextLine();
	        // Write your code here.
	        int count = 0;
	        String[] strArray = s.split("[\\s!@#$%^&*()_/.'?,!]");
	        
	        for(String str : strArray)
	        {
	            if(!str.equals(""))
	            {
	                count+=1;
	            }
	            
	        }
	        System.out.println(count);
	        
	        for(String str : strArray)
	        {
	            if(!str.equals(""))
	            {
	                System.out.println(str);
	            }
	        }
	                scan.close();
	    }
}
