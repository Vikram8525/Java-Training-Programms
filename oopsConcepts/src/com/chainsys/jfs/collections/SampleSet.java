package com.chainsys.jfs.collections;

import java.util.HashSet;
import java.util.Set;

public class SampleSet {

    public static void main(String[] args) {
       
        Set<String> set = new HashSet<>();

        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");

        System.out.println("Set: " + set);

        String elementToCheck = "Apple";
        if (set.contains(elementToCheck)) {
            System.out.println("Element " + elementToCheck + " exists in the set.");
        } else {
            System.out.println("Element " + elementToCheck + " does not exist in the set.");
        }

        String elementToRemove = "Banana";
        set.remove(elementToRemove);
        System.out.println("Set after removing " + elementToRemove + ": " + set);

        System.out.println("Size of the set: " + set.size());

        set.clear();
        System.out.println("Set after clearing: " + set);
    }
}
