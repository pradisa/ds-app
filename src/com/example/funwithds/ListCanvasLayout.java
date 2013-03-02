package com.example.funwithds;

import java.util.Iterator;
import java.util.LinkedList;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class ListCanvasLayout extends View
{
	int c,h,numbers,w_start,w_stop;
	TextDrawable atFirst,atLast,removeFirst,removeLast,elements;
	ShapeDrawable shape;
	Paint paint;
	LinkedList<Integer> list=new LinkedList<Integer>();
	Iterator<Integer> i;
	
	
	public ListCanvasLayout(Context context) 
	{
		super(context);
		i=list.iterator();
		paint=new Paint();
		numbers=1;
		w_start=1;
		w_stop=3;
	}
	
	protected void onDraw(Canvas canvas)
	{
		i=list.iterator();
		c=canvas.getWidth();
		h=canvas.getHeight();
		shape=new ShapeDrawable(new RectShape());
		shape.getPaint().setColor(Color.WHITE);
		shape.setBounds(0, 150 , canvas.getWidth(),250);
		shape.draw(canvas);
		paint.setStrokeWidth(3);
		
		paint.setColor(Color.BLACK);
		canvas.drawLine(25,190,5,200, paint);
		canvas.drawLine(5,200,25,210, paint);
		paint.setColor(Color.BLACK);
		canvas.drawLine((canvas.getWidth()-25),190 , (canvas.getWidth()-5) ,200, paint);
		canvas.drawLine((canvas.getWidth()-5), 200,(canvas.getWidth()-25) ,210, paint);
		
		
		atFirst=new TextDrawable("Insert First");
		atLast=new TextDrawable("Insert Last");
		removeFirst=new TextDrawable("Remove First");
		removeLast =new TextDrawable("Remove Last");
		
		shape=new ShapeDrawable(new RectShape());
		shape.setBounds(canvas.getWidth()-240,25,canvas.getWidth()-80, 60);
		shape.draw(canvas);
		
		shape=new ShapeDrawable(new RectShape());
		shape.setBounds(canvas.getWidth()-240, 95, canvas.getWidth()-80, 130);
		shape.draw(canvas);
		
		shape=new ShapeDrawable(new RectShape());
		shape.setBounds(canvas.getWidth()-240, canvas.getHeight()-200, canvas.getWidth()-80, canvas.getHeight()-158);
		shape.draw(canvas);
		
		shape=new ShapeDrawable(new RectShape());
		shape.setBounds(canvas.getWidth()-240, canvas.getHeight()-130, canvas.getWidth()-80, canvas.getHeight()-90);
		shape.draw(canvas);
		
		atFirst.draw(canvas,canvas.getWidth()-220,50,Color.WHITE);
		atLast.draw(canvas,canvas.getWidth()-220,120,Color.WHITE);
		removeFirst.draw(canvas,canvas.getWidth()-230,canvas.getHeight()-170,Color.WHITE);
		removeLast.draw(canvas,canvas.getWidth()-230,canvas.getHeight()-100,Color.WHITE);
		
		shape=new ShapeDrawable(new RectShape());
		shape.getPaint().setColor(Color.BLUE);
		
		
		for(int p=1;p<=list.size();p++)
		{
			if(p<(w_start))
			{
				i.next();
			}
			else if(p>w_stop)
			{
				break;
			}
			else
			{
				shape.setBounds(35,180,105,220);
				shape.draw(canvas);
				elements=new TextDrawable(i.next().toString());
				elements.draw(canvas, 75, 215, Color.BLACK);
				if(i.hasNext())
				{
					shape.setBounds(120,180,190,220);
					shape.draw(canvas);
					paint.setStrokeWidth(8);
					canvas.drawLine(105, 200, 120, 200, paint);
					elements=new TextDrawable(i.next().toString());
					elements.draw(canvas, 160, 215, Color.BLACK);
				}
				if(i.hasNext())
				{
					shape.setBounds(205,180,275,220);
					shape.draw(canvas);
					canvas.drawLine(190, 200, 205, 200, paint);
					elements=new TextDrawable(i.next().toString());
					elements.draw(canvas, 240, 215, Color.BLACK);
				}
				p+=3;
			}
			if(w_start>1)
			{
				canvas.drawLine(10, 200, 35, 200, paint);
			}
			if(w_stop<list.size())
			{
				canvas.drawLine(c-48, 200, c-10, 200, paint);
			}
		}
		
		
		invalidate();
	}
	public boolean onTouchEvent(MotionEvent event)
	{
		
		int eventaction = event.getAction();
		switch(eventaction)
		{
			case MotionEvent.ACTION_DOWN:
			{
				float xPos = event.getX();
				float yPos = event.getY();
				if( (xPos>=(c-240)) && (xPos<=(c-80)) )
					{
						if( (yPos>=25) && (yPos<=60) )
						{
							list.addFirst(numbers);
            				Toast msg=Toast.makeText(ListCanvasLayout.this.getContext(), numbers+" added at first", Toast.LENGTH_SHORT);
            				msg.show();
            				numbers++;
            			}
            			
            	else if((yPos>=95) && (yPos<=130))
            		{
            			list.addLast(numbers);
            			Toast msg=Toast.makeText(ListCanvasLayout.this.getContext(),numbers+" added at last", Toast.LENGTH_SHORT);
            			msg.show();
            			numbers++;
            	            		}
            	else if( (yPos>=(h-200)) && (yPos<=(h-158)) )
				{
            		if(!list.isEmpty())
            		{
            			int p=list.removeFirst();
            			Toast msg=Toast.makeText(ListCanvasLayout.this.getContext(), p+" removed", Toast.LENGTH_SHORT);
            			msg.show();
            		}
            		else
            		{
            			Toast msg=Toast.makeText(ListCanvasLayout.this.getContext(), "List Empty", Toast.LENGTH_SHORT);
            			msg.show();
            		}
    			}
            	else if( (yPos>=(h-130)) && (yPos<=(h-90)) )
				{
            		if(!list.isEmpty())
            		{
            			int p=list.removeLast();
            			Toast msg=Toast.makeText(ListCanvasLayout.this.getContext(), p+" removed", Toast.LENGTH_SHORT);
            			msg.show();
            		}
            		else
            		{
            			Toast msg=Toast.makeText(ListCanvasLayout.this.getContext(), "List Empty", Toast.LENGTH_SHORT);
            			msg.show();
            		}
    			}
            	
            	}
				else if((xPos>=(c-15)) && (xPos<=(c-5)))
				{
					if((yPos>=150)&& (yPos<=250))
					{
						if(w_stop>=list.size())
						{
							Toast msg=Toast.makeText(ListCanvasLayout.this.getContext(), "End of list", Toast.LENGTH_SHORT);
							msg.show();
						}
						else
						{
							w_stop++;
							w_start++;
						}
					}
						
				}
				else if((xPos>=5) && (xPos<=35))
				{
					if((yPos>=150)&& (yPos<=250))
					{
						if(w_start==1)
						{
							Toast msg=Toast.makeText(ListCanvasLayout.this.getContext(), "Start of list", Toast.LENGTH_SHORT);
							msg.show();
						}
						else
						{
							w_stop--;
							w_start--;
						}
					}
						
				}
		
			}
			}
		return true;
	}
}
		
	
       
	
	

