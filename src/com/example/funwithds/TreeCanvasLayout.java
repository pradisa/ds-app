package com.example.funwithds;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TreeCanvasLayout extends View 
{
	BinarySearchTree bst;
	Node currNode;
	ShapeDrawable shape;
	TextDrawable text;
	int c,h;
	Paint paint;
	boolean show=true;
	public TreeCanvasLayout(Context context)
	{
		super(context);
		paint=new Paint();
		bst=new BinarySearchTree();
		currNode=bst.root;
	}
	
	public void onDraw(Canvas canvas)
	{
		c=canvas.getWidth();
		h=canvas.getHeight();
	   
	    paint.setStrokeWidth(3);
	    
	    shape=new ShapeDrawable(new RectShape());
	    shape.setBounds(((c/8)-10),(3*h/4),(c/2)-10,( (3*h/4)+50));
	    shape.draw(canvas);
	    
	    shape.setBounds(((c/2)+10),(3*h/4),(7*c/8)+10,( (3*h/4)+50));
	    shape.draw(canvas);
	    if(show)
	    {
	    	currNode=bst.root;
	    }
	    if(currNode!=null)
	    {
		    canvas.drawCircle(c/2, h/8, 26, paint);
	    	if(currNode.getLeftChild()!=null)
	    	{
	    		canvas.drawLine(c/2, h/8, c/4,h/3, paint);
	    		canvas.drawCircle(c/4, h/3, 26, paint);
	    		if(currNode.getLeftChild().getLeftChild()!=null)
	    		{
	    			canvas.drawLine(c/4, h/3, c/8,(h/2)+50, paint);
	    			canvas.drawCircle(c/8, (h/2)+50, 26, paint);
	    			text=new TextDrawable(currNode.getLeftChild().getLeftChild().getKey().toString());
		    		text.draw(canvas, (c/8)-10, (h/2)+55, Color.RED);
	    		}
	    		if(currNode.getLeftChild().getRightChild()!=null)
	    		{
	    			canvas.drawLine(c/4, h/3, (c/4)+50,(h/2)+50, paint);
	    			canvas.drawCircle((c/4)+50, (h/2)+50, 26, paint);
	    			text=new TextDrawable(currNode.getLeftChild().getRightChild().getKey().toString());
		    		text.draw(canvas, (c/4)+40, (h/2)+55, Color.RED);
	    		}
	    		text=new TextDrawable(currNode.getLeftChild().getKey().toString());
	    		text.draw(canvas, (c/4)-10, (h/3)+10, Color.RED);
	    	}
	    	if(currNode.getRightChild()!=null)
	    	{
	    		canvas.drawLine(c/2, h/8, c-100,h/3, paint);
	    		canvas.drawCircle(c-100, h/3, 26, paint);
	    		if(currNode.getRightChild().getLeftChild()!=null)
	    		{
	    			canvas.drawLine(c-100, h/3, (c/2)+30,(h/2)+50, paint);
	    			canvas.drawCircle((c/2)+30, (h/2)+50, 26, paint);
	    			text=new TextDrawable(currNode.getRightChild().getLeftChild().getKey().toString());
		    		text.draw(canvas, (c/2)+20, (h/2)+55, Color.RED);
	    		}
	    		if(currNode.getRightChild().getRightChild()!=null)
	    		{
	    			canvas.drawLine(c-100, h/3, c-50,(h/2)+50, paint);
	    			canvas.drawCircle(c-50, (h/2)+50, 26, paint);
	    			text=new TextDrawable(currNode.getRightChild().getRightChild().getKey().toString());
		    		text.draw(canvas, c-60, (h/2)+55, Color.RED);
	    		}
	    		text=new TextDrawable(currNode.getRightChild().getKey().toString());
	    		text.draw(canvas, c-110, (h/3)+10, Color.RED);
	    	}
	    	text=new TextDrawable(currNode.getKey().toString());
	    	text.draw(canvas, (c/2)-10, (h/8)+10, Color.RED);
	    }
	    
	    
	    text=new TextDrawable("INSERT");
	    text.draw(canvas, (c/8)+10, (3*h/4)+35, Color.RED);
	    
	    text=new TextDrawable("DELETE");
	    text.draw(canvas,(c/2)+30,(3*h/4)+35,Color.RED);
	    
	   if( (currNode!=null) && (currNode.getParent()!=null) )
	   {
		shape=new ShapeDrawable(new RectShape());
		shape.setBounds(c/8, (h/25), (c/3), (h/6));
		 shape.getPaint().setColor(Color.WHITE);
		shape.draw(canvas);
		
		text=new TextDrawable("UP");
		text.draw(canvas, c/5,h/8 , Color.RED);
	   }
	    
		paint.setColor(Color.BLACK);
	    invalidate();
	}
	@SuppressLint("UseValueOf")
	public boolean onTouchEvent(MotionEvent event)
	{
		int eventAction=event.getAction();
		
		switch(eventAction)
		{
		case MotionEvent.ACTION_DOWN:
			//show=false;
			float xPos=event.getX();
			float yPos=event.getY();
			if((xPos>= (c/2)-26) && (xPos<= (c/2)+26) && (yPos>= (h/8)-26) && (yPos<= (h/8)+26))
			{
			}
			
			if((xPos>= (c/4)-26) && (xPos<= (c/4)+26) && (yPos>= (h/3)-26) && (yPos<= (h/3)+26))
			{
    			if( (currNode!=null) && (currNode.getLeftChild()!=null))
    				currNode=currNode.getLeftChild();
    			show=false;
			}
			
			if((xPos>= c-126) && (xPos<= (c-84)) && (yPos>= (h/3)-26) && (yPos<= (h/3)+26))
			{
    			if( (currNode!=null) && (currNode.getRightChild()!=null) )
    				currNode=currNode.getRightChild();
    			show=false;
			}
			
			if((xPos>= (c/8)-26) && (xPos<= (c/8)+26) && (yPos>= (h/2)+24) && (yPos<= (h/2)+76))
			{
    			if( (currNode!=null) && (currNode.getLeftChild()!=null) && (currNode.getLeftChild().getLeftChild()!=null) )
    				currNode=currNode.getLeftChild().getLeftChild();
    			show=false;
			}
			
			if((xPos>= (c/4)+24) && (xPos<= (c/4)+76) && (yPos>= (h/2)+24) && (yPos<= (h/2)+76))
			{
    			if( (currNode!=null) && (currNode.getLeftChild()!=null) && (currNode.getLeftChild().getRightChild()!=null))
    				currNode=currNode.getLeftChild().getRightChild();
    			show=false;
			}
			
			
			if((xPos>= (c/2)+4) && (xPos<= (c/2)+56) && (yPos>= (h/2)+24) && (yPos<= (h/2)+76))
			{
    			if( (currNode!=null) && (currNode.getRightChild()!=null) && (currNode.getRightChild().getLeftChild()!=null) )
    				currNode=currNode.getRightChild().getLeftChild();
    			show=false;
			}
			
			if((xPos>= c-76) && (xPos<= c-24) && (yPos>= (h/2)+24) && (yPos<= (h/2)+76))
			{
    			if( (currNode!=null) && (currNode.getRightChild()!=null) && (currNode.getRightChild().getRightChild()!=null))
    				currNode=currNode.getRightChild().getRightChild();
    			show=false;
			}
			if((yPos>=(3*h/4)) && (yPos<=( (3*h/4)+ 50) ) )
			{
				if( (xPos>= ((c/8)-10)) && (xPos<=((c/2)-10) ) )
				{	
	    			AlertDialog.Builder alert = new AlertDialog.Builder(this.getContext());

	    			alert.setTitle("INSERT");
	    			alert.setMessage("Enter the number to be inserted:");

	    			final EditText input = new EditText(this.getContext());
	    			alert.setView(input);

	    			alert.setPositiveButton("Insert", new DialogInterface.OnClickListener()
	    			{
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
	    						Toast msg=Toast.makeText(TreeCanvasLayout.this.getContext(), "Enter a proper number", Toast.LENGTH_SHORT);
	    		    			msg.show();
	    		    			t=false;
	    					}
	    					if(t)
	    					{
	    						boolean p=bst.insert(ins);
	    						if(p)
	    						{
	    							Toast msg=Toast.makeText(TreeCanvasLayout.this.getContext(), ins+" inserted", Toast.LENGTH_SHORT);
	    							msg.show();
	    						}
	    						else
	    						{
	    							Toast msg=Toast.makeText(TreeCanvasLayout.this.getContext(), "already exists", Toast.LENGTH_SHORT);
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
				else if( (xPos>= ((c/2)+10) ) && (xPos<= ((7*c/8)+10) ) )
				{
					if(bst.isEmpty())
					{
						Toast msg=Toast.makeText(TreeCanvasLayout.this.getContext(), "Tree is empty", Toast.LENGTH_SHORT);
		    			msg.show();
					}
					else
					{
					AlertDialog.Builder alert = new AlertDialog.Builder(this.getContext());

	    			alert.setTitle("DELETE");
	    			alert.setMessage("Enter the number to be deleted:");

	    			final EditText input = new EditText(this.getContext());
	    			alert.setView(input);

	    			alert.setPositiveButton("Delete", new DialogInterface.OnClickListener()
	    			{
	    				public void onClick(DialogInterface dialog, int whichButton)
	    				{
	    					Integer del=new Integer(0);
	    					boolean t=true;
	    					String value = input.getText().toString();
	    						try
	    						{
	    							del=Integer.parseInt(value);
	    						}catch(Exception ex)
	    						{
	    							Toast msg=Toast.makeText(TreeCanvasLayout.this.getContext(), "Enter a proper number", Toast.LENGTH_SHORT);
		    		    			msg.show();
		    		    			t=false;
	    						}
	    						if(t)
	    						{
	    							boolean p=bst.delete_node(del);
	    							if(p)
	    							{
	    								Toast msg=Toast.makeText(TreeCanvasLayout.this.getContext(), del+" deleted", Toast.LENGTH_SHORT);
	    								msg.show();
	    							}
	    							else
	    							{
	    								Toast msg=Toast.makeText(TreeCanvasLayout.this.getContext(), "doesn't exist", Toast.LENGTH_SHORT);
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
			}
			if((xPos>= (c/8)) && (xPos<= (c/3)) && (yPos>= (h/25)) && (yPos<= (h/6)))
			{
				
				
    			if(currNode.getParent()!=null)
    			{
    			currNode=currNode.getParent();
    			show=false;
			     }
    		}
			
			}
		
		
		return true;
	}
	}

