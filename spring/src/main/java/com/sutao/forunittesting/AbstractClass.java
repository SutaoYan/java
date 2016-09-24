package com.sutao.forunittesting;

public abstract class AbstractClass {
	final private String key;

	protected  AbstractClass(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
