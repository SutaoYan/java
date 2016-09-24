package com.sutao.xml;

import com.sutao.Service;

public class Logger implements Service {
	@Override
	public String name() {
		return "Logger X";
	}

	@Override
	public void run() {
		System.out.println("Logger is ready");
	}

	@Override
	public void stop() {
		System.out.println("Logger is stopped");
	}
}