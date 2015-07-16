package com.ziplinegames.moai;

import com.unicom.dcLoader.Utils;
import com.unicom.dcLoader.Utils.UnipayPayResultListener;

import android.app.Application;

public class MyApplication extends Application {
	
	public void onCreate(){
		super.onCreate();
		Utils.getInstances().initSDK(this, new UnipayPayResultListener(){

			@Override
			public void PayResult(String arg0, int arg1, int arg2, String arg3) {
				// TODO Auto-generated method stub
				
			}});
	}
//	public static int caocao(int pram){
//		return pram;
//		
//	}

}
