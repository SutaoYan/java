package com.sutao.concurrency.locks;

public class SyncCounter {
  private int count;

  public synchronized void increment () {
    count++;
//    System.out.println("current count="+count);
  }

  public synchronized int  getCount() {
    return count;
  }

}
