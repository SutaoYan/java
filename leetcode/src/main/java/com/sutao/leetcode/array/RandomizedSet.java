package com.sutao.leetcode.array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class RandomizedSet {

    private HashSet<Integer> set = null;

    public RandomizedSet() {
        set = new HashSet<Integer>();
    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(set.size());
        index = (index) % set.size();
        Iterator iterator = set.iterator();
        int res = 0;
        while (index >= 0) {
            res = (int) iterator.next();
            index--;
        }
        return res;
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();

        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));

        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
    }
}
