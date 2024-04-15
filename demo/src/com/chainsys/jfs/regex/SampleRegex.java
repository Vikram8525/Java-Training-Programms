package com.chainsys.jfs.regex;
import java.util.regex.*;
public class SampleRegex {

	public static void main(String[] args) {
		String a = "thiru vikrama rajan";
		Pattern p = Pattern.compile(a); // 1st important line (pattern.compile)
		Matcher m = p.matcher(a); //2nd important line (p.matcher)
		while(m.find()) {
			m.find();//to find the string that we have entered
			m.group();//to print the string
			m.start();// to find the index value of  the string that has been found
			m.end();//index i+1 to find the index value of  the ending of the string that has been found
			// ^ to check if the word is at the begining
			// $ to check if the word is at the ending
			//  A|B to check any one between two (a nad b)
			//[abc] check any one is there
			//[^ab]
			//[a-z]|[A-Z] or [a-zA-Z]
			//[0-9]
			//[a-zA-Z0-9]
			// \\s for space
			// \\S for all non space character
			// \\d for all numbers
			// \\D for all non numbers
			// \\w for all non special character
			// \\W for all special characters
			// \\b (word boundary) word starts with the given word eg \\bthiru
			// . for all string(num,symbol,alphabet)

		}
	}

}
