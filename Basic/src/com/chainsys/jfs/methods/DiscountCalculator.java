package com.chainsys.jfs.methods;

import java.util.Scanner;

public class DiscountCalculator {
	public static double applyDiscountAndCoupon(double fare) {
        double discount = 0;

        if (fare > 5000) {
            discount = 0.05 * fare;
        } else if (fare > 2000) {
            discount = 0.02 * fare; 
        }

        double discountedBill = fare - discount;
        return discountedBill;

	}

}
