package com.example.funwithds;

import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.*;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class canvasLayout extends View
{
	Bitmap stackImage;
	TextDrawable push;
	TextDrawable pop;
	TextDrawable element;
	Paint paint;
	ShapeDrawable shape;
	MyStack stack;
	int yCoord;
	boolean first=true;

	public canvasLayout(Context context) {
		super(context);
		stack=new MyStack();
		stackImage = BitmapFactory.decodeResource(getResources(), R.drawable.stack);
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
		shape.setBounds(75,215,135,220);
		shape.draw(canvas);
		if(first)
		{
			super.onDraw(canvas);
			canvas.drawColor(Color.WHITE);
			first=false;
		}
		push=new TextDrawable("PUSH");
		pop=new TextDrawable("POP");
		for(int i=0,yCoord=200;i<=stack.top;i++,yCoord-=30)
		{
			element=new TextDrawable(stack.elements[i].toString());
			element.draw(canvas,100,yCoord,Color.BLACK);
		}
		shape=new ShapeDrawable(new RectShape());
		shape.setBounds(200, 100, 270, 145);
		shape.draw(canvas);
		shape=new ShapeDrawable(new RectShape());
		shape.setBounds(200,200,270,245);
		shape.draw(canvas);
		//Rect pushRect=new Rect();
		//Rect popRect=new Rect();
		push.draw(canvas,210,130,Color.WHITE);
		pop.draw(canvas,210,230,Color.WHITE);
		
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
            if( (xPos>=200) && (xPos<=270) )
            {
            	if( (yPos>=100) && (yPos<=145) )
            	{
            		boolean p=stack.push();
            		if(p)
            		{
            			Toast msg=Toast.makeText(canvasLayout.this.getContext(), "push("+stack.elements[stack.top]+")", Toast.LENGTH_SHORT);
            			msg.show();
            			//yCoord-=20;
            		}
            		else
            		{
            			Toast msg=Toast.makeText(canvasLayout.this.getContext(), "Stack Overflow!!", Toast.LENGTH_SHORT);
            			msg.show();
            		}
            	}
            	else if((yPos>=200) && (yPos<=245))
            	{
            		int p=stack.pop();
            		if(p!=-1)
            		{
            			Toast msg=Toast.makeText(canvasLayout.this.getContext(), stack.elements[stack.top+1]+" popped", Toast.LENGTH_SHORT);
            			msg.show();
            			//yCoord+=20;
            		}
            		else
            		{
            			Toast msg=Toast.makeText(canvasLayout.this.getContext(), "Stack Underflow!!", Toast.LENGTH_SHORT);
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
