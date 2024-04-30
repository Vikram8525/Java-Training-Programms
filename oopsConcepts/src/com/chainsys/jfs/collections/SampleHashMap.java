package com.chainsys.jfs.collections;

import java.util.HashMap;
import java.util.Map;

public class SampleHashMap {

    public static void main(String[] args) {
        
        Map<String, Integer> hashMap = new HashMap<>();

        hashMap.put("Apple", 10);
        hashMap.put("Banana", 20);
        hashMap.put("Cherry", 30);
        hashMap.put("Apple", 30);

        System.out.println("HashMap: " + hashMap);

        String keyToCheck = "Banana";
        System.out.println("Does the map contain key \"" + keyToCheck + "\"? " + hashMap.containsKey(keyToCheck));

        int valueToCheck = 20;
        System.out.println("Does the map contain value " + valueToCheck + "? " + hashMap.containsValue(valueToCheck));

        String keyToGet = "Cherry";
        int value = hashMap.get(keyToGet);
        System.out.println("Value associated with key \"" + keyToGet + "\": " + value);

        String keyToRemove = "Banana";
        hashMap.remove(keyToRemove);
        System.out.println("Map after removing key \"" + keyToRemove + "\": " + hashMap);

        System.out.println("Size of the map: " + hashMap.size());

        hashMap.clear();
        System.out.println("Map after clearing: " + hashMap);
    }
}
