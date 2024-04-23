package com.chainsys.jfs.pojo;
	import java.util.Scanner;
	public class MedicalCollege extends CollegeInformation {
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
	}

