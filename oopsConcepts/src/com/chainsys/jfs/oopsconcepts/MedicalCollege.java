package com.chainsys.jfs.oopsconcepts;

import java.util.Scanner;

	public class MedicalCollege implements CollegeInformation {
	    private College college;

	    public MedicalCollege() {
	        college = new College();
	    }

	    public void getInput() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter Medical College Details:");
	        System.out.print("Name: ");
	        college.setName(scanner.nextLine());
	        System.out.print("Course: ");
	        college.setCourse(scanner.nextLine());
	        System.out.print("Duration (in years): ");
	        college.setDuration(scanner.nextInt());
	    }

	    public void displayDetails() {
	        displayCollegeName(college.getName(), "Medical");
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


