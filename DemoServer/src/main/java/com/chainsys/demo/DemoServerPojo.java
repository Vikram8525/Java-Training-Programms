package com.chainsys.demo;

public class DemoServerPojo {

	 String name;
     String phone; 
     String date;
     String pass;
     String rpass;
     
     
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRpass() {
		return rpass;
	}
	public void setRpass(String rpass) {
		this.rpass = rpass;
	}
	public DemoServerPojo(String name, String phone, String date, String pass, String rpass) {
		
		this.name = name;
		this.phone = phone;
		this.date = date;
		this.pass = pass;
		this.rpass = rpass;
	}
	public DemoServerPojo() {
		
	}
	@Override
	public String toString() {
		return "DemoServerPojo [name=" + name + ", phone=" + phone + ", date=" + date + ", pass=" + pass + ", rpass="
				+ rpass + "]";
	}
	
     
}
