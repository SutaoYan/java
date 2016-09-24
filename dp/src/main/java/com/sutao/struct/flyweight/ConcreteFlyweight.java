package com.sutao.struct.flyweight;

public class ConcreteFlyweight extends Flyweight{
  private String state;
  public ConcreteFlyweight(String state) {
    this.state = state;
  }

  @Override
  public void operation() {
    System.out.println("concrete flyweight "+ state);
  }
}
