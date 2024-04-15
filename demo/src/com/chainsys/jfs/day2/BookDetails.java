package com.chainsys.jfs.day2;

import java.util.Scanner;

public class BookDetails {

	public static void main(String[] args) {
		
		int booktagnum ;
		String bookname;
		String bookgenre;
		String author;
		int price;
		int totalpages;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the name of the book");
			bookname = sc.nextLine();
			System.out.println("enter the book tag num");
			booktagnum = sc.nextInt();
			System.out.println("enter the price");
			price = sc.nextInt();
			System.out.println("enter the author name");
			author = sc.next();
			System.out.println("enter the book genre");
			bookgenre = sc.next();
			System.out.println("total number of pages");
			totalpages = sc.nextInt();
			System.out.println( "\n" + bookname  +"\n"+ booktagnum  +"\n"+ price +"\n"+ author +"\n"+ bookgenre +"\n"+ totalpages);



	}

}
