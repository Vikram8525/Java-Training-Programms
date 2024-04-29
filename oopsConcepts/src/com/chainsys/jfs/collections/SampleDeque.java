package com.chainsys.jfs.collections;

import java.util.Deque;
import java.util.LinkedList;

public class SampleDeque {

    public static void main(String[] args) {
       
        Deque<String> deque = new LinkedList<>();

        deque.addFirst("Apple");
        deque.addFirst("Banana");
        deque.addFirst("Cherry");

        deque.addLast("Grapes");
        deque.addLast("Mango");

        System.out.println("Deque: " + deque);

        String firstElement = deque.peekFirst();
        System.out.println("First element of the deque: " + firstElement);

        String lastElement = deque.peekLast();
        System.out.println("Last element of the deque: " + lastElement);

        String removedFirstElement = deque.pollFirst();
        System.out.println("Removed first element from the deque: " + removedFirstElement);
        System.out.println("Deque after removal of first element: " + deque);

        String removedLastElement = deque.pollLast();
        System.out.println("Removed last element from the deque: " + removedLastElement);
        System.out.println("Deque after removal of last element: " + deque);

        deque.offerFirst("Pineapple");
        System.out.println("Deque after adding an element to the front: " + deque);

        deque.offerLast("Kiwi");
        System.out.println("Deque after adding an element to the end: " + deque);

        String elementToCheck = "Cherry";
        System.out.println("Does the deque contain " + elementToCheck + "? " + deque.contains(elementToCheck));

        System.out.println("Size of the deque: " + deque.size());

        deque.clear();
        System.out.println("Deque after clearing: " + deque);
    }
}
