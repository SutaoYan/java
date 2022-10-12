package com.sutao.concurrency;

public class TestClass {

    public static synchronized void MethodA()  {
        System.out.println("method A");

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized void MethodB() {
        System.out.println("method B");
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
