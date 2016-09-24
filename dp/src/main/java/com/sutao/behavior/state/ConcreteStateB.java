package com.sutao.behavior.state;

public class ConcreteStateB extends State {

	public ConcreteStateB()
	{
		System.out.println("current state is B.");
	}
	@Override
	public void setState(StateContext con) {
		// TODO Auto-generated method stub
		System.out.println("change to state A");
		con.setState(new ConcreteStateA());
		
	}
}
