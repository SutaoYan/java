package com.sutao.concurrency;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UseExecutors {
  public static void main(String[] args) {
    List<MyRunnable> runnables = Stream.iterate(0, n -> n + 1)
            .map(MyRunnable::new)
            .limit(10)
            .collect(Collectors.toList());

    new Test();
    ExecutorService service = Executors.newCachedThreadPool();

    for(Runnable runnable : runnables) {
      Future<?> future = service.submit(runnable);
      try {
        Object o = future.get();
        System.out.println(o);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      } catch (ExecutionException e) {
        throw new RuntimeException(e);
      }

    }

//    service.shutdown();
  }

  private static class Test {

  }
}
