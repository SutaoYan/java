package com.sutao.struct.bridge;

public class RectangleShape extends Shape {

	public RectangleShape(IPaint imp)
	{
		super(imp);
	}

	@Override
	public void draw() {
		System.out.println("draw rectangle");
		imp.paint();
	}

}
