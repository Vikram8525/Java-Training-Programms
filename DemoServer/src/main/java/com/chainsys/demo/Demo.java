package com.chainsys.demo;

import java.util.ArrayList;

public class Demo {
	ArrayList<DemoServerPojo> viewing = new ArrayList<>();
	public void add (String name,String phone,String date,String pass,String rpass) {
		DemoServerPojo dp = new DemoServerPojo(name,phone,date,pass,rpass);
		viewing.add(dp);
		
	}
	public ArrayList<DemoServerPojo> Display() {
		return viewing;
	}
}
