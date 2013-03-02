package com.example.funwithds;



public class MyStack 
{
	public int top,size,start;
	public Integer[] elements=new Integer[5];
	
	MyStack()
	{	
		start=1;
		top=-1;
		size=5;
	}
	
	public boolean push()
	{
		if(top<(size-1))
		{
			top++;
			elements[top]=start;
			start++;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int pop()
	{
		if(top>-1)
		{
			top--;
			return elements[top+1];
		}
		else
		{
			return -1;
		}
	}
}
