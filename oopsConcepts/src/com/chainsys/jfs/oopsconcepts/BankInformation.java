package com.chainsys.jfs.oopsconcepts;

public class BankInformation {
	String userName;
	String accountNo;
	String bankLocation;
	String accountType;

	double amount;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getBankLocation() {
		return bankLocation;
	}

	public void setBankLocation(String bankLocation) {
		this.bankLocation = bankLocation;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public BankInformation(String userName, String accountNo, String bankLocation, String accountType,
			int aadharNumber) {
		super();
		this.userName = userName;
		this.accountNo = accountNo;
		this.bankLocation = bankLocation;
		this.accountType = accountType;

	}

	public BankInformation() {

	}

	@Override
	public String toString() {
		return "BankInformation [userName=" + userName + ", accountNo=" + accountNo + ", bankLocation=" + bankLocation
				+ ", accountType=" + accountType + "]";
	}

}
