package com.sutao.annotation;
import com.sutao.Service;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@Component
public class App {
	private int id;
	private String name;

	public App(){
	}

	public App(int id){
		this.id = id;
	}

	public App(int id, String name){
		this.id = id;
		this.name = name;
	}

	@PostConstruct
	public void init(){
		System.out.println("The application has been initialized");
	}

	@PreDestroy
	public void close(){
		System.out.println("Bye bye ...");
	}

	private Service mainService;
	@Autowired
	public App(@Qualifier(value="database")Service main){
		this.mainService = main;
	}

	@Autowired
	private Service[] services;

	private Service mail;
	@Autowired
	@Qualifier("mail")
	public void Main(Service nomail) {
		this.mail = nomail;
		mail.run();
	}

}
