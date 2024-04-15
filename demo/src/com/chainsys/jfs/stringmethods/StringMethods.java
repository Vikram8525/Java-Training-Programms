package com.chainsys.jfs.stringmethods;

public class StringMethods {

	public static void main(String[] args) {
		
		// some of the commonly used string methods are
		
		//charAt(int index): Returns the character at the specified index.

		//length(): Returns the length of the string.

		//substring(int beginIndex): Returns a substring from the specified beginIndex to the end of the string.

		//substring(int beginIndex, int endIndex): Returns a substring from the specified beginIndex to the endIndex.

		//indexOf(String str): Returns the index within the string of the first occurrence of the specified substring.

		//lastIndexOf(String str): Returns the index within the string of the last occurrence of the specified substring.

		//startsWith(String prefix): Checks if the string starts with the specified prefix.

		//endsWith(String suffix): Checks if the string ends with the specified suffix.

		//toUpperCase(): Converts the string to uppercase.

		//toLowerCase(): Converts the string to lowercase.

		//equals(Object obj): Compares this string to the specified object.

		//equalsIgnoreCase(String anotherString): Compares this string to another string, ignoring case considerations.

		//trim(): Returns a copy of the string with leading and trailing whitespace removed.

		//replace(char oldChar, char newChar): Returns a new string resulting from replacing all occurrences of oldChar in this string with newChar.

		//split(String regex): Splits the string using the specified regular expression.

		//concat(String str): Concatenates the specified string to the end of this string.

		//contains(CharSequence s): Returns true if and only if this string contains the specified sequence of char values.

		//isEmpty(): Returns true if the string is empty.

		//compareTo(String anotherString): Compares two strings lexicographically.

		//intern(): Returns a canonical representation for the string object.
		
		// Normal string declaration and initialization
		String normalString1 = "Hello, World!";
		System.out.println("Normal string: " + normalString1);

		// String using string literal
		String normalString2 = "Java is fun!";
		System.out.println("String literal: " + normalString2);

		// Length of the string
		int length = normalString1.length();
		System.out.println("Length of normal string: " + length);

		// isEmpty method
		String str1 = "Hello, World!";
		String str2 = "";
		String str3 = " ";
		boolean isEmpty1 = str1.isEmpty();
		boolean isEmpty2 = str2.isEmpty();
		boolean isEmpty3 = str3.isEmpty();
		System.out.println("Is '" + str1 + "' empty?: " + isEmpty1);
		System.out.println("Is '" + str2 + "' empty?: " + isEmpty2);
		System.out.println("Is '" + str3 + "' empty?: " + isEmpty3);

		// charAt method in a string
		char charAtIndex5 = normalString2.charAt(5);
		System.out.println("Character at index 5 in '" + normalString2 + "': " + charAtIndex5);

		// codePointAt and codePointBefore Method
		int codePointAtIndex5 = str1.codePointAt(5);
		int codePointBeforeIndex5 = str1.codePointBefore(5);
		System.out.println("Unicode code point at index 5 in '" + str1 + "': " + codePointAtIndex5);
		System.out.println("Unicode code point before index 5 in '" + str1 + "': " + codePointBeforeIndex5);

		// using Equals method
		String str4 = "Hello";
		String str5 = "Hello";
		String str6 = "World";
		boolean isEqual1to2 = str4.equals(str5);
		boolean isEqual1to3 = str4.equals(str6);
		System.out.println("Is str4 equal to str5?: " + isEqual1to2);
		System.out.println("Is str4 equal to str6?: " + isEqual1to3);

		// Using equalsIgnoreCase method
		String str7 = "HELLO";
		boolean isEqualIgnoreCase1to2 = str4.equalsIgnoreCase(str7);
		System.out.println("Is str1 equal to str2 ignoring case?: " + isEqualIgnoreCase1to2);

		// Using compareToIgnoreCase
		int comparison4to6 = str4.compareToIgnoreCase(str6);
		if (comparison4to6 == 0) {
			System.out.println("str1 is equal to str2 ignoring case");
		} else if (comparison4to6 < 0) {
			System.out.println("str1 comes before str2 ignoring case");
		} else {
			System.out.println("str1 comes after str2 ignoring case");
		}

		// using startsWith method
		boolean startsWithHello = str1.startsWith("Hello");
		boolean startsWithHELLO = str1.startsWith("HELLO");
		System.out.println("Does the string start with 'Hello'?: " + startsWithHello);
		System.out.println("Does the string start with 'HELLO' (ignoring case)?: " + startsWithHELLO);

		// Using EndsWith method
		boolean endsWithWorld = str1.endsWith("World!");
		boolean endsWithworld = str1.endsWith("world!");
		System.out.println("Does the string end with 'World!'?: " + endsWithWorld);
		System.out.println("Does the string end with 'world!' (ignoring case)?: " + endsWithworld);

		// Concatenation of strings
		String concatenatedString = normalString1 + " " + normalString2;
		System.out.println("Concatenated string: " + concatenatedString);

		// Substring operation
		String substring = normalString1.substring(0, 5);
		System.out.println("Substring: " + substring);

		// Converting string to uppercase
		String upperCaseString = normalString1.toUpperCase();
		System.out.println("Uppercase string: " + upperCaseString);

		// Converting string to lowercase
		String lowerCaseString = normalString2.toLowerCase();
		System.out.println("Lowercase string: " + lowerCaseString);

		// Removing leading and trailing whitespaces (only remove the space in first and
		// last)
		String stringWithWhitespaces = "   Hell,   World   ";
		String trimmedString = stringWithWhitespaces.trim();
		System.out.println("Trimmed string: " + trimmedString);

		// Checking if a string contains a substring
		boolean containsSubstring = concatenatedString.contains("Java");
		System.out.println("Does concatenated string contain 'Java'?: " + containsSubstring);

		// Replacing characters in a string
		String replacedString = normalString1.replace('o', '0');
		System.out.println("Replaced string: " + replacedString);
		//reverse
		//append
		//
	}

}
