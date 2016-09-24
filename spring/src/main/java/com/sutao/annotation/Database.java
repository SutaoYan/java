package com.sutao.annotation;

import com.sutao.Service;
import org.springframework.stereotype.Component;

@Component
public class Database implements Service {
	@Override
	public String name() {
		return "Database MySQL";
	}

	@Override
	public void run() {
		System.out.println("Database is running");
	}

	@Override
	public void stop() {
		System.out.println("Database is stopped");
	}
}