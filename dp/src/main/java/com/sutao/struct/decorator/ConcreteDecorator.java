package com.sutao.struct.decorator;

public class ConcreteDecorator extends Decorator{

  public ConcreteDecorator(IComponent component) {
    super(component);
  }

  protected void addBehavior() {
    System.out.println("ConcreteDecorator addBehavior");
  }

}
