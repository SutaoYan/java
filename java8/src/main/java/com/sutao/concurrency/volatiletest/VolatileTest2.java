package com.sutao.concurrency.volatiletest;

public class VolatileTest2 {

    private volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (num == 0) {
            }
        }).start();
        Thread.sleep(1000);

        num = 1;
    }
}