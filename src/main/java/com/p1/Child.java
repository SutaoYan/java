package com.p1;

public class Child extends Parent{

    public Child() {
    }

    public static void main(String[] args) {
        Child d =  new Child();
        System.out.println(Integer.toHexString(d.hashCode()));
        System.out.println(d.toString());
        int x;
        String s;

    }


}
