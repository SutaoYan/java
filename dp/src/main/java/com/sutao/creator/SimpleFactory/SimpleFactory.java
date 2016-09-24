package com.sutao.creator.SimpleFactory;

import com.sutao.client.IProduct;

public class SimpleFactory {
    public enum PRODUCT_TYPE {
        A,
        B
    };

    public static IProduct createProduct(PRODUCT_TYPE type) {
        switch (type) {
            case A:
                return new ProductA();
            case B:
                return new ProductB();
                default:
                    break;
        };
        return null;
    }
}
