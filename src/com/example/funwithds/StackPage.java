package com.example.funwithds;

import android.os.Bundle;
import android.app.Activity;

public class StackPage extends Activity {

	canvasLayout canvas;
	
    @Override
    
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        canvas=new canvasLayout(this);
        setContentView(canvas);
    }
    
 
    
    
}
