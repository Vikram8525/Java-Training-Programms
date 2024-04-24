package com.chainsys.jfs.pojo;

import java.time.LocalDate;
import java.time.Period;

public class StockManagementMain {

    public static void main(String[] args) {
        StockManagementInformation si = new StockManagementInformation();
        si.StockManagement();

        LocalDate startDate = si.validateDateString("Enter the last date that the stock has been added : (YYYY-MM-DD): ");
        LocalDate endDate = LocalDate.now(); 
        Period period = si.calculatePeriodBetween(startDate, endDate);
        System.out.println("This item is " + period.getYears() + " years, " +
                           period.getMonths() + " months, and " +
                           period.getDays() + " days old");

        if (period.getYears() > 1 && period.getYears() == 2) {
            System.out.println("This item was manufactured more than 1 year ago. clear this stock by giving offers");
                System.out.println("This item may be expiring soon. Restock this stem with new item");
            
        } else if (period.getMonths() >= 5 && period.getMonths() < 11) {
            System.out.println("This item is quite old you need to re stock this item.");
        } else if (period.getMonths() < 5 && period.getMonths() >= 2) {
            System.out.println("This item is relatively new.'NEW ARRIVAL'");
        }else if (period.getDays() < 25) {
            System.out.println("This item is new.'FRESH ITEM' ");
        }else {
            System.out.println("This item is very old.'CLEAR THIS ITEM' ");
        }
        si.Display();
    }
}
