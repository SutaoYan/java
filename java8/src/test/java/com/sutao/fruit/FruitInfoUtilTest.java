package com.sutao.fruit;

import com.sutao.annotation.fruit.Apple;
import com.sutao.annotation.fruit.FruitInfoUtil;
import junit.framework.TestCase;

/**
 * Created by yansutao on 9/11/16.
 */
public class FruitInfoUtilTest extends TestCase {

    public void testAnnotation()
    {
        FruitInfoUtil.getFruitInfo(Apple.class);
    }
}
