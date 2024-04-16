package com.chainsys.jfs.oopsconcepts;

public class Bank2Information {

	int accountNumber;
	String accountHolderName;
	int ifscCode;
	public Bank2Information() {
		
	}
	
	public Bank2Information(int accountNumber, String accountHolderName, int ifscCode) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.ifscCode = ifscCode;
	}
	@Override
	public String toString() {
		return "Bank2Information [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName
				+ ", ifscCode=" + ifscCode + "]";
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public int getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(int ifscCode) {
		this.ifscCode = ifscCode;
	}

}
