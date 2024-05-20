package com.chainsys.model;

import java.sql.Date;

public class CustomerPojo {
	String customerName;
	int id;
	String mobileNumber;
	String mailId;
	String password;
	String address;
	Date lastVisitedDate;
	public CustomerPojo() {
		
	}

	public CustomerPojo(String customerName, int id, String mobileNumber, String mailId, String password,
			String address, Date lastVisitedDate) {
		
		this.customerName = customerName;
		this.id = id;
		this.mobileNumber = mobileNumber;
		this.mailId = mailId;
		this.password = password;
		this.address = address;
		this.lastVisitedDate = lastVisitedDate;
	}

	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getLastVisitedDate() {
		return lastVisitedDate;
	}

	public void setLastVisitedDate(Date lastVisitedDate) {
		this.lastVisitedDate = lastVisitedDate;
	}

	@Override
	public String toString() {
		return "CustomerPojo [customerName=" + customerName + ", id=" + id + ", mobileNumber=" + mobileNumber
				+ ", mailId=" + mailId + ", password=" + password + ", address=" + address + ", lastVisitedDate="
				+ lastVisitedDate + "]";
	}

	
	
	

}
