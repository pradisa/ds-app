package com.example.funwithds;

import android.os.Bundle;
import android.app.Activity;

public class HashPage extends Activity {

	HashcanvasLayout canvas;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		canvas=new HashcanvasLayout(this);
		setContentView(canvas);
	}


}
