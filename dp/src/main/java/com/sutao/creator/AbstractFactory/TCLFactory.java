package com.sutao.creator.AbstractFactory;

//for example, it's TCL
public class TCLFactory implements IAbstractFactory {

	@Override
	public IProductA CreateProductA() {
		return new ConcreteProductA1();
	}

	@Override
	public IProductB CreateProductB() {
		return new ConcreteProductB1();
	}

}
