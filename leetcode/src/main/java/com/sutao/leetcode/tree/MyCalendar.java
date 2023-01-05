package com.sutao.leetcode.tree;

//https://leetcode.cn/problems/my-calendar-i/?envType=study-plan&id=programming-skills-basic&plan=programming-skills&plan_progress=43k6uue
public class MyCalendar {

    class TreeNode {
        int start;
        int end;
        TreeNode left;
        TreeNode right;

        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private TreeNode root = null;

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        if (null == root) {
            root = new TreeNode(start, end);
        } else {
            TreeNode node = search(start, end);
            if (null == node) return false;
            TreeNode child = new TreeNode(start, end);
            if (end <= node.start) {
                node.left = child;
            } else if (start >= node.end) {
                node.right = child;
            }
        }
        return true;
    }


    private TreeNode search(int start, int end) {
        TreeNode node = root;
        TreeNode pre = null;
        while (node != null) {
            if (end <= node.start) {
                pre = node;
                node = node.left;
            } else if (start >= node.end) {
                pre = node;
                node = node.right;
            } else {
                pre = null;
                break;
            }
        }

        return pre;
    }

//    ["MyCalendar","book","book","book","book","book","book","book","book","book","book"]
//            [[],[48,50],[0,6],[6,13],[8,13],[15,23],[49,50],[45,50],[29,34],[3,12],[38,44]]
//[null,true,true,true,false,true,false,false,true,false,true]
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(  myCalendar.book(48, 50));
        System.out.println(myCalendar.book(0, 6));
        System.out.println(myCalendar.book(6, 13));
        System.out.println(myCalendar.book(8, 13));
        System.out.println(myCalendar.book(15, 23));
        System.out.println(myCalendar.book(49, 50));
        System.out.println(myCalendar.book(45, 50));
        System.out.println(myCalendar.book(29, 34));
    }
}
