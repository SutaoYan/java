package com.sutao.leetcode.others;

import java.util.HashMap;
import java.util.Optional;
import java.util.PriorityQueue;

class Item {
    String key;

    String val;
    long timeToLeaveInMilliseconds;

    public Item(String key, String val, long timeToLeaveInMilliseconds) {
        this.key = key;
        this.val = val;
        this.timeToLeaveInMilliseconds = timeToLeaveInMilliseconds;
    }
}

public class CachingDataStructure {

    private int maxSize;
    //    private TimeProvider timeProvider;
    private HashMap<String, Item> store;

    private PriorityQueue<Item> priorityQueue;

    CachingDataStructure(int maxSize) {
//        this.timeProvider = timeProvider;
        this.maxSize = maxSize;
        store = new HashMap<>();
        priorityQueue = new PriorityQueue<>((o1, o2) -> o1.timeToLeaveInMilliseconds > o2.timeToLeaveInMilliseconds ? 1 : -1);
    }

    public void put(String key, String value, long timeToLeaveInMilliseconds) {
        if (null == key || null == value || 0 >= timeToLeaveInMilliseconds) {
            throw new IllegalArgumentException();
        }

        removeExpiredItem();

        if (!priorityQueue.isEmpty()) {
            Item item = priorityQueue.peek();
            if (timeToLeaveInMilliseconds < item.timeToLeaveInMilliseconds) return;
        }

        //Item existed = store.get(key);
        //if (null != existed && timeToLeaveInMilliseconds > existed.timeToLeaveInMilliseconds) {
        //    return;
        //}

        if (store.size() >= maxSize) {
            Item item = priorityQueue.poll();
            store.remove(item.key);
        }

        Item item = new Item(key, value, timeToLeaveInMilliseconds);
        priorityQueue.add(item);
        store.put(key, item);
    }

    public Optional<String> get(String key) {
        removeExpiredItem();
        Item item = store.get(key);
        if(null == item) return Optional.empty();
        return Optional.ofNullable(item.val);
    }

    public int size() {
        removeExpiredItem();
        return store.size();
    }

    private void removeExpiredItem() {
        while (!priorityQueue.isEmpty()) {
            Item val = priorityQueue.peek();
            if (val.timeToLeaveInMilliseconds < System.currentTimeMillis()) {
                store.remove(val.key);
                priorityQueue.poll();
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        CachingDataStructure cachingDataStructure = new CachingDataStructure(3);

        cachingDataStructure.put("1", "1", System.currentTimeMillis() + 100000);
        cachingDataStructure.put("1", "11", System.currentTimeMillis() + 100000);
        cachingDataStructure.put("2", "2", System.currentTimeMillis() + 200000);
        cachingDataStructure.put("3", "3", System.currentTimeMillis() - 20000);
        cachingDataStructure.put("3", "3", System.currentTimeMillis() + 120000);
        cachingDataStructure.put("4", "4", System.currentTimeMillis() + 170000);

        System.out.println(cachingDataStructure.get("1"));
        System.out.println(cachingDataStructure.get("2"));
        System.out.println(cachingDataStructure.get("4"));
        System.out.println(cachingDataStructure.get("3"));

        System.out.println(cachingDataStructure.size());
    }
}
