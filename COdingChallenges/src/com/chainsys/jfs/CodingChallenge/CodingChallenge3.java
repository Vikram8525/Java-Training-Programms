package com.chainsys.jfs.CodingChallenge;
import java.util.Scanner;
public class CodingChallenge3 {

	    public static void main(String[] args){
	        Scanner ip = new Scanner(System.in);
	        while(ip.hasNext()){
	            String ipAddress = ip.next();
	            System.out.println(ipAddress.matches(new Regex().pattern));
	        }

	    }
	}

	class Regex {
	    String pattern = "^([01]?\\d{0,2}|25[0-5]|2[0-4]\\d)\\.([01]?\\d{0,2}|25[0-5]|2[0-4]\\d)\\.([01]?\\d{0,2}|25[0-5]|2[0-4]\\d)\\.([01]?\\d{0,2}|25[0-5]|2[0-4]\\d)$";
	}
