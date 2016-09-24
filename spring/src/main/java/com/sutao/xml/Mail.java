package com.sutao.xml;

import com.sutao.Service;

public class Mail implements Service {
	@Override
	public String name() {
		return "Mail Client";
	}

	@Override
	public void run() {
		System.out.println("Mail is running");
	}

	@Override
	public void stop() {
		System.out.println("Mail is stopped");
	}
}
