package com.chainsys.jfs.pojo;

public class College {
	  String name;
	     String course;
	     int duration;

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getCourse() {
	        return course;
	    }

	    public void setCourse(String course) {
	        this.course = course;
	    }

	    public int getDuration() {
	        return duration;
	    }

	    public void setDuration(int duration) {
	        this.duration = duration;
	    }

		@Override
		public String toString() {
			return "College [name=" + name + ", course=" + course + ", duration=" + duration + "]";
		}

		public College(String name, String course, int duration) {
			super();
			this.name = name;
			this.course = course;
			this.duration = duration;
		}

		public College() {
			
		}
	    
}
