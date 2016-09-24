package com.sutao.behavior.command;

import java.lang.reflect.Method;

public class Commander {
	Object m_Receiver;
	String m_strMethod;
	Object[] m_vArgs;
	public Commander(Object r, String method, Object [] args)
	{
		m_Receiver = r;
		m_strMethod = method;
		m_vArgs = args;
	}
	public void execution()
	{
		Class[] cargs = new Class[m_vArgs.length];
		for(int i = 0; i< cargs.length; i++)
		{
			cargs[i] = m_vArgs[i].getClass();
		}
		try {
			Method m = m_Receiver.getClass().getDeclaredMethod(m_strMethod, cargs);
			m.invoke(m_Receiver, m_vArgs);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
