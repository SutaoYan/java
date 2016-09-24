package com.sutao.creator.AbstractFactory;

//for example, the factory is haier
public class HAIERFactory implements IAbstractFactory {

	@Override
	public IProductA CreateProductA() {
		return new ConcreteProductA2();
	}

	@Override
	public IProductB CreateProductB() {
		return new ConcreteProductB2();
	}

}
