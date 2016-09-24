package com.sutao.web.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@RestController
@Configuration
public class Hello {

	@RequestMapping("/")
	public String hello() {
		return "Hello World";
	}
}
