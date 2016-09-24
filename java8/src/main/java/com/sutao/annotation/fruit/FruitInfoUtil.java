package com.sutao.annotation.fruit;

import java.lang.Class;import java.lang.String;import java.lang.System;import java.lang.reflect.Field;

/**
 * Created by yansutao on 9/11/16.
 */
public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz) {

        String strFruitName = "com.sutao.fruit name:";
        String strFruitColor = "com.sutao.fruit color:";
        String strFruitProvider = "provider info:";

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields)
        {
            if (field.isAnnotationPresent(FruitName.class))
            {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                strFruitName = strFruitName + fruitName.value();
                System.out.println(strFruitName);
            }else if (field.isAnnotationPresent(FruitColor.class))
            {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                strFruitColor = strFruitColor + fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            }else if (field.isAnnotationPresent(FruitProvider.class))
            {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                strFruitProvider = " provider id："+fruitProvider.id()+" provider name："+fruitProvider.name()+" provider addr："+fruitProvider.address();
                System.out.println(strFruitProvider);
            }
        }
    }
}
