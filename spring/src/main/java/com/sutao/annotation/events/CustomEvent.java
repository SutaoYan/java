package com.sutao.annotation.events;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {

	public CustomEvent(Object source, String message) {
		super(source);
	}

	public String toString() {
		return "This is a custom event";
	}
}