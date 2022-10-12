package com;

public class TestGC {
    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[5 * _1MB];

        allocation1[0] = 0;
        allocation2[0] = 0;
        allocation3[0] = 0;
        allocation4[0] = 0;

    }

    public static void main(String[] args) {

//        System.out.println(System.getProperties());

        testAllocation();
    }
}
