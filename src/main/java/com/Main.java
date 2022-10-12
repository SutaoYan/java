package com;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Pattern;


public class Main {
    private int i = 0;

    static {
        System.out.println("in static");
    }

    {
        System.out.println("in block");
    }

    public Main() {
        System.out.println("constructor");

    }

    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        System.out.println("main");
        new Main().i = 1;

        Class<?> baseType = Bar.class;

        System.out.println(baseType.isAssignableFrom(Home.class));

        try {
            Class<?> c = Class.forName("com.Bar");
            Method[] methods = c.getMethods();
            Constructor[] constructors = c.getConstructors();
            for (Method m : methods) {
                System.out.printf(m.toString());
                System.out.println(p.matcher(m.toString()).replaceAll(""));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Hashtable<String, Integer> hashtable = new Hashtable<>();

        HashMap<String, Integer> map = new HashMap<>();

        Map<String, Integer> m = Collections.synchronizedMap(new HashMap());

        char c = '】';
        System.out.println(c);
        byte b = (byte) c;

        System.out.println(b);
        c = (char) b;
        System.out.println(c);
    }


    public class QueueBehavior {

    }

}
