package com.chainsys.jfs.collections;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListSample {

	public static void main(String[] args) {

		        LinkedList<Integer> linkedList = new LinkedList<>();
		        Scanner scanner = new Scanner(System.in);

		        
		        linkedList.add(1);
		        linkedList.add(2);
		        linkedList.add(3);

		        System.out.println("LinkedList: " + linkedList);

		        System.out.print("Enter the element to check: ");
		        int elementToCheck = scanner.nextInt();
		        if (linkedList.contains(elementToCheck)) {
		            System.out.println("Element " + elementToCheck + " exists in the LinkedList.");
		        } else {
		            System.out.println("Element " + elementToCheck + " does not exist in the LinkedList.");
		        }

		        System.out.print("Enter the element to delete: ");
		        int elementToDelete = scanner.nextInt();
		        linkedList.remove(Integer.valueOf(elementToDelete));

		        System.out.println("LinkedList after deletion: " + linkedList);

		        scanner.close();
		    }
		


	}


