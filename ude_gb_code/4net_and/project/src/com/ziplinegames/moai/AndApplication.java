package com.ziplinegames.moai;


import android.app.Application;
import android.util.Log;

public class AndApplication extends Application {
	
	public void onCreate(){
		super.onCreate();
		System.loadLibrary("megjb");
	}
}
