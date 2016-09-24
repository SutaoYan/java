package com.sutao.client;

public class Product implements IProduct {

    @Override
    public void display() {
        System.out.println("It's default product!");
    }
}
