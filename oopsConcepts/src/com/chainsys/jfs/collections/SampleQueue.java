package com.chainsys.jfs.collections;

import java.util.LinkedList;
import java.util.Queue;

public class SampleQueue {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.add("Apple");
        queue.add("Banana");
        queue.add("Cherry");

        System.out.println("Queue: " + queue);

        String frontElement = queue.peek();
        System.out.println("Front element of the queue: " + frontElement);

        String removedElement = queue.poll();
        System.out.println("Removed element from the queue: " + removedElement);
        System.out.println("Queue after removal: " + queue);

        System.out.println("Is the queue empty? " + queue.isEmpty());

        queue.add("Grapes");
        queue.offer("Mango");
        System.out.println("Queue after adding more elements: " + queue);

        System.out.println("Size of the queue: " + queue.size());

        queue.clear();
        System.out.println("Queue after clearing: " + queue);
    }
}
