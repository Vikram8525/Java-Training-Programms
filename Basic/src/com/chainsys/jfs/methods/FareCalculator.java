package com.chainsys.jfs.methods;

public class FareCalculator {
	
	public static double calculateFare(double distance, String cabType) {
		double farePerKm;
		switch (cabType.toLowerCase()) {
		case "micro":
			farePerKm = 10;
			break;
		case "mini":
			farePerKm = 15;
			break;
		case "prime":
			farePerKm = 20;
			break;
		default:
			return -1; 
		}
		return distance * farePerKm;

	}
}
