package com.sutao.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Worker extends Thread {

	private static int WOKER_ID = 0;

	private CyclicBarrier cb;

	public Worker(CyclicBarrier cb){
		this.cb = cb;
		setName("Worker-"+(WOKER_ID++));
	}

	public void run(){
		try {
			System.out.println(Thread.currentThread().getName()+" is working...");
			cb.await();
			System.out.println(Thread.currentThread().getName()+" finished work.");
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}

