package com.sutao.creator.FactoryMethod;

import com.sutao.client.IProduct;

public class ConcreteProduct1 implements IProduct {

	@Override
	public void display() {
		System.out.println("I'm ConcreteProduct1!");
	}

}
