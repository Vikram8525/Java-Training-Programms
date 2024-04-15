package com.chainsys.jfs.methods;

import java.util.Scanner;

public class CabFare {

	public static void main(String[] args) {
		double distance, fare;
		String cabType;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter cab type of cab you needed (Micro, Mini, or Prime): ");
		System.out.println("Micro ( Rs.10 per km )");
		System.out.println("Mini ( Rs.15 per km )");
		System.out.println("Prime ( Rs.20 per km )");
		cabType = sc.next();
		while(true) {
			if(cabType.equalsIgnoreCase("micro")) {
				break;
			}
			else if(cabType.equalsIgnoreCase("mini")) {
				break;
			}
			else if(cabType.equalsIgnoreCase("prime")) {
				break;
			}
			else {
				System.out.println("Enter only the given types");
				System.out.println("Micro ( Rs.10 per km )");
				System.out.println("Mini ( Rs.15 per km )");
				System.out.println("Prime ( Rs.20 per km )");
				cabType = sc.next();
				break;
			}
		}
		
	
		do {
			System.out.println("Enter the distance you need to travel (in +ve km):(no -ve value) ");
			while (!sc.hasNextDouble()) {
				System.out.println("That's not a valid format for km ()!");
				sc.next();
			}
			distance = sc.nextInt();
		} while (distance <= 0);
		
		FareCalculator fc = new FareCalculator();
		DiscountCalculator dc = new DiscountCalculator();
		CoupanCode cc = new CoupanCode();
		fare = fc.calculateFare(distance, cabType);

		if (fare == -1) {
			System.out.println("Invalid cab type entered. Please choose Micro, Mini, or Prime.");
		} else {
			System.out.println("Cab fare for " + cabType + " cab with distance " + distance + " km is Rs. " + fare);
		}

		if (fare > 2000) {
			System.out.println("\nYour amount is Greater than(>) 2000 \n \nyou are eligible for discount \n ");
			double discountedBill = dc.applyDiscountAndCoupon(fare);
			double discount = fare - discountedBill;
			System.out.println("your discount amount is " + discount + "\n");
			System.out.println("your amount after discount is " + discountedBill + "\n");
			System.out.println("Do you have any Coupan Code");
			System.out.println("enter  either yes or no");
			String code = sc.next();
			switch (code.toLowerCase()) {

			case "yes":
				System.out.println("Enter Your Coupan code ");
				String couponCode = sc.next();
				
				double ccDiscount =cc.coupanCodeCalculator(couponCode, discountedBill);
				if (ccDiscount == 0) {
					System.out.println("Invalid Coupan Code");
					System.out.println("you Lost your chance for Coupan Code");
					System.out.println("your total amount is :"+ discountedBill);
				}
				else {
					System.out.println("Valid Coupan Code ");
					if (couponCode.equals("COUP_2")) {
						System.out.println("You have earned 2% discount\n");
						System.out.println("your discount Amount is "+ ccDiscount);
						System.out.println("\n your amount after discount is : "+ (discountedBill-ccDiscount));
					} else if (couponCode.equals("COUP_5")) {
						System.out.println("You have earned 5% discount\n");
						System.out.println("your discount Amount is "+ ccDiscount);
						System.out.println("\n your amount after discount is : "+ (discountedBill-ccDiscount));
					}
				}
				break;

			case "no":
				System.out.println("you dont have any Coupan code");
				System.out.println("your total amount is :"+ discountedBill);
				break;

			default:
				System.out.println("enter either yes or no only");
				code = sc.next();
			
				switch (code.toLowerCase()) {

				case "yes":
					System.out.println("Enter Your Coupan code ");
					couponCode = sc.next();
					
					ccDiscount = cc.coupanCodeCalculator(couponCode, discountedBill);
					if (ccDiscount == 0) {
						System.out.println("Invalid Coupan Code");
						System.out.println("you dont have any Coupan Code");
						System.out.println("your total amount is :"+ discountedBill);
					}
					else {
						System.out.println("Valid Coupan Code ");
						if (couponCode.equals("COUP_2")) {
							System.out.println("You have earned 2% discount using Coupon Code COUP_2\n");
							System.out.println("your discount Amount is "+ ccDiscount);
							System.out.println("\n your amount after discount is : "+ (discountedBill-ccDiscount));
						} else if (couponCode.equals("COUP_5")) {
							System.out.println("You have earned 5% discount using Coupon Code COUP_5 \n");
							System.out.println("your discount Amount is "+ ccDiscount);
							System.out.println("\n your amount after discount is : "+ (discountedBill-ccDiscount));
						}
					}
					break;

				case "no":
					System.out.println("you dont have any Coupan code");
					System.out.println("your total amount is :"+ discountedBill);
					break;

				default:
					System.out.println("enter either yes or no only");
				}

			}
		}
	}

}
