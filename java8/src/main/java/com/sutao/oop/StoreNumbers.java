package com.sutao.oop;

public class StoreNumbers {
    private boolean[] numbers = new boolean[100];

    private void store(int num) {
        numbers[num] = true;
    }

    public boolean isStored(int num) {
        return numbers[num];
    }

    public static void main(String[] args) {
        StoreNumbers sm = new StoreNumbers();
        System.out.println(sm.isStored(2));
        sm.store(2);
        System.out.println(sm.isStored(2));
    }
}
