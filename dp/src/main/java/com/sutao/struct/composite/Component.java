package com.sutao.struct.composite;

public abstract class Component {
	String m_strName="";
	public Component(String name)
	{
		m_strName = name;
	}
	
	abstract public void operation();
}
