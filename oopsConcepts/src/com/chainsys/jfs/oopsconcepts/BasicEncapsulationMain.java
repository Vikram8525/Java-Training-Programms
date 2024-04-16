package com.chainsys.jfs.oopsconcepts;

import java.util.Scanner;

public class BasicEncapsulationMain {

	public static void main(String[] args) {
		String name;
		ValidationClass vc = new ValidationClass();
		EmployeeDetails bc = new EmployeeDetails();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter employee name: ");
		bc.setName(name=sc.next());
		if(!vc.numberchecker(name)) {
			return;
		}
		System.out.println("enter employee id: ");
		bc.setId(sc.nextInt());
		System.out.println("enter employee Designation: ");
		bc.setDesignation(sc.next());
		System.out.println("enter employee salary: ");
		bc.setSalary(sc.nextInt());
		System.out.println("enter employee experiance: ");
		bc.setExperiance(sc.nextInt());
		System.out.println("is the employee local (true / false) : ");
		bc.setLocal(sc.hasNext()); 

		
		System.out.println("Employee Name :" +bc.getName());
		System.out.println("Employee Id : " + bc.getId());
		System.out.println("Employee Designation :"+bc.getDesignation());
		System.out.println("Employee Experiance :"+bc.getExperiance());
		System.out.println("Employee Salary :"+bc.getSalary());
		System.out.println("Is Employee Local :"+bc.isLocal());

	}

}
