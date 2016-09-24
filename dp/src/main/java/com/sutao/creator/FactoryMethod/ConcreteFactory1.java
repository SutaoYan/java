package com.sutao.creator.FactoryMethod;

import com.sutao.client.IProduct;

public class ConcreteFactory1 implements IFactory {


	@Override
	public IProduct CreateProduct() {
		return new ConcreteProduct1();
	}
}
