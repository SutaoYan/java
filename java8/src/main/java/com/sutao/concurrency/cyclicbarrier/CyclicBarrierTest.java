package com.sutao.concurrency.cyclicbarrier;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	public static void main(String[] args) {

		List<Worker> workers = new LinkedList<>();
		ResetAction ra = new ResetAction();

		CyclicBarrier cb = new CyclicBarrier(3 + 1, ra);
		ra.setCyclicBarrier(cb);

		for (int j = 0; j < 5; j++) {
			cb.reset();
			System.out.println("\n\n\n");
			for (int i = 0; i < 3; i++) {
				Worker w = new Worker(cb);
				workers.add(w);
				w.start();
			}
			try {
				System.out.println("***********main thread waiting**************");
				cb.await();
				System.out.println("***********main thread finish**************");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
