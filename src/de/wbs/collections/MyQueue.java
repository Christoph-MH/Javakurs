package de.wbs.collections;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class MyQueue {
    public static void main(String[] args) {
//        Queue<Integer> q = new PriorityQueue<>(3,new Sort());
        Queue<Integer> q = new ArrayBlockingQueue<>(3); // feste Kapazität, es werden keine neuen elemente hinzugefügt

//        Collection<Integer> q = new PriorityQueue<>(3,new Sort()); // keine Sortierung
        q.add(2);
        q.add(4);
        q.offer(3);
//        q.add(1);
//        q.add(5);
        q.offer(0);
        System.out.println("size: "+q.size());
//        System.out.println("Element: " + q.element());
//        System.out.println(q.size());
//        System.out.println("peek: " + q.peek());
//        System.out.println(q.size());
//        System.out.println("poll: " + q.poll());
//        System.out.println(q.size());
//        System.out.println("peek: " + q.peek());
        int count = q.size(); // hier size fix, in der Schleife würde size immer kleiner
        for (int i = 0; i < count; i++) {
            System.out.println(q.poll());
        }
//        for (int i : q) {
//            System.out.println(i);
//        }
        System.out.println("size: "+q.size());
    }

}
// keine sortierung in der priority queue
class Sort implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
            return 0;   // keine Sortierung
    }
}
