package com.sutao.behavior.template;

public abstract class Template {
	public void templateMethod()
	{
		primitiveMethod1();
		primitiveMethod2();
	}
	public abstract void primitiveMethod1();
	public abstract void primitiveMethod2();
}
