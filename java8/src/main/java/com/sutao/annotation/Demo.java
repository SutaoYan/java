package com.sutao.annotation;

@TesterInfo(
    priority = TesterInfo.Priority.HIGH,
    createdBy = "demo",
    tags = {"sales","test" }
)
public class Demo {
    @Test
    void testA() {
      if (true)
        throw new RuntimeException("This test always failed");
    }

    @Test(enabled = false)
    void testB() {
      if (false)
        throw new RuntimeException("This test always passed");
    }

    @Test(enabled = true)
    void testC() {
      if (10 > 1) {
        // do nothing, this test always passed.
      }
    }
}
