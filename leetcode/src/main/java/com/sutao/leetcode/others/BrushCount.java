package com.sutao.leetcode.others;

public class BrushCount {

    private static int brushCount(int[] buildings)
    {
        int brushCount = 0;
        int prevHeight = 0;
        for(int i = 0; i < buildings.length; i++)
        {
            if(buildings[i] > prevHeight)
                brushCount = brushCount + (buildings[i] - prevHeight);
            prevHeight = buildings[i];
        }
        return brushCount;
    }

    public static void main(String[] args) {
        System.out.println(brushCount(new int[] {5, 8}));
        System.out.println(brushCount(new int[] {1,1,1,1}));
        System.out.println(brushCount(new int[] {1,3,2,1,2,1,5,3,3,4,2}));
    }
}
