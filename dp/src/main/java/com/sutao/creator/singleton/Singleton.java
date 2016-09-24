package com.sutao.creator.singleton;

public class Singleton {
    private static Singleton instance1 = null;

    private Singleton() {

    }

    public static Singleton getInstance1 () {
        if (null == instance1) {
            synchronized (Singleton.class) {
                if (null == instance1) {
                    instance1 = new Singleton();
                }
            }
        }
        return instance1;
    }

    private static class SingletonHelp {
        private static final Singleton INSTANCE2 = new Singleton();
    }

    public static Singleton getInstance2 () {
        return SingletonHelp.INSTANCE2;
    }

    public void operation () {
        System.out.println("singleton operation...");
    }
}
