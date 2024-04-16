package com.chainsys.jfs.oopsconcepts;

import java.util.Scanner;
import java.util.regex.Pattern;

	public class ValidationClass {
	    public  boolean inputchecker(int n) 
	    {
	        if(n<0) {
	            System.out.println("Error! Negative number detected. Cannot proceed.");
	            return false;
	        }
	        return true;
	    }
	    public  boolean numberchecker(String s) 
	    {
	        try
	        {
	            Integer.parseInt(s);
	            System.out.println("Dont use numbers");
	            return false;
	            
	        }
	        catch(Exception e){
	            
	            return true;
	            
	        }
	    }
	     public boolean isSpecialChar(String input)
	     {
	          
	            String specialCharRegex = "^[^a-zA-Z0-9]+[!@#$%^&*()]+$";
	            if(Pattern.matches(specialCharRegex, input))
	            {
	                System.out.println("Invalid!.Dont use Special Characters");
	                return false;
	            }
	            return true;
	        }
	     

	}