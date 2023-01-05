package com.sutao.leetcode.linkedlist;

//https://leetcode.cn/problems/design-linked-list/?envType=study-plan&id=programming-skills-basic&plan=programming-skills&plan_progress=43k6uue
public class MyLinkedList {
    private Node head;
    private Node tail;
    private int count = 0;
    public MyLinkedList() {

    }

    class Node {
        int val;
        Node pre;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node getNode(int index) {
        if (index > count - 1 || index < 0) return null;
        Node node = head;
        while (index > 0) {
            node = node.next;
            index--;
        }
        return node;
    }

    public int get(int index) {
        Node node = getNode(index);
        if (null == node) return -1;
        return node.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
        }
        count++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        count++;
    }

    public void addAtIndex(int index, int val) {
        if (index == count) {
            addAtTail(val);
            return;
        } else if (index <= 0) {
            addAtHead(val);
            return;
        }
        Node node = getNode(index);
        if (null != node) {
            Node newNode = new Node(val);
            node.pre.next = newNode;
            newNode.pre = node.pre;
            node.pre = newNode;
            newNode.next = node;
            count++;
        }
    }

    public void deleteAtIndex(int index) {
        Node node = getNode(index);
        if (null == node) return;
        if(count == 1) {
            head = null;
            tail = null;
            count--;
            return;
        }

        if (head == node) {
            head = node.next;
            node.next.pre = null;
            node.next = null;
        } else if (tail == node) {
            tail = node.pre;
            tail.next = null;
            node.pre = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.pre = null;
            node.next = null;
        }
        count--;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
//        linkedList.get(1);            //返回2
//        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//        linkedList.get(1);
//        System.out.println(linkedList.get(1));//返回3

        linkedList.addAtHead(1);
        linkedList.deleteAtIndex(0);
    }
}
