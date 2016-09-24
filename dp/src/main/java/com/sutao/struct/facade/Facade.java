package com.sutao.struct.facade;

public class Facade {
	Subsystem1 m_s1 = new Subsystem1();
	Subsystem2 m_s2 = new Subsystem2();

	public void OperationWrapper()
	{
		m_s1.operation();
		m_s2.operation();
	}
}
