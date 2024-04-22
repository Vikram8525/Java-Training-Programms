package com.chainsys.jfs.pojo;
import java.time.LocalDate;

public class StockManagementPojo {
 String itemName;
 int itemId;
 int itemQuantity;
 String Date;
public StockManagementPojo(String itemName, int itemId, int itemQuantity, String date) {
	super();
	this.itemName = itemName;
	this.itemId = itemId;
	this.itemQuantity = itemQuantity;
	Date = date;
}
public StockManagementPojo() {
	
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
public String getDate() {
	return Date;
}
public void setDate(String date) {
	Date = date;
}
@Override
public String toString() {
	return "StockManagementPojo [itemName=" + itemName + ", itemId=" + itemId + ", itemQuantity=" + itemQuantity
			+ ", Date=" + Date + "]";
}


}
