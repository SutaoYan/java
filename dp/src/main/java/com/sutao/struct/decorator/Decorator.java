package com.sutao.struct.decorator;

public abstract class Decorator implements IComponent{

  IComponent component;

  public Decorator(IComponent component) {
    this.component = component;
  }

  protected abstract void addBehavior();

  @Override
  public void operation() {
    component.operation();
    addBehavior();
  }

}
