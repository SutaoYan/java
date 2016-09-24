package com.sutao.struct.proxy.dynamic;

public class RelSub implements IProxy{
  @Override
  public void operation() {
    System.out.println("it is real subject...");
  }
}
