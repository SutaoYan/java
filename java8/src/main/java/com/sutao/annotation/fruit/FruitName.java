package com.sutao.annotation.fruit;

import java.lang.String;
import java.lang.annotation.ElementType;import java.lang.annotation.Retention;import java.lang.annotation.RetentionPolicy;import java.lang.annotation.Target;

/**
 * Created by yansutao on 9/11/16.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitName {

    String value() default "";
}
