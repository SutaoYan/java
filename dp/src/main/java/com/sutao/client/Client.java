package com.sutao.client;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Client {

	public static void main(String[] args) {
        Class target = (Class)TestCases.class;
        try {
            Object instance = target.newInstance();
            for (Method method : target.getDeclaredMethods()) {
                // if method is annotated with @Test
                if (method.isAnnotationPresent(Test.class)) {

                    Annotation annotation = method.getAnnotation(Test.class);
                    Test test = (Test) annotation;
                    try {
                        System.out.println("\n\n"+method.getName()+" start...");
                        method.invoke(instance);
                        System.out.println(method.getName()+" end...\n");
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
	}
}
