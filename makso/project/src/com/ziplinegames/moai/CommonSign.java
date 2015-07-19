package com.ziplinegames.moai;

import java.util.Date;

import android.util.Log;

public class CommonSign {

	static {System.loadLibrary("com_ziplinegames_moai_CommonSign");  }
	
	
	 public static native void validateSign(String msg);
	 
	 public static void outputString(String msg){
		 Log.d("soTest",msg);
		 return ; 
	 }

	 public static void Destory(){

	 }

}

