package com.sutao.behavior.strategy;

public abstract class TemplateStrategy implements IStrategy {
	public void slove()
	{
		start();
		stop();
	}
	abstract public void start();
	abstract public void stop();
}
