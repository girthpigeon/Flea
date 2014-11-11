package com.app.flea.Activities;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;
import com.app.flea.R;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.util.Log;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.util.List;
import java.util.Arrays;


public class LoginActivity extends Activity {
	
	private Dialog progressDialog;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		setup();
	}

	public void setup()
	{
		Button clickButton = (Button) findViewById(R.id.loginButton);
		clickButton.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {

				loginClicked();
				//LoginAsyncTask startLogin = new LoginAsyncTask();
				//startLogin.execute();
			}
		});

		ParseUser currentUser = ParseUser.getCurrentUser();
		if ((currentUser != null) && ParseFacebookUtils.isLinked(currentUser))
		{
			//already logged in
		}
	}

	public void loginClicked()
	{
		LoginActivity.this.progressDialog = 
				ProgressDialog.show(LoginActivity.this, "", "Logging in...", true);
		
		List<String> permissions = Arrays.asList( "user_friends", "user_birthday", "email");
		ParseFacebookUtils.logIn(permissions, this, new LogInCallback() {

			@Override
			public void done(ParseUser user, ParseException err) {
				LoginActivity.this.progressDialog.dismiss();
				if (user == null) {
					Log.d("login",
							"Uh oh. The user cancelled the Facebook login.");
				} else if (user.isNew()) {
					Log.d("login",
							"User signed up and logged in through Facebook!");
					//showUserDetailsActivity();
				} else {
					Log.d("login",
							"User logged in through Facebook!");
					//showUserDetailsActivity();
				}
			}
		});
	}
	
	public class LoginAsyncTask extends AsyncTask<Void, Void, String> {
		 
		  @Override protected String doInBackground(Void... params) {
			  loginClicked();
			  return null;  
			  
		  }
		 
		  @Override protected void onPostExecute(String result) {
			  
		  }
		}
}
