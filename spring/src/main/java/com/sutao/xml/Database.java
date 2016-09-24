package com.sutao.xml;

import com.sutao.Service;

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