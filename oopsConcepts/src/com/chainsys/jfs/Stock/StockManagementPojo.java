package com.chainsys.jfs.Stock;

import java.time.LocalDate;

public class StockManagementPojo {
    private String itemName;
    private int itemId;
    private int itemQuantity;
    private LocalDate date;

    public StockManagementPojo(String itemName, int itemId, int itemQuantity, LocalDate date) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.itemQuantity = itemQuantity;
        this.date = date;
    }

    // Getter and setter methods

    public StockManagementPojo() {
		// TODO Auto-generated constructor stub
	}

	public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	@Override
    public String toString() {
        return "StockManagementPojo [itemName=" + itemName + ", itemId=" + itemId + ", itemQuantity=" + itemQuantity
                + ", Date=" + date + "]";
    }
}
