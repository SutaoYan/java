package com.sutao.creator.builder;

public interface IMealBuilder {
	public abstract void makeFood();
	public abstract void makeDrink();
	public Meal getMeal();
}
