package com.chainsys.jfs.collections;

	import java.util.TreeSet;

	public class SampleTreeSet {

	    public static void main(String[] args) {
	       
	        TreeSet<String> treeSet = new TreeSet<>();
	        
	        treeSet.add("Cherry");
	        treeSet.add("Apple");
	        treeSet.add("Banana");
	        

	        System.out.println("TreeSet: " + treeSet);

	        String elementToCheck = "Banana";
	        System.out.println("Does the TreeSet contain " + elementToCheck + "? " + treeSet.contains(elementToCheck));

	        String elementToRemove = "Cherry";
	        treeSet.remove(elementToRemove);
	        System.out.println("TreeSet after removing " + elementToRemove + ": " + treeSet);

	        String firstElement = treeSet.first();
	        System.out.println("First element of the TreeSet: " + firstElement);

	        String lastElement = treeSet.last();
	        System.out.println("Last element of the TreeSet: " + lastElement);

	        System.out.println("Size of the TreeSet: " + treeSet.size());

	        treeSet.clear();
	        System.out.println("TreeSet after clearing: " + treeSet);
	    }
	}

