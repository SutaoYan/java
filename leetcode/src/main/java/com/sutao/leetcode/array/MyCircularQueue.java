package com.sutao.leetcode.array;

import java.util.Arrays;

//https://leetcode.cn/problems/design-circular-queue/?envType=study-plan&id=programming-skills-basic&plan=programming-skills&plan_progress=43k6uue
public class MyCircularQueue {
    int[] arr;
    int capacity = 0;
    int tail = 0;
    int head = 0;

    public MyCircularQueue(int k) {
        arr = new int[k];
        Arrays.fill(arr, -1);
        capacity = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        if (isEmpty()) {
            arr[head] = value;
        } else {
            tail = (tail + 1) % capacity;
            arr[tail] = value;
        }
        return true;
    }

    public boolean deQueue() {
        if (arr[head] != -1) {
            arr[head] = -1;
            if (tail == head) {
                tail = head = (head + 1) % capacity;
            } else {
                head = (head + 1) % capacity;
            }
            return true;
        }
        return false;
    }

    public int Front() {
        return arr[head];
    }

    public int Rear() {
        return arr[tail];
    }

    public boolean isEmpty() {
        return arr[head] == -1;
    }

    public boolean isFull() {
        return ((tail + 1) % capacity == head && arr[head] != -1);
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(6); // 设置长度为 3
        circularQueue.enQueue(6); // 返回 true
        circularQueue.Rear();
        circularQueue.Rear();
        circularQueue.deQueue();

        circularQueue.enQueue(5); // 返回 true
        circularQueue.Rear();
        circularQueue.deQueue(); // 返回 true
        circularQueue.Front();

        circularQueue.deQueue(); // 返回 true
        circularQueue.deQueue(); // 返回 true
        circularQueue.deQueue(); // 返回 true

    }
}
