package com.mac286.heaps;

import java.util.PriorityQueue;

public class heapTester {

    public static void main(String[] args) {
        // Priority queue in java is implemented using a heap.
        PriorityQueue<Integer> PQ = new PriorityQueue<Integer>();
        PQ.add(2);
        PQ.add(10);
        PQ.add(5);
        PQ.add(1);
        PQ.add(7);
        System.out.println("PQ: " + PQ);
        PQ.add(8);
        System.out.println("PQ: " + PQ);
        PQ.add(-1);
        System.out.println("PQ: " + PQ);
        ourHeap<Integer> PQ1 = new ourHeap<Integer>();
        PQ1.add(2);
        PQ1.add(8);
        PQ1.add(10);
        PQ1.add(3);
        PQ1.add(4);
        PQ1.add(6);
        PQ1.add(1);
        PQ1.add(5);
        System.out.println("PQ1: " + PQ1);
        // [1, 3, 2, 5, 4, 10, 6, 8]
        System.out.println("removing: " + PQ1.remove());
        System.out.println("PQ1: " + PQ1);
    }
}