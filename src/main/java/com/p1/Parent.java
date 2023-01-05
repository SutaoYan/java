package com.p1;

import java.util.Arrays;

class Parent implements Cloneable {

    int[] arr;
Integer i;
    public Parent() {
        arr = new int[3];
        Arrays.fill(arr, 1);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        int x;
        String s;
        return super.clone();
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        Parent p = new Parent();

        Parent p2 = (Parent) p.clone();
        p.arr[1] = 10;
        System.out.println(p2.arr[1]);
        System.out.println(p.arr[1]);

        byte a = 127;
        byte b = 127;

        b += a;

        System.out.println(b);

    }
}
