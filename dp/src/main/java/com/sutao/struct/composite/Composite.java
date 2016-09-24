package com.sutao.struct.composite;

import java.util.ArrayList;


public class Composite extends Component {
	private ArrayList<Component> m_Children = new ArrayList<Component>();
	public Composite(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void operation() {
		// TODO Auto-generated method stub
		System.out.println(m_strName +" begin");
		for(Component c:m_Children)
		{
			c.operation();
		}
		
		System.out.println(m_strName+" end.");
	}
	
	public void AddChild(Component c)
	{
		m_Children.add(c);
	}
	public void RemoveChild(Component c)
	{
		m_Children.remove(c);
	}
	public Component GetChild(int index)
	{
		return m_Children.get(index);
	}
}
