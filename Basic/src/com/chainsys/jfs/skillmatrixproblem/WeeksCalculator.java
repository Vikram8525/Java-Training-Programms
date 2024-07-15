package com.chainsys.jfs.skillmatrixproblem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class WeeksCalculator {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the start date format(dd/mm/yyyy): ");
        String startDateStr = sc.next();
        
        System.out.println("Enter the end date format(dd/mm/yyyy): ");
        String endDateStr = sc.next();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);
        
        long noOfWeeks = ChronoUnit.WEEKS.between(startDate, endDate);
        
        System.out.println("Weeks between the dates: " + noOfWeeks);
        
    }
}
