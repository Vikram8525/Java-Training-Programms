package com.chainsys.jfs.copy2;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public interface StockManagementInterface {
    void displayItemDetails(List<StockManagementInformation> items);
    void checkStockAgeInDays(List<StockManagementInformation> items);
    void checkStockAvailability(List<StockManagementInformation> items);
}
