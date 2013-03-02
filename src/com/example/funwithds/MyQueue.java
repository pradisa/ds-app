package com.example.funwithds;



public class MyQueue
{
	public int front,rear,size,start;
	public Integer[] elements=new Integer[5];
	
	MyQueue()
	{	
		start=1;
		front=rear=-1;
		size=5;
	}
	
	public boolean enque()
	{
		if((rear-front)<(size-1))
		{
			rear++;
			elements[rear]=start;
			start++;
			if(front==-1)
				front++;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int deque()
	{
		if(front>-1)
		{
			int ret=elements[front];
			front++;
			if(front>rear)
			{
				front=rear=-1;
			}
			if(front!=-1)
			{
				for(int i=front;i<=rear;i++)
				{
					elements[i-1]=elements[i];
				}
				front--;
				rear--;
			}
			return ret;
		}
		else
		{
			return -1;
		}
	}
}
