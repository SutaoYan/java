package com.sutao.xml;
import com.sutao.Service;
import lombok.Data;

@Data
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
	public void init(){
		System.out.println("The application has been initialized");
	}

	public void close(){
		System.out.println("Bye bye ...");
	}

//	private Service mainService;
//	public App(Service main){
//		this.mainService = main;
//	}

	private Service[] services;
	public App(Service[] services){
		this.services = services;
	}

}
