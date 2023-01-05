package com.sutao.leetcode.backtrack;

import java.util.*;

public class Hotel {

    private List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        HashMap<String, List<Integer>> price = new HashMap<>();
//        price.put("a", Arrays.asList(10, 10, 20, 30));
//        price.put("b", Arrays.asList(15, 15, 10));
//        price.put("c", Arrays.asList(5, 10, 15));

//        price.put("a", Arrays.asList(10, 10));
//        price.put("b", Arrays.asList(15, 20, 20));
//        price.put("c", Arrays.asList(5, 60));

        price.put("a", Arrays.asList(10));
        price.put("b", Arrays.asList(40));
        price.put("c", Arrays.asList(50));
        price.put("d", Arrays.asList(60));
        System.out.println(new Hotel().findAllPlans(price, 50));
    }

    private List<List<String>> findAllPlans(HashMap<String, List<Integer>> price, int budge) {

        List<String> cities = new ArrayList<>();
        List<List<Integer>> amounts = new ArrayList<>();

        for (String city : price.keySet()) {
            cities.add(city);
            amounts.add(price.get(city));
        }

        LinkedList<String> onPath = new LinkedList<>();
        backtrack(cities, amounts, budge, 0, onPath);
        return res;
    }

    private void backtrack(List<String> cities, List<List<Integer>> amounts, int budge, int day, LinkedList<String> onPath) {
        if (budge < 0) {
            return;
        }
        res.add(new LinkedList<>(onPath));
        for (int i = 0; i < cities.size(); i++) {
            String city = cities.get(i);
            List<Integer> dayPrice = amounts.get(i);
            if (dayPrice.size() < day + 1) continue;
            onPath.addLast(city);
            backtrack(cities, amounts, budge - amounts.get(i).get(day), day + 1, onPath);
            onPath.removeLast();
        }
    }
}
