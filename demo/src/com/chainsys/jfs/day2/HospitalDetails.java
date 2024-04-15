package com.chainsys.jfs.day2;

import java.util.Scanner;

public class HospitalDetails {

	public static void main(String[] args) {
		int hospitalnum;
		int numofdoctor ;
		String hospitalname;
		String headdoctorname;
		String hospitaltype;
		boolean isgoodhospital;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the name of the hospital");
		hospitalname = sc.nextLine();
		System.out.println("enter the hospital num");
		hospitalnum = sc.nextInt();
		System.out.println("enter the number of doctors");
		numofdoctor = sc.nextInt();
		System.out.println("enter the head doctor name");
		headdoctorname = sc.next();
		System.out.println("enter the name of the hospital type");
		hospitaltype = sc.next();
		System.out.println("hospitals rating");
		isgoodhospital = sc.hasNext();
		System.out.println( "\n" + hospitalname  +"\n"+ hospitalnum  +"\n"+ headdoctorname +"\n"+ numofdoctor +"\n"+ hospitaltype +"\n"+ isgoodhospital);


	}

}
