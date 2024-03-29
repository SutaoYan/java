package com.sutao.concurrency.volatiletest;

public class VolatileTest extends  Thread{
	private boolean isRunning = true;
	public boolean isRunning(){
		return isRunning;
	}
	public void setRunning(boolean isRunning){
		this.isRunning= isRunning;
	}
	public void run(){
		System.out.println("进入了run...............");
		while (isRunning){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

//			Thread.yield();
		}
		System.out.println("isRunning的值被修改为为false,线程将被停止了");
	}
	public static void main(String[] args) throws InterruptedException {
		VolatileTest volatileThread = new VolatileTest();
		volatileThread.start();
		Thread.sleep(1000);
		volatileThread.setRunning(false);   //停止线程
	}
}