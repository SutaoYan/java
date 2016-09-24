package com.sutao.annotation;

import com.sutao.Service;
import org.springframework.stereotype.Component;

@Component
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