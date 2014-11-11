package com.app.flea.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.parse.ParseAnalytics;
import com.app.flea.R;

public class FleaLaunchActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		ParseAnalytics.trackAppOpened(getIntent());
		
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}
	
}
