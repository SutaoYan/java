package com.sutao.creator.builder;

//Director role
public class KFCWaiter {
	IMealBuilder m_Builder = null;

	public void setMealBuilder(IMealBuilder builder) {
		m_Builder = builder;
	}
	
	public Meal construct()
	{
		m_Builder.makeDrink();
		m_Builder.makeFood();
		return m_Builder.getMeal();
	}
}
