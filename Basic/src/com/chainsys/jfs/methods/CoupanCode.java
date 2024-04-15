package com.chainsys.jfs.methods;

import java.util.Scanner;

public class CoupanCode {

	public static double coupanCodeCalculator(String couponCode,double discountedBill) {
		double discount=0;
		if (couponCode.equals("COUP_2")) {
			discount += 0.02 * discountedBill; 
		} else if (couponCode.equals("COUP_5")) {
			discount += 0.05 * discountedBill; 
		}
		return discount;
	}
}