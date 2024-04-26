package com.chainsys.jfs.newstock;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	public class ValidationClass {

	    public boolean validateString(String input) {
	        return input.matches("[a-zA-Z]+");
	    }

	    public boolean isSpecialChar(String input) {
	        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
	        Matcher matcher = pattern.matcher(input);
	        return matcher.find();
	    }
	}

