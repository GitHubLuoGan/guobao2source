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
		if(CommonTool.cardType>CommonTool.CardType_NO){
			
			CommonBaseSdk.configFileName=String.format("cConfig_%d.json", 1);
			initStartActivity();
			
			if(CommonTool.cardType==CommonTool.CardType_YD){//移动
				//logoImage.setImageResource(R.drawable.logo_1);
				onLoding_YD(savedInstanceState);;
			}
			else if(CommonTool.cardType==CommonTool.CardType_LT){//联通
				onLoding_YD(savedInstanceState);
				 
			}
			else if(CommonTool.cardType==CommonTool.CardType_DX){//电信
				onLoding_YD(savedInstanceState);
			}else
			{
				CommonBaseSdk.configFileName=String.format("cConfig_%d.json", 1);
				initStartActivity();
				onLoding_YD(savedInstanceState);
				
			}
			 
		}else{
				CommonBaseSdk.configFileName=String.format("cConfig_%d.json", 1);
				initStartActivity();
				onLoding_YD(savedInstanceState);
		}
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
	
	
void onLoding_YD(Bundle savedInstanceState){

		// 取消标题
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 取消状态栏
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.logo);
		ImageView logoImage = (ImageView) this.findViewById(R.id.logo); 
		logoImage.setImageResource(R.drawable.logo_1);
		AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
		alphaAnimation.setDuration(3000);
		logoImage.startAnimation(alphaAnimation);
		alphaAnimation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				  try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   
				
				
				mainThreadLooper();
					
			}
		});
	}
	
void onLoding_LT(Bundle savedInstanceState){
	
	// 取消标题
	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	// 取消状态栏
	this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
			WindowManager.LayoutParams.FLAG_FULLSCREEN);
	//setContentView(R.layout.logo);
	mainThreadLooper();
}

void onLoding_DX(Bundle savedInstanceState){

	// 取消标题
	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	// 取消状态栏
	this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
			WindowManager.LayoutParams.FLAG_FULLSCREEN);
	setContentView(R.layout.logo);
	ImageView logoImage = (ImageView) this.findViewById(R.id.logo); 
	logoImage.setImageResource(R.drawable.logo_3);
	AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
	alphaAnimation.setDuration(3000);
	logoImage.startAnimation(alphaAnimation);
	alphaAnimation.setAnimationListener(new AnimationListener() {

		@Override
		public void onAnimationStart(Animation animation) {

		}

		@Override
		public void onAnimationRepeat(Animation animation) {

		}

		@Override
		public void onAnimationEnd(Animation animation) {
			  try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
			mainThreadLooper();
		}
	});
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//getMenuInflater().inflate(R.menu.logo, menu);
		return true;
	}

}
