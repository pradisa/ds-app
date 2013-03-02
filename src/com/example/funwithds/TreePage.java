package com.example.funwithds;

import android.app.Activity;
import android.os.Bundle;

public class TreePage extends Activity
{
	TreeCanvasLayout canvas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		canvas=new TreeCanvasLayout(this);
		setContentView(canvas);
	}
}
