package com.sutao.leetcode.array;

import java.util.LinkedList;

//https://leetcode.cn/problems/min-stack/?envType=study-plan&id=programming-skills-basic&plan=programming-skills&plan_progress=43k6uue
public class MinStack {
    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> minStack = new LinkedList<>();

    public MinStack() {
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {

        stack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
