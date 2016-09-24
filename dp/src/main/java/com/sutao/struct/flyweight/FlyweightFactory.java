package com.sutao.struct.flyweight;

import java.util.Hashtable;

public class FlyweightFactory {
  private Hashtable objStore = new Hashtable();

  public Flyweight getFlyweight(String name) {
    Flyweight flyweight = (Flyweight) objStore.get(name);
    if (null == flyweight) {
      flyweight = new ConcreteFlyweight(name);
      objStore.put(name, flyweight);
    }

    return flyweight;
  }

  public int getSize () {
    return objStore.size();
  }
}
