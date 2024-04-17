package com.chainsys.jfs.oopsconcepts;

public class EngineeringCollegeInformation {

	public void collegeName(String name) {
		System.out.println(name +" is a Engineering College");
		System.out.println("this College have various Cource's \nCSC \nIT \nMechanical \nAutomobile etc");
	}
	public void collegeType(String cource) {
		System.out.println("you have choosen " + cource +  " from this college");
		System.out.println("you have choosen an engineering course which have 4 years :");
	}
	public void collegeYears(int noOfYears) {
		System.out.println("the cource you have choosen is a "+ noOfYears +" years cource");
	}
}
