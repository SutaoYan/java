package com.sutao.struct.bridge;

public abstract class Shape {
	IPaint imp;
	public Shape(IPaint imp) {
		this.imp = imp;
	}

	abstract public void draw();
}
