package com.sutao.behavior.state;

public class ConcreteStateA extends State {
	public ConcreteStateA()
	{
		System.out.println("current state is A.");
	}
	@Override
	public void setState(StateContext con) {
		System.out.println("change to state B");
		// TODO Auto-generated method stub
		con.setState(new ConcreteStateB());
		
	}

}
