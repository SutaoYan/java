package com.sutao.annotation.events;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextStartEventHandler implements ApplicationListener<ContextStartedEvent> {
	@Override
	public void onApplicationEvent(ContextStartedEvent contextStartEvent) {
		System.out.println("The ApplicationContext is started on the ConfigurableApplicationContext interface");
	}
}
