package com.chainsys.jfs.collections;

public class ArrayListPojo {
	int age;
	String name;
	public ArrayListPojo(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayListPojo() {
		
	}
	@Override
	public String toString() {
		return "ArrayListPojo [age=" + age + ", name=" + name + "]";
	}
}
