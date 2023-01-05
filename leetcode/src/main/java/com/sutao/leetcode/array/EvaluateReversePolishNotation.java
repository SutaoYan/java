package com.sutao.leetcode.array;

import java.util.LinkedList;

//https://leetcode.cn/problems/evaluate-reverse-polish-notation/?plan=programming-skills&plan_progress=s5lrat5
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        LinkedList<String> stack = new LinkedList<>();
        Integer result;
        for (String token : tokens) {
            if (token.equals("+")) {
                result = Integer.valueOf(stack.pop()) + Integer.valueOf(stack.pop());
                stack.push(result.toString());
            } else if (token.equals("-")) {
                Integer op1 = Integer.valueOf(stack.pop());
                Integer op2 = Integer.valueOf(stack.pop());
                result = op2 - op1;
                stack.push(result.toString());
            } else if (token.equals("*")) {
                Integer op1 = Integer.valueOf(stack.pop());
                Integer op2 = Integer.valueOf(stack.pop());
                result = op2 * op1;
                stack.push(result.toString());
            } else if (token.equals("/")) {
                Integer op1 = Integer.valueOf(stack.pop());
                Integer op2 = Integer.valueOf(stack.pop());
                result = op2 / op1;
                stack.push(result.toString());
            } else {
                stack.push(token);
            }
        }

        return Integer.valueOf(stack.pop());
    }


    public static void main(String[] args) {
        System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[] {"2","1","+","3","*"}));
        System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[] {"4","13","5","/","+"}));
        System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
