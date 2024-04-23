package com.chainsys.jfs.pojo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StockManagementMain {

	public static void main(String[] args) {
		StockManagementInformation si = new StockManagementInformation();
		si.StockManagement();

		LocalDate startDate = si.validateDateString("Enter the start date (YYYY-MM-DD): ");
		LocalDate endDate = si.validateDateString("Enter the end date (YYYY-MM-DD): ");

		Period period = si.calculatePeriodBetween(startDate, endDate);
        System.out.println("this item is " + period.getYears() + " years, " +
                           period.getMonths() + " months, and " +
                           period.getDays() + " days old");
        if (period.getYears()<1 && period.getYears() <2) {
        	System.out.println("Your item is Manufactured before 1 years :");
        	System.out.println("This item may be expiring soon");
        }
	}
}
