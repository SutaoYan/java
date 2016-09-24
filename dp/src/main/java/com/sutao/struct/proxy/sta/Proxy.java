package com.sutao.struct.proxy.sta;

public class Proxy implements IProxy {
	IProxy worker = null;
	public Proxy()
	{
		worker = new Stub();
	}

	@Override
	public void operation() {
		// TODO Auto-generated method stub
		System.out.println("before work...");
		worker.operation();
		System.out.println("after work...");
	}

}
