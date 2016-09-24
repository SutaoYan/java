package com.sutao.concurrency.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class LocksDemo {

  private Counter counter = new Counter();
  private SyncCounter syncCounter = new SyncCounter();
  private LockedCounter lcounter = new LockedCounter();
  private AtomicCounter acounter = new AtomicCounter();

  public void demoCounter() {
    ExecutorService service = Executors.newCachedThreadPool();
    IntStream.range(0, 1000)
            .forEach(i->service.submit(counter::increment));
    long wait = 1000;
    try {
      boolean b = service.awaitTermination(wait, TimeUnit.MILLISECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Counter count=" + counter.getCount());
  }

  public void demoSyncCounter() {
    ExecutorService service = Executors.newCachedThreadPool();
    IntStream.range(0, 1000)
            .forEach(i->service.submit(syncCounter::increment));
    long wait = 1000;
    try {
      boolean b = service.awaitTermination(wait, TimeUnit.MILLISECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
//    try {
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
    System.out.println("Counter count=" + syncCounter.getCount());
  }

  public void demoLockedCounter() {
    ExecutorService service = Executors.newCachedThreadPool();
    IntStream.range(0, 1000)
            .forEach(i->service.submit(lcounter::increment));
    long wait = 1000;
    try {
      boolean b = service.awaitTermination(wait, TimeUnit.MILLISECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Counter count=" + lcounter.getCount());
  }

  public void demoAtomicCounter() {
    ExecutorService service = Executors.newCachedThreadPool();
    IntStream.range(0, 1000)
            .forEach(i->service.submit(acounter::increment));
    long wait = 1000;
    try {
      boolean b = service.awaitTermination(wait, TimeUnit.MILLISECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Counter count=" + acounter.getCount());
  }

  public static void main(String[] args) {
    LocksDemo demo = new LocksDemo();
    demo.demoCounter();
    demo.demoSyncCounter();
    demo.demoLockedCounter();
    demo.demoAtomicCounter();
  }
}
