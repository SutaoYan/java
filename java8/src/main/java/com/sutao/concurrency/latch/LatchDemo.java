package com.sutao.concurrency.latch;

import java.util.concurrent.CountDownLatch;

public class LatchDemo {
  public static void main(String[] args) {
    CountDownLatch startSignal = new CountDownLatch(1);
    CountDownLatch endSignal = new CountDownLatch(5);
    for (int i = 0; i < 5; i++) {
      new Thread(new woker(i, startSignal, endSignal)).start();
    }
    System.out.println("Work done before staring workers...");
    startSignal.countDown();
    System.out.println("Doing work while workers are running");
    try {
      endSignal.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("All workers finished");
  }
}
