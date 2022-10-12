package com.sutao.access2;

public class Main extends Object {
    public static void main(String[] args) {
//        Inherit2 inherit2 = new Inherit2();
//        inherit2.access();

        String a = new String("abc");
        String b = new String("abc");

        System.out.println(a==b);
        System.out.println(a.intern()==b.intern());
    }
}
