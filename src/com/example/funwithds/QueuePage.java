package com.example.funwithds;

import android.os.Bundle;
import android.app.Activity;

public class QueuePage extends Activity {

	QcanvasLayout canvas;
	
    @Override
    
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        canvas=new QcanvasLayout(this);
        setContentView(canvas);
    }
    
 
    
    
}
