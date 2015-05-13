package com.example.listviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Temp extends Activity {
	
	private TextView view_web;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.temp_activity);
		Bundle bundle = this.getIntent().getExtras();
		view_web = (TextView) findViewById(R.id.view_name);
		view_web.setText(bundle.getString("NAME"));
	}

}
