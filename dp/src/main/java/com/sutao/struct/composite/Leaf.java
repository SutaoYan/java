package com.sutao.struct.composite;

public class Leaf extends Component {
	
	public Leaf(String name)
	{
		super(name);
	}
	
	@Override
	public void operation() {
		// TODO Auto-generated method stub
		System.out.println(m_strName);
	}

}
