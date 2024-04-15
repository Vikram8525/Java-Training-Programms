package com.chainsys.jfs.day2;

import java.util.Scanner;

public class StudentDetails {

	public static void main(String[] args) {
		int rollnum;
		String name;
		int standard ;
		char section;
		boolean isgoodboy;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the name of the student");
		name = sc.nextLine();
		System.out.println("enter the Students rollnum");
		rollnum = sc.nextInt();
		System.out.println("enter the students standard");
		standard = sc.nextInt();
		System.out.println("enter the students section");
		section = sc.next().charAt(0);
		System.out.println("about boys character");
		isgoodboy = sc.hasNext();
		System.out.println( "\n" + name  +"\n"+ rollnum  +"\n"+ standard +"\n"+ section +"\n"+ isgoodboy);

	}

}
