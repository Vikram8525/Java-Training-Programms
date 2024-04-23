package com.chainsys.jfs.pojo;

public abstract class CollegeInformation {

	 public void displayCollegeName(String name, String type) {
	        System.out.println(name + " is a " + type + " College");
	    }

	    public void displayCourseDetails(String course, int duration) {
	        System.out.println("Course: " + course);
	        System.out.println("Duration: " + duration + " years");
	    }

	    public abstract void getInput();

	    public abstract void displayDetails();
	}