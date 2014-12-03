package com.app.flea.Activities;

import com.parse.SignUpCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.app.flea.R;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

    private Dialog progressDialog;
    private ParseUser currentUser;

    //UI Elements
    private Button loginButton;
    private EditText usernameTextBox;
    private EditText passwordTextBox;
    private EditText passwordMatchTextbox;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        setup();
    }

    public void setup() {
        loginButton = (Button) findViewById(R.id.SignUp_Button);
        usernameTextBox = (EditText) findViewById(R.id.Username_Textbox);
        passwordMatchTextbox = (EditText) findViewById(R.id.PasswordMatch_Textbox);
        passwordTextBox = (EditText) findViewById(R.id.Password_Textbox);

        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentUser != null)
                {
                    //User clicked logout... will be moved to make actually work
                    ParseUser.logOut();
                    currentUser = null;
                }
                else
                {
                    ParseUser user = new ParseUser();
                    user.setUsername(usernameTextBox.getText().toString());
                    user.setPassword(passwordTextBox.getText().toString());
                    user.signUpInBackground(new SignUpCallback() {

                        @Override
                        public void done(ParseException e) {
                            if (e != null)
                            {
                                //we are all good
                            }
                            else
                            {
                                //we've got ourselves an error
                            }
                        }
                    });
                }
            }
        });

        /* login
        loginButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                if (currentUser != null)
                {
                    //User clicked logout... will be moved to make actually work
                    ParseUser.logOut();
                    currentUser = null;
                }
                else
                {
                    ParseUser.logInInBackground(usernameTextBox.getText().toString(),passwordTextBox.getText().toString(), new LogInCallback() {
                        @Override
            			public void done(ParseUser user, ParseException e) {
                            if (e != null)
                            {
                                //we are all good
                            }
                            else
                            {
                                //we've got ourselves an error
                            }
                        }
                    });
                }
            }
        });*/

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null)
        {

        }
    }

    public void loginClicked() {

    }
}
