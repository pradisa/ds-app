package com.example.funwithds;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity implements OnClickListener
{
	Button stack,queue,list,tree,graph,hash;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		stack=(Button)findViewById(R.id.stackB);
		queue=(Button)findViewById(R.id.queueB);
		list=(Button)findViewById(R.id.listB);
		tree=(Button)findViewById(R.id.treeB);
		hash=(Button)findViewById(R.id.hashB);
		stack.setOnClickListener(this);
		queue.setOnClickListener(this);
		list.setOnClickListener(this);
		tree.setOnClickListener(this);
		hash.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) 
	{
		switch(v.getId())
		{
			case R.id.stackB:
			{
				Intent i=new Intent(MainActivity.this,StackPage.class);
				startActivity(i);
			}
			break;
			case R.id.queueB:
			{
				Intent i=new Intent(MainActivity.this,QueuePage.class);
				startActivity(i);
			}
			break;
			case R.id.listB:
			{
				Intent i=new Intent(MainActivity.this,ListPage.class);
				startActivity(i);
			}
			break;
			case R.id.treeB:
			{
				Intent i=new Intent(MainActivity.this,TreePage.class);
				startActivity(i);
			}
			break;
			case R.id.hashB:
			{
				Intent i=new Intent(MainActivity.this,HashPage.class);
				startActivity(i);
			}
			break;
		}
	}


}
