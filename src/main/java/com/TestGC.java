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

//        testAllocation();

        System.out.println(average(new int[] {48000,59000,99000,13000,78000,45000,31000,17000,39000
                ,37000,93000,77000,33000,28000,4000,54000,67000,6000,1000,11000}));
    }

    public static double average(int[] salary) {
        int minimumn = Integer.MAX_VALUE;
        int maxiumum = Integer.MIN_VALUE;
        double sum = 0;
        for(int i  = 0; i < salary.length; i ++) {
            minimumn = Math.min(minimumn, salary[i]);
            maxiumum = Math.max(maxiumum, salary[i]);
            sum += salary[i];
        }
        sum = sum - minimumn - maxiumum;
        return sum/(salary.length - 2);
    }
}
