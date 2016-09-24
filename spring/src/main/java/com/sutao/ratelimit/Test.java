package com.sutao.ratelimit;

import com.google.common.util.concurrent.RateLimiter;

import java.time.ZonedDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Test {
	private static RateLimiter rateLimiter = RateLimiter.create(100);
	private static AtomicInteger counter = new AtomicInteger(0);
	// when
	private static  long startTime = ZonedDateTime.now().getSecond();

	public static class TestRunner implements Runnable {

		@Override
		public void run() {
			doSomeLimitedOperation();
		}
	}

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(1000);
		startTime = ZonedDateTime.now().getSecond();

		rateLimiter.setRate(10);
		IntStream.range(0, 1000).forEach(i -> {
			service.execute(new TestRunner());
		});

		try {
			service.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		service.shutdown();

		long elapsedTimeSeconds = ZonedDateTime.now().getSecond() - startTime;
		System.out.println(elapsedTimeSeconds);
	}


	public static void doSomeLimitedOperation () {
		rateLimiter.acquire();
		System.out.println("i am " + counter.incrementAndGet()+" duration "+ (ZonedDateTime.now().getSecond() - startTime));
	}
}
