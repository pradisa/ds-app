package com.example.funwithds;

import java.util.ArrayList;
import java.util.HashMap;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HashcanvasLayout extends View 
{
	int c,h,i=-1;
	ShapeDrawable shape;
	TextDrawable text;
	boolean occured;
	
	HashMap<Integer,ArrayList<Integer>> array;
	
	@SuppressLint("UseSparseArrays")
	public HashcanvasLayout(Context context)
	{
		super(context);
		array=new HashMap<Integer,ArrayList<Integer>>();
		occured=false;
		for(int i=0;i<7;i++)
		{
			array.put(i, new ArrayList<Integer>());
			array.get(i).add(0);
		}
	}
	
	public void onDraw(Canvas canvas)
	{
		c=canvas.getWidth();
		h=canvas.getHeight();
		occured=false;
		
		
		shape=new ShapeDrawable(new RectShape()); 
		shape.getPaint().setColor(Color.DKGRAY);  // 6
		shape.setBounds(c/8,h-150 , c/2, h-100);
	    shape.draw(canvas);
	    
	    shape.getPaint().setColor(Color.GRAY);  //5
		shape.setBounds(c/8,h-200 , c/2, h-150);
	    shape.draw(canvas);
	    
	    shape.getPaint().setColor(Color.DKGRAY);  //4
		shape.setBounds(c/8,h-250 , c/2, h-200);
	    shape.draw(canvas);
	    
	    shape.getPaint().setColor(Color.GRAY); //3
		shape.setBounds(c/8,h-300 , c/2, h-250);
	    shape.draw(canvas);
	    
	    shape.getPaint().setColor(Color.DKGRAY); //2
		shape.setBounds(c/8,h-350 , c/2, h-300);
	    shape.draw(canvas);

	    shape.getPaint().setColor(Color.GRAY); //1
		shape.setBounds(c/8,h-400 , c/2, h-350);
	    shape.draw(canvas);
	    
	    shape.getPaint().setColor(Color.DKGRAY); //0
		shape.setBounds(c/8,h-450 , c/2, h-400);
	    shape.draw(canvas);
	    
	   // shape.getPaint().setColor(Color.BLACK);
	    if(!array.isEmpty()) 
	    {
	    	for(int i=0;i<7;i++)
	    	{
	    			ArrayList<Integer> a=array.get(i);
	    			for(int j=1;j<a.size();j++)
	    			{
	    				if(a.get(j)!=0)
	    				{
	    					text=new TextDrawable(a.get(j).toString());
	    					text.draw(canvas, ((c/8)+10)+((j-1)*30), (h-425)+(i*50), Color.RED);
	    				}
	    			}
	    			//text=new TextDrawable(a.get(0).toString());
					//text.draw(canvas, ((c/8)+10), (h-425)+(i*50), Color.RED);
	    	}
	    }
	    
	    
	    shape.getPaint().setColor(Color.BLACK); // Input button
		shape.setBounds(c-120,h-400 , c-30, h-350);
	    shape.draw(canvas);
	    
	    shape.getPaint().setColor(Color.BLACK); // Delete button
		shape.setBounds(c-120,h-300 , c-30, h-250);
	    shape.draw(canvas);
	    
	    text= new TextDrawable("Input");
	    text.draw(canvas, c-100, h-365, Color.CYAN);
	    
	    text= new TextDrawable("Delete");
	    text.draw(canvas, c-100, h-265, Color.CYAN);
	    
	    text= new TextDrawable("0");
	    text.draw(canvas, c/24, h-420, Color.BLACK);
	    
	    text= new TextDrawable("1");
	    text.draw(canvas, c/24, h-370, Color.BLACK);
	    
	    text= new TextDrawable("2");
	    text.draw(canvas, c/24, h-320, Color.BLACK);
	    
	    text= new TextDrawable("3");
	    text.draw(canvas, c/24, h-270, Color.BLACK);
	    
	    text= new TextDrawable("4");
	    text.draw(canvas, c/24, h-220, Color.BLACK);
	    
	    text= new TextDrawable("5");
	    text.draw(canvas, c/24, h-170, Color.BLACK);
	    
	    text= new TextDrawable("6");
	    text.draw(canvas, c/24, h-120, Color.BLACK);
	    
	    invalidate();
	}
	public boolean onTouchEvent(MotionEvent event)
	{
      int eventAction=event.getAction();
		
		switch(eventAction)
		{
		case MotionEvent.ACTION_DOWN:
		float xPos=event.getX(),yPos=event.getY();
		if((xPos>= (c-120)) && (xPos<= (c-30)))
		{
			if((yPos>= (h-400)) && (yPos<= (h-350)))
			{
				AlertDialog.Builder alert = new AlertDialog.Builder(this.getContext());

				alert.setTitle("Input");
				alert.setMessage("Enter the number to be inserted:");

				final EditText input = new EditText(this.getContext());
				alert.setView(input);

				alert.setPositiveButton("Insert", new DialogInterface.OnClickListener()
				{
					@SuppressLint("UseValueOf")
					public void onClick(DialogInterface dialog, int whichButton)
					{
						Integer ins=new Integer(0);
						boolean t=true;
						String value = input.getText().toString();
						try
						{
							ins=Integer.parseInt(value);
						}
						catch(Exception ex)
						{
							Toast msg=Toast.makeText(HashcanvasLayout.this.getContext(), "Enter a proper number", Toast.LENGTH_SHORT);
							msg.show();
							t=false;
						}
						if(t)
						{
								Toast msg=Toast.makeText(HashcanvasLayout.this.getContext(), ins+" inserted", Toast.LENGTH_SHORT);
								msg.show();
								Integer key=new Integer(ins%7);
								ArrayList<Integer> a=array.get(key);
								int num=a.get(0);
								a.add(num+1,ins);
								a.set(0, num+1);
						}
					}});

				alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() 
				{
					public void onClick(DialogInterface dialog, int whichButton) 
					{
					}});

				alert.show();
			}
			else
			{
				if((yPos>= (h-300)) && (yPos<= (h-250)))
				{
					AlertDialog.Builder alert = new AlertDialog.Builder(this.getContext());

					alert.setTitle("Delete");
					alert.setMessage("Enter the number to be deleted:");

					final EditText input = new EditText(this.getContext());
					alert.setView(input);

					alert.setPositiveButton("Delete", new DialogInterface.OnClickListener()
					{
						@SuppressLint("UseValueOf")
						public void onClick(DialogInterface dialog, int whichButton)
						{
							Integer ins=new Integer(0);
							boolean t=true;
							String value = input.getText().toString();
							try
							{
								ins=Integer.parseInt(value);
							}
							catch(Exception ex)
							{
								Toast msg=Toast.makeText(HashcanvasLayout.this.getContext(), "Enter a proper number", Toast.LENGTH_SHORT);
								msg.show();
								t=false;
							}
							if(t)
							{
								Integer key=ins%7;
								ArrayList<Integer> a=array.get(key);
								if(a.contains(ins))
								{
									Toast msg=Toast.makeText(HashcanvasLayout.this.getContext(), ins+" deleted", Toast.LENGTH_SHORT);
									msg.show();
									//Integer key=ins%7;
									//ArrayList<Integer> a=array.get(key);
									int num=a.get(0);
									a.remove(ins);
									a.set(0, num-1);
								}
								else
								{
									Toast msg=Toast.makeText(HashcanvasLayout.this.getContext(), "Doesn't exist", Toast.LENGTH_SHORT);
									msg.show();
								}
							}
						}});

					alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() 
					{
						public void onClick(DialogInterface dialog, int whichButton) 
						{
						}});

					alert.show();
				
			}
		}
		break;
		}
		}
		return true;
	}
}