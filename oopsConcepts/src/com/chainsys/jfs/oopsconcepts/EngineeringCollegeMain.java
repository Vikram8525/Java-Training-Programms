package com.chainsys.jfs.oopsconcepts;

import java.util.Scanner;

public class EngineeringCollegeMain {

	public static void main(String[] args) {
		EngineeringCollegePojo ecp = new EngineeringCollegePojo();
		ArtsCollegeInformation aci = new ArtsCollegeInformation();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Child Class");
		System.out.println("enter College Name :");
		ecp.setName(sc.next());
		aci.collegeName(ecp.getName());
		System.out.println("enter a cource form the above list :");
		ecp.setCource(sc.next());
		aci.collegeType(ecp.getCource());
		System.out.println("enter the number of years for the cource :");
		ecp.setNoOfYears(sc.nextInt());
		aci.collegeYears(ecp.getNoOfYears());
	}

}
