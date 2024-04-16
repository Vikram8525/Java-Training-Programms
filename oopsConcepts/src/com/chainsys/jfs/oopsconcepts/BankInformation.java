package com.chainsys.jfs.oopsconcepts;

public class BankInformation {
 String accountType;
 String coApplicant;
 String accountNumber;
 String coAccountNumber;
 double amount;
 String fromAccount;
 String toAccount;
public String getAccountType() {
	return accountType;
}
public void setAccountType(String accountType) {
	this.accountType = accountType;
}
public String getCoApplicant() {
	return coApplicant;
}
public void setCoApplicant(String coApplicant) {
	this.coApplicant = coApplicant;
}
public String getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}
public String getCoAccountNumber() {
	return coAccountNumber;
}
public void setCoAccountNumber(String coAccountNumber) {
	this.coAccountNumber = coAccountNumber;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public String getFromAccount() {
	return fromAccount;
}
public void setFromAccount(String fromAccount) {
	this.fromAccount = fromAccount;
}
public String getToAccount() {
	return toAccount;
}
public void setToAccount(String toAccount) {
	this.toAccount = toAccount;
}
public BankInformation(String accountType, String coApplicant, String accountNumber, String coAccountNumber,
		double amount, String fromAccount, String toAccount) {
	super();
	this.accountType = accountType;
	this.coApplicant = coApplicant;
	this.accountNumber = accountNumber;
	this.coAccountNumber = coAccountNumber;
	this.amount = amount;
	this.fromAccount = fromAccount;
	this.toAccount = toAccount;
}
public BankInformation() {
	
}
@Override
public String toString() {
	return "BankInformation [accountType=" + accountType + ", coApplicant=" + coApplicant + ", accountNumber="
			+ accountNumber + ", coAccountNumber=" + coAccountNumber + ", amount=" + amount + ", fromAccount="
			+ fromAccount + ", toAccount=" + toAccount + "]";
}

}
