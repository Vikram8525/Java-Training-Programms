package com.chainsys.jfs.day3;

import java.util.Scanner;

public class ShopBillGenerator {

	public static void main(String[] args) {
		int note=70;
		int pen=10;
		int box=80;
		int a , b , c, tot,disc,amt;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the total num of notebook you need");
		a = sc.nextInt();
		System.out.println("enter the total num of pen you need");
		b = sc.nextInt();
		System.out.println("enter the total num of box you need");
		c = sc.nextInt();
		tot = ((note*a)+(pen*b)+(box*c));
		System.out.println("Your total amount is  " + tot);
		
		if(tot>1000);
		{
			System.out.println("Congrats you have earned 10% discount");
			disc = tot/10;
			System.out.println("your discount amount is " + disc);
			amt = tot - disc;
			System.out.println("total after discount is  " + amt);
			
			
		}

	}

}
