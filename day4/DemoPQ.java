package day4;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DemoPQ {
    public static void main(String[] args) {
        // Queue q1 = new LinkedList();
        // q1.offer("Razak Mohamed");
        // q1.offer(34);
        // q1.offer(5.4);
        // System.out.println(q1.peek());
        // q1.poll();
        // System.out.println(q1);
        // Queue<String> q2=new PriorityQueue<>();// ascending
        Queue<String> q2=new PriorityQueue<>((a, b) -> b.compareTo(a));// descending
        q2.offer("Sabari");
        q2.offer("Balaji");
        q2.offer("Richard");
        q2.offer("Anbu");
        q2.offer("Prakash");
        System.out.println(q2.poll());
        System.out.println(q2.poll());
        System.out.println(q2.poll());
        // System.out.println(q2);
    }
}
