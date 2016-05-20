package com.az.dev.genericsandcollectionspart2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by aziarkash on 18-5-2016.
 */
public class MyPriorityQueue {

    static class MyPQSort implements Comparator<Integer> {

        @Override
        public int compare(final Integer o1, final Integer o2) {
            return o2 - o1;
        }
    }

    void priorityQueueExample() {
        int[] ia = {1,5,3,7,6,9,8}; // unordered data
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        System.out.print("unordered data\t\t\t:\t"); // // use natural order
        for (int x : ia) {
            pq1.offer(x);
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.print("ordered using pq.poll()\t:\t");
        for (int x : ia) {
            System.out.print(pq1.poll() + " "); // returns the highest priority and removes the element from the queue
        }
        System.out.println("");
        MyPQSort pqs = new MyPQSort();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(10, pqs);
        for (int x : ia) {
            pq2.offer(x);
        }
        System.out.println("size\t:\t" + pq2.size());
        System.out.println("peek\t:\t" + pq2.peek()); // return idx0 without removing(poll does remove though)
        System.out.println("size\t:\t" + pq2.size());
        System.out.println("poll\t:\t" + pq2.poll());
        System.out.println("size\t:\t" + pq2.size());

        System.out.print("\nremaining elements in the queue\t:\t");
        for (int x : ia) {
            System.out.print(pq2.poll() + " "); // Check null
        }
    }
}
