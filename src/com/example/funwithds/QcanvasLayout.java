package com.example.funwithds;

import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.*;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class QcanvasLayout extends View
{

	TextDrawable enque;
	TextDrawable deque;
	TextDrawable element;
	Paint paint;
	ShapeDrawable shape;
	MyQueue queue;
	int yCoord;
	boolean first=true;

	public QcanvasLayout(Context context) {
		super(context);
		queue=new MyQueue();
		paint=new Paint();
		yCoord=200;
		//thisApp=new MyApp();
	}

	protected void onDraw(Canvas canvas) 
	{
		//canvas.drawBitmap(stackImage, 70, 110, null);
		shape=new ShapeDrawable(new RectShape());
		shape.setBounds(70,55,75,220);
		shape.draw(canvas);
		shape.setBounds(130,55,135,220);
		shape.draw(canvas);
		if(first)
		{
			super.onDraw(canvas);
			canvas.drawColor(Color.WHITE);
			first=false;
		}
		enque=new TextDrawable("ENQUEUE");
		deque=new TextDrawable("DEQUEUE");
		if(queue.front!=-1)
		{
			for(int i=queue.front,yCoord=200;i<=queue.rear;i++,yCoord-=30)
			{
				element=new TextDrawable(queue.elements[i].toString());
				element.draw(canvas,100,yCoord,Color.BLACK);
			}
		}
		shape=new ShapeDrawable(new RectShape());
		shape.setBounds(200, 100, 320, 145);
		shape.draw(canvas);
		shape=new ShapeDrawable(new RectShape());
		shape.setBounds(200,200,320,245);
		shape.draw(canvas);
		//Rect pushRect=new Rect();
		//Rect popRect=new Rect();
		enque.draw(canvas,210,130,Color.WHITE);
		deque.draw(canvas,210,230,Color.WHITE);
		
		invalidate();
	}
	

	public boolean onTouchEvent (MotionEvent event)
	{ 
		int eventaction = event.getAction();
		switch(eventaction)
		{
		case MotionEvent.ACTION_DOWN:
		{
			float xPos = event.getX();
            float yPos = event.getY();
            if( (xPos>=200) && (xPos<=320) )
            {
            	if( (yPos>=100) && (yPos<=145) )
            	{
            		boolean p=queue.enque();
            		if(p)
            		{
            			Toast msg=Toast.makeText(QcanvasLayout.this.getContext(), "enqueue("+queue.elements[queue.rear]+")", Toast.LENGTH_SHORT);
            			msg.show();
            			//yCoord-=20;
            		}
            		else
            		{
            			Toast msg=Toast.makeText(QcanvasLayout.this.getContext(), "Queue Full!!", Toast.LENGTH_SHORT);
            			msg.show();
            		}
            	}
            	else if((yPos>=200) && (yPos<=245))
            	{
            		int p=queue.deque();
            		if(p!=-1)
            		{
            			Toast msg=Toast.makeText(QcanvasLayout.this.getContext(), p+" dequeued", Toast.LENGTH_SHORT);
            			msg.show();
            			//yCoord+=20;
            		}
            		else
            		{
            			Toast msg=Toast.makeText(QcanvasLayout.this.getContext(), "Queue Empty!!", Toast.LENGTH_SHORT);
            			msg.show();
            		}	
            	}
            }
		}
		case MotionEvent.ACTION_UP:
		{
			float xPos = event.getX();
            float yPos = event.getY();
            if( (yPos>=270) && (yPos<=315) )
            {
            	if( (xPos>=95) && (xPos<=165)) 
            	{
            	}
            	else if((xPos>=195) && (xPos<=255))
            	{
            	}
            }
		}
		}
                 return true;
     }
	

}
