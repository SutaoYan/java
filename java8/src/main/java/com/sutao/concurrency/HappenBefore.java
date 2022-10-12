package com.sutao.concurrency;

public class HappenBefore {
    private static int i = 0, j = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            i = 0;
            j = 0;
            a = 0;
            b = 0;

            Thread t1 = new Thread(() -> {
                a = 1;
                i = b;
            });

            Thread t2 = new Thread(() -> {
                b = 1;
                j = a;
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println("i=" + i + ",j=" + j);
            if (0 == i && 0 == j) break;
        }
    }
}
