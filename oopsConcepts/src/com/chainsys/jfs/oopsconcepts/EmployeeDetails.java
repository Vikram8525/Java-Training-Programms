package com.chainsys.jfs.oopsconcepts;

public class EmployeeDetails {
	String name;
	int id;
	String designation;
	int experiance;
	int salary;
	boolean isLocal;
	
	public  EmployeeDetails() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getExperiance() {
		return experiance;
	}

	public void setExperiance(int experiance) {
		this.experiance = experiance;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean isLocal() {
		return isLocal;
	}

	public void setLocal(boolean isLocal) {
		this.isLocal = isLocal;
	}

	public EmployeeDetails(String name, int id, String designation, int experiance, int salary, boolean isLocal) {
		super();
		this.name = name;
		this.id = id;
		this.designation = designation;
		this.experiance = experiance;
		this.salary = salary;
		this.isLocal = isLocal;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [name=" + name + ", id=" + id + ", designation=" + designation + ", experiance="
				+ experiance + ", salary=" + salary + ", isLocal=" + isLocal + "]";
	}
	
}