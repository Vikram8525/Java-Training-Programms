package com.chainsys.jfs.collections;
import java.util.*;
public class ArrayListSample {

	public static void main(String[] args) {
		
		
//		ArrayList<Integer> arr1 = new ArrayList<Integer>();
//		arr1.add(1);
//		System.out.println("the array list is" + arr1);
		
		
		
//		ArrayList<Integer> arr1 = new ArrayList<Integer>();
//		int n;
//		Scanner sc= new Scanner(System.in);
//		System.out.println("enter the n number :");
//		n = sc.nextInt();
//		for(int i=1; i<=n ; i++) {
//			arr1.add(i);
//		}
//		System.out.println(arr1);
		
		
//		ArrayList<String> arr1 = new ArrayList<String>();
//		ArrayListPojo arr = new ArrayListPojo();
//		int age;
//		String name;
//		Scanner sc= new Scanner(System.in);
//		System.out.println("enter the name :");
//		arr1.add(arr.setName((sc.next())));
//		System.out.println("enter the age :");
//		arr1.add(arr.setAge(sc.nextInt()));
//		
//		System.out.println("the name is " + arr.getName());
//		System.out.println("the age is " + arr.getAge());
		
		
//		
//		
//		ArrayList<ArrayListPojo> arrList = new ArrayList<>(); 
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Enter the name: ");
//        String name = sc.next();
//
//        System.out.println("Enter the age: ");
//        int age = sc.nextInt();
//
//        ArrayListPojo arr = new ArrayListPojo();
//        arr.setName(name);
//        arr.setAge(age);
//
//        arrList.add(arr);
//
//        for (ArrayListPojo element : arrList) {
//            System.out.println("Name: " + element.getName());
//            System.out.println("Age: " + element.getAge());
//        }
//
//        sc.close();
		
		
		
//		
//		
//		ArrayList<ArrayListPojo> arrList = new ArrayList<>(); 
//        Scanner sc = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("Enter the name (type 'done' to stop): ");
//            String name = sc.next();
//            if (name.equals("done")) {
//                break;
//            }
//
//            System.out.println("Enter the age: ");
//            int age = sc.nextInt();
//
//            ArrayListPojo arr = new ArrayListPojo();
//            arr.setName(name);
//            arr.setAge(age);
//
//            arrList.add(arr);
//        }
//
//        System.out.println("Names in the ArrayList:");
//        for (ArrayListPojo element : arrList) {
//            System.out.println(element.getName());
//        }
//
//        System.out.println("\nAges in the ArrayList:");
//        for (ArrayListPojo element : arrList) {
//            System.out.println(element.getAge());
//        }
//
//        sc.close();
//	}
//	

	        ArrayList<Integer> arrayList = new ArrayList<>();
	        Scanner scanner = new Scanner(System.in);

	        arrayList.add(1);
	        arrayList.add(2);
	        arrayList.add(3);

	        System.out.println("ArrayList: " + arrayList);

	        System.out.print("Enter the element to check: ");
	        int elementToCheck = scanner.nextInt();
	        if (arrayList.contains(elementToCheck)) {
	            System.out.println("Element " + elementToCheck + " exists in the ArrayList.");
	        } else {
	            System.out.println("Element " + elementToCheck + " does not exist in the ArrayList.");
	        }

	        System.out.print("Enter the element to delete: ");
	        int elementToDelete = scanner.nextInt();
	        if (arrayList.contains(elementToDelete)) {
	        	arrayList.remove(Integer.valueOf(elementToDelete));
	        } else {
	            System.out.println("Element " + elementToDelete + " does not exist in the ArrayList.");
	        }
	        

	        System.out.println("ArrayList after deletion: " + arrayList);

	        scanner.close();
	    }
	}


