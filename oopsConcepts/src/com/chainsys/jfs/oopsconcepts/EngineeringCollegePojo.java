package com.chainsys.jfs.oopsconcepts;

public class EngineeringCollegePojo {
	String name;
	String cource;
	int noOfYears;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCource() {
		return cource;
	}
	public void setCource(String cource) {
		this.cource = cource;
	}
	public int getNoOfYears() {
		return noOfYears;
	}
	public void setNoOfYears(int noOfYears) {
		this.noOfYears = noOfYears;
	}
	public EngineeringCollegePojo(String name, String cource, int noOfYears) {
		super();
		this.name = name;
		this.cource = cource;
		this.noOfYears = noOfYears;
	}
	public EngineeringCollegePojo() {
		
	}
	@Override
	public String toString() {
		return "EngineeringCollegePojo [name=" + name + ", cource=" + cource + ", noOfYears=" + noOfYears + "]";
	}
	
	
}
