package com.example.funwithds;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FirstActivity extends Activity implements OnClickListener {

	Button enter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		enter=(Button)findViewById(R.id.button1);
		enter.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
			case R.id.button1:
			{
				Intent i=new Intent(FirstActivity.this,MainActivity.class);
				startActivity(i);
			}
			break;
		
		}
	}
}
	


