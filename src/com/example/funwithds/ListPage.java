package com.example.funwithds;

import android.app.Activity;
import android.os.Bundle;

public class ListPage extends Activity 
{
	ListCanvasLayout canvas;
	
    @Override
    
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        canvas=new ListCanvasLayout(this);
        setContentView(canvas);
    }
}
