package com.ziplinegames.moai;

import java.io.InputStreamReader;

import com.eclipsesource.json.JsonObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import cn.ultralisk.gameapp.GuoBaoTeGong.R;

public class LogoActivity extends Activity {
	
	private static String gameActivity = "";
	private static JsonObject sConfigJsonObject = null;
	private static Class<?> startActivity = null;
	
	public void initStartActivity(){
		
		try {

			InputStreamReader inputReader = new InputStreamReader(this.getResources().getAssets().open(CommonBaseSdk.configFileName), "GBK");
			
			sConfigJsonObject = JsonObject.readFrom(inputReader);
			gameActivity = sConfigJsonObject.get("mainActivity").asString();
			startActivity = Class.forName(gameActivity);

		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		 
		super.onCreate(savedInstanceState);

		Log.d("logoActivity","运营商信息::"+CommonTool.getProvidersName(this));
		
		initStartActivity();
		mainThreadLooper();
	}
	
	public void mainThreadLooper() {
		new Handler(Looper.getMainLooper()).post(new Runnable() {
			@Override
			public void run() {
		
				try {
					Intent intent = new Intent();
					intent.setClass(LogoActivity.this, startActivity);
					startActivity(intent);
					finish();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//getMenuInflater().inflate(R.menu.logo, menu);
		return true;
	}

}
