package com.chainsys.jfs.regex;
import java.util.Scanner;
import java.util.regex.*;
public class Regax1stProgram {

	public static void main(String[] args) {
		 String a;
		 Scanner sc = new Scanner(System.in);
		 System.out.println("enter the password");
		 a = sc.nextLine();
		 Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\\\S+$).{8,}$");
		 Matcher m = p.matcher(a);
		 
		 while(m.matches()) {
			 System.out.println(m.group());
		 }
				 
		

	}

}
