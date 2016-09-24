package com.sutao.annotation;

import com.sutao.annotation.events.CustomEventPublisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		// We will retrieve beans from Spring container here
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		((AnnotationConfigApplicationContext) context).start();
//		((AnnotationConfigApplicationContext) context).refresh();
		App app = (App) context.getBean("app");
		System.out.println(app);

		App app2 = (App) context.getBean("app2");
		System.out.println(app2);

		CustomEventPublisher publisher = context.getBean(CustomEventPublisher.class);
		publisher.publish();

//		((AnnotationConfigApplicationContext) context).close();
	}
}