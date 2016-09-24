package com.sutao.behavior.state;

public class StateContext {
	private State state;
	public StateContext(State s)
	{
		setState(s);
	}
	public void setState(State s)
	{
		state = s;
	}
	public void operateChangeState()
	{
		state.setState(this);
	}
}
