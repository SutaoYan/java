package com.sutao.aop;

public class User {
	private Integer id;
	private String name;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		System.out.println("Id: " + id);
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		System.out.println("Name: " + name );
		return name;
	}

	public void printThrowException(){
		System.out.println("Exception raised");
		throw new IllegalArgumentException();
	}
}