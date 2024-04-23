package com.chainsys.jfs.oopsconcepts;

	import java.util.Scanner;

	public class EngineeringCollege implements CollegeInformation {
	    private College college;

	    public EngineeringCollege() {
	        college = new College();
	    }

	    public void getInput() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter Engineering College Details:");
	        System.out.print("Name: ");
	        college.setName(scanner.nextLine());
	        System.out.print("Course: ");
	        college.setCourse(scanner.nextLine());
	        System.out.print("Duration (in years): ");
	        college.setDuration(scanner.nextInt());
	    }

	    public void displayDetails() {
	        displayCollegeName(college.getName(), "Engineering");
	        displayCourseDetails(college.getCourse(), college.getDuration());
	    }

	    @Override
	    public void displayCollegeName(String name, String type) {
	        System.out.println(name + " is a " + type + " College");
	    }

	    @Override
	    public void displayCourseDetails(String course, int duration) {
	        System.out.println("Course: " + course);
	        System.out.println("Duration: " + duration + " years");
	    }
	}


