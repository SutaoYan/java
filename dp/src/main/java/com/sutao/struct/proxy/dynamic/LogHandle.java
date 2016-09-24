package com.sutao.struct.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LogHandle implements InvocationHandler {
  private Object targetObject;

  public Object newProxyObject(Object targetObject) {
    this.targetObject = targetObject;
    return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) {

    System.out.println("start dynamic proxy...");
    for (int i = 0; null != args && i < args.length; i++) {
      //System.out.println(args[i]);
    }
    Object ret = null;

    try {
      ret = method.invoke(targetObject, args);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }

    System.out.println("end dynamic proxy...");
    return ret;
  }
}
