package com.sutao.concurrency.callables;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class FileLineCounter {
  private Path dir = Paths.get("src", "main", "java", "src/main/java/com.sutao.concurrency");

  public long computerTotalNumberOfLines() {
    long total = 0;
    try {
      total = executeCounter().stream()
              .mapToLong(this::extractValueFromFuture)
              .sum();
    } catch (InterruptedException | IOException e) {
      e.printStackTrace();
    }
    return total;
  }

  private List<Future<Long>> executeCounter ()
        throws InterruptedException, IOException{
    ExecutorService service = Executors.newCachedThreadPool();
    List<Future<Long>> futures = service.invokeAll(getFileLineCounters());
    //if com.sutao.exceptions happen, does shutdown invoke?
    service.shutdown();
    return futures;
  }

  private List<Callable<Long>> getFileLineCounters() throws IOException {
    return Files.list(dir)
            .filter(Files::isRegularFile)
            .map(this::callablePrintingCounter)
            .collect(Collectors.toList());
  }

  private Callable<Long> callableCounter(Path p) {
    return () -> Files.lines(p).count();
  }

  private Callable<Long> callablePrintingCounter(Path p) {
    return () -> {
      long count = Files.lines(p).count();
      System.out.printf("%s has %d lines%n", p, count);
      return count;
    };
  }

  // Future get() throws com.sutao.exceptions, so catch them here
  private <T> T extractValueFromFuture(Future<T> future) {
    T val = null;
    try {
      val = future.get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    return val;
  }

  public static void main(String[] args) {
    FileLineCounter demo = new FileLineCounter();
    System.out.printf("Total number of lines: %d%n",
            demo.computerTotalNumberOfLines());
  }
}
