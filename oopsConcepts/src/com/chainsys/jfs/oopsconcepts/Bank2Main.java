package com.chainsys.jfs.oopsconcepts;

public class Bank2Main {

	public static void main(String[] args) {
		Bank2Information bankInfo = new Bank2Information();
		bankInfo.setAccountHolderName("vikram");
		bankInfo.setAccountNumber(1234567);
		bankInfo.setIfscCode(1234);
		
		Bank2.depsoit(2000, bankInfo.getAccountNumber());
		Bank2.depsoit(3000, bankInfo.getIfscCode(), bankInfo.getAccountNumber());
		Bank2.depsoit(1000, bankInfo.getIfscCode(), bankInfo.getAccountNumber());
	}

}
