package com.sutao.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.sutao.annotation")
public class AppConfiguration {

	@Bean
	public App app2() {
		return new App(2,"app2");
	}
}
