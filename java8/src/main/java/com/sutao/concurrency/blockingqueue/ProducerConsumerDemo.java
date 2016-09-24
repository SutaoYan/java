package com.sutao.concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumerDemo {
  public static void main(String[] args) {
    BlockingQueue<Message> queue = new LinkedBlockingDeque<>();
    Producer p1 = new Producer(1, queue);
    Producer p2 = new Producer(2, queue);
    Consumer c1 = new Consumer(1, queue);
    Consumer c2 = new Consumer(2, queue);
    Consumer c3 = new Consumer(3, queue);

    ExecutorService service = Executors.newFixedThreadPool(
            4);
    service.execute(p1);
    service.execute(c1);
    service.execute(p2);
    service.execute(c2);
    service.execute(c3);
    service.shutdown();
  }
}
