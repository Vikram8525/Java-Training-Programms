package com.chainsys.jfs.day2;

import java.util.Scanner;

public class MovieDetails {

	public static void main(String[] args) {
		int collection;
		String moviename;
		String hero;
		String director;
		boolean isgood;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the name of the movie");
		moviename = sc.nextLine();
		System.out.println("enter the hero name");
		hero = sc.nextLine();
		System.out.println("enter the director name");
		director = sc.nextLine();
		System.out.println("enter the total movie collection");
		collection = sc.nextInt();
		System.out.println("how was the movie");
		isgood = sc.hasNext();
		System.out.println( "\n" + moviename  +"\n"+ hero  +"\n"+ director +"\n"+ collection +"\n"+ isgood);
	}
		

}
