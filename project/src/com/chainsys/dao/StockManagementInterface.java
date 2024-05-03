package com.chainsys.dao;

import java.util.List;

import com.chainsys.test.StockManagementInformation;

public interface StockManagementInterface {
    void displayItemDetails(List<StockManagementInformation> items);
    void checkStockAgeInDays(List<StockManagementInformation> items);
    void checkStockAvailability(List<StockManagementInformation> items);
}
