package com.sutao.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// We will retrieve beans from Spring container here

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		App app = context.getBean("app", App.class);
		app.setName("app1");
		System.out.println(app.toString());
		app=null;

		app = context.getBean("app", App.class);
		System.out.println(app);

		((ClassPathXmlApplicationContext) context).close();
	}
}