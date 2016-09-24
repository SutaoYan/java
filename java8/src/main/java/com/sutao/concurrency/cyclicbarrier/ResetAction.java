package com.sutao.concurrency.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class ResetAction extends Thread {

	private CyclicBarrier cb;

	public ResetAction() {
		setName("ResetAction");
	}

	public void setCyclicBarrier(CyclicBarrier cb) {
		this.cb = cb;
	}

	public void run() {
		System.out.println("========= ResetAction start =========");

		System.out.println("parties: " + cb.getParties() + ", waiting: " + cb.getNumberWaiting());

		System.out.println("========= ResetAction end =========");
	}
}

