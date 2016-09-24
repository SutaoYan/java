package com.sutao.creator.SimpleFactory;

import com.sutao.client.IProduct;

public class ProductB implements IProduct {

    @Override
    public void display() {
        System.out.println("It is product B!");
    }
}
