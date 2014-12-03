package com.app.flea;

import android.app.Application;

import com.parse.Parse;

public class Flea extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Add your initialization code here
        Parse.initialize(this, "XqFGXgA4Y7sDPUFfkNdmWGMi7Vc15ROKZdDI81lK", "Hypp6tkkuYbXA4PlBiMxCtoXBol6C2aQEEJlNqLN");

        //ParseUser.enableAutomaticUser();
        //ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this line.
        //defaultACL.setPublicReadAccess(true);

        //ParseACL.setDefaultACL(defaultACL, true);
    }
}
