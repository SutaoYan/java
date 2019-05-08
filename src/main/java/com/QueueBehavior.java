package com;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;

public class QueueBehavior {
    static public class Gen implements Iterator<String> {
        int i = 0;
        String[] s = ("one two three four five six seven").split(" ");

        @Override
        public boolean hasNext() {
            return i < s.length;
        }

        @Override
        public String next() {
            return s[i++];
        }
    }

    private static int count = 10;
    public static <T> void test(Queue<T> queue, Iterator<T> gen) {

        while (gen.hasNext()) {
            queue.offer(gen.next());
        }

        while (queue.peek() != null) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        test(new LinkedList<String>(), new Gen());
        test(new PriorityQueue<String>(), new Gen());
        test(new ArrayBlockingQueue<String>(count), new Gen());
        test(new ConcurrentLinkedDeque<String>(), new Gen());
        test(new LinkedBlockingDeque<String>(), new Gen());
        test(new PriorityBlockingQueue<String>(), new Gen());
    }
}
