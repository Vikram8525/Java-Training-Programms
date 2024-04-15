package com.chainsys.jfs.day2;

public class CriticalJavaProgram {

	public static void main(String[] args) {
		        int a = 5;
		        int b = 3;
		        int result;

		        // Arithmetic operations
		        result = a + b; 
		        System.out.println("Addition: " + result);

		        result = a - b; 
		        System.out.println("Subtraction: " + result);

		        result = a * b; 
		        System.out.println("Multiplication: " + result);

		        result = a / b; 
		        System.out.println("Integer Division: " + result);

		        double resultDouble = (double) a / b; 
		        System.out.println("Floating-point Division: " + resultDouble);

		        result = a % b; 
		        System.out.println("Modulus: " + result);

		        // Increment and decrement operations
		        a++; 
		        System.out.println("Increment: " + a);

		        b--; 
		        System.out.println("Decrement: " + b);

		        // Relational operations
		        boolean isEqual = (a == b); 
		        System.out.println("Equality: " + isEqual);

		        boolean isNotEqual = (a != b); 
		        System.out.println("Inequality: " + isNotEqual);

		        boolean isGreater = (a > b); 
		        System.out.println("Greater than: " + isGreater);

		        boolean isLess = (a < b); 
		        System.out.println("Less than: " + isLess);

		        boolean isGreaterOrEqual = (a >= b); 
		        System.out.println("Greater than or equal to: " + isGreaterOrEqual);

		        boolean isLessOrEqual = (a <= b);
		        System.out.println("Less than or equal to: " + isLessOrEqual);

		        // Logical operations
		        boolean logicalAnd = (isGreater && isLess); 
		        System.out.println("Logical AND: " + logicalAnd);

		        boolean logicalOr = (isGreater || isLess); 
		        System.out.println("Logical OR: " + logicalOr);

		        boolean logicalNotA = !isGreater; 
		        System.out.println("Logical NOT (a): " + logicalNotA);

		        boolean logicalNotB = !isLess; 
		        System.out.println("Logical NOT (b): " + logicalNotB);

		        // Bitwise operations
		        int bitwiseAnd = a & b; 
		        System.out.println("Bitwise AND: " + bitwiseAnd);

		        int bitwiseOr = a | b; 
		        System.out.println("Bitwise OR: " + bitwiseOr);

		        int bitwiseXor = a ^ b; 
		        System.out.println("Bitwise XOR: " + bitwiseXor);

		        int bitwiseComplement = ~a; 
		        System.out.println("Bitwise Complement (a): " + bitwiseComplement);

		        // Shift operations
		        int leftShift = a << 1; 
		        System.out.println("Left Shift: " + leftShift);

		        int rightShift = a >> 1; 
		        System.out.println("Right Shift: " + rightShift);

		        int zeroFillRightShift = a >>> 1; 
		        System.out.println("Zero-fill Right Shift: " + zeroFillRightShift);
		    }

	}

