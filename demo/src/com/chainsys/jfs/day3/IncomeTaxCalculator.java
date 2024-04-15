package com.chainsys.jfs.day3;

import java.util.*;
public class IncomeTaxCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your gross salary: ");
        double grossSalary = scanner.nextDouble();

        System.out.print("Enter your total savings: ");
        double totalSavings = scanner.nextDouble();

        double taxableIncome = calculateTaxableIncome(grossSalary, totalSavings);
        double taxAmount = taxCalculator(taxableIncome);

        System.out.println("Taxable Income: Rs. " + taxableIncome);
        System.out.println("Tax Amount: Rs. " + taxAmount);
    }

    public static double calculateTaxableIncome(double grossSalary, double totalSavings) {
        // Deduct savings (maximum Rs. 100,000) from gross income
        double taxableIncome = grossSalary - Math.min(totalSavings, 100000);
        return Math.max(taxableIncome, 0); // Ensure non-negative taxable income
    }

    public static double taxCalculator(double taxableIncome) {
        if (taxableIncome <= 100000) {
            return 0; // Slab 0: No tax
        } else if (taxableIncome <= 200000) {
            // Slab 1: 10% of the difference above 100,000
            return 0.10 * (taxableIncome - 100000);
        } else if (taxableIncome <= 500000) {
            // Slab 2: Tax from Slab 0 + Tax from Slab 1 + 20% of income exceeding 200,000
            return 0.10 * 100000 + 0.20 * (taxableIncome - 200000);
        } else {
            // Tax from Slab 0 + Tax from Slab 1 + Tax from Slab 2 + 30% of income exceeding 500,000
            return 0.10 * 100000 + 0.20 * 300000 + 0.30 * (taxableIncome - 500000);
        }
	}

}
