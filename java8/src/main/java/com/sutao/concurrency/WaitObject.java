package com.sutao.concurrency;

public class WaitObject extends Thread{
    public static Object object = new Object();
    private String id;
    public WaitObject(String id) {
        this.id = id;
    }
    @Override
    public void run() {
        try {
            synchronized (WaitObject.object) {
//                        Thread.sleep(1000);
                System.out.println("notify" + id);
                WaitObject.object.notify();
                System.out.println("wait" + id);
                WaitObject.object.wait();
                System.out.println("i am start " + id);
                WaitObject.object.notify();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new WaitObject("1");
        Thread t2 = new WaitObject("2");

        t1.start();
        t2.start();
    }
}
