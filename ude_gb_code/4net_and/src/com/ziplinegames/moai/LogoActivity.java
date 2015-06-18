package com.ziplinegames.moai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.eclipsesource.json.JsonObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import cn.ultralisk.gameapp.GuoBaoTeGong.R;
import cn.cmgame.billing.api.*;

public class LogoActivity extends Activity {
	
	private static String gameActivity = "";
	private static JsonObject sConfigJsonObject = null;
	private static Class<?> startActivity = null;
	
	//cop
	public static Activity _self = null;
	public static String configInfo_1 = "{\"tollgate\":[0], \"gifttype\":4,\"itemstype\":1, \"prob\":[0],\"type\":[0],\"mode\":1,\"sdkid\":1,\"merger\":1}";
	public static String copGameId = "";
	public static String copChannelId = "";
	public static String Ip = "";
	public static String copAddr = "";
	public static int recBuyStyle = 1;
	public static String requestUrl ="http://www.baopiqi.com/api/gift.php?gameid=6&qudao=42&uid=5b92f04bbc41526d&ver=1.0.42&os=android-4.2.2&devices=L39u&ip=182.149.194.45&iccid=89860113881048662744&imsi=460018290507233&ratio=1794x1080";
	public static int MM_And = 2;//cop
	
	/*********************************cop*************************************/
	//获取本机ip
		
		public static String getNetIp() {
			URL infoUrl = null;
			InputStream inStream = null;
			try {
				infoUrl = new URL("http://1111.ip138.com/ic.asp");
				URLConnection connection = infoUrl.openConnection();
			  
				HttpURLConnection httpConnection = (HttpURLConnection)connection;
				int responseCode = httpConnection.getResponseCode();
				if(responseCode == HttpURLConnection.HTTP_OK)
				{
					inStream = httpConnection.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(inStream,"gb2312"));
					StringBuilder strber = new StringBuilder();
					String line = null;
					while ((line = reader.readLine()) != null)
						strber.append(line + "\n");
					inStream.close();
					System.out.println("net-result----->"+strber);
					//从反馈的结果中提取出IP地址
					int start = strber.indexOf("[");
					int end = strber.indexOf("]", start + 1);
					line = strber.substring(start + 1, end);
					return line;
				}
			}
			catch(MalformedURLException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		//获取cop请求串
		public static String getRequestUrl(){
			
			String reseultUrl = "";
			
			try {
				
				
				copGameId = CommonBaseSdk.GetJsonVal(sConfigJsonObject,"copGameId","53");
				copChannelId = CommonBaseSdk.GetJsonVal(sConfigJsonObject,"copChannelId","42");
				Ip = getNetIp();
				copAddr = CommonBaseSdk.GetJsonVal(sConfigJsonObject,"copAddr","http://www.baopiqi.com/api/");
				String deviceCode = Secure.getString(_self.getBaseContext().getContentResolver(), Secure.ANDROID_ID);
				
				Log.d("commonSdk", "requestUrl----->copGameId" + copGameId);
				Log.d("commonSdk", "requestUrl----->copChannelId" + copChannelId);
				Log.d("commonSdk", "requestUrl----->Ip" + Ip);
				Log.d("commonSdk", "requestUrl----->copAddr" + copAddr);
				Log.d("commonSdk", "requestUrl----->deviceCode" + deviceCode);
				
				
				TelephonyManager mTelephonyMgr = (TelephonyManager)_self.getSystemService(Context.TELEPHONY_SERVICE);
				String imsi = mTelephonyMgr.getSubscriberId();
				String iccid = mTelephonyMgr.getSimSerialNumber();
				String version = "";
				
				Log.d("commonSdk", "requestUrl----->imsi" + imsi);
				Log.d("commonSdk", "requestUrl----->iccid" + iccid);
				
			
				 try {
				        PackageManager manager = _self.getPackageManager();
				        PackageInfo info = manager.getPackageInfo(_self.getPackageName(), 0);
				        version = info.versionName;
				        
				    } catch (Exception e) {
				        e.printStackTrace();
				    }
				    
				    Log.d("commonSdk", "requestUrl----->version" + version);
				    
				    String device =  android.os.Build.MODEL;
				    device = device.replace(' ', '_');
				    
				    Log.d("commonSdk", "requestUrl----->device" + device);
				    
				    Display mDisplay = _self.getWindowManager().getDefaultDisplay();
				    String W = String.valueOf(mDisplay.getWidth());
				    String H = String.valueOf(mDisplay.getHeight());
				    
				    String ratio = W + 'x' +H;
				    
				    Log.d("commonSdk", "requestUrl----->ratio" + ratio);

				   
				    reseultUrl = copAddr + "gift.php?" + "gameid=" +copGameId + "&qudao=" +copChannelId + "&uid=" +deviceCode + "&ver=" +version;
				    reseultUrl = reseultUrl + "&os=" +"android-"+android.os.Build.VERSION.RELEASE  + "&devices=" +device +"&ip=" +Ip +"&iccid=" +iccid + "&imsi=" + imsi +"&ratio=" +ratio ;
				    
				 
				    Log.d("commonSdk","copRequestUrl------->" + reseultUrl);
			} catch (Exception e) {
				e.printStackTrace();
			} 	
			return reseultUrl;
		}
		
		public void doCop(){
			
			requestUrl = getRequestUrl();
			Log.d("commonSdk", "requestUrl----->" + requestUrl);
			
	 		String configInfo = sendGet(requestUrl);
	 		configInfo = configInfo.replace(":,", ":1,");
	 		
	 		JsonObject dataJson;
	 		try{
	 			dataJson = JsonObject.readFrom(configInfo);
	 		    
	 		}catch(Exception e){
	 			dataJson = JsonObject.readFrom(configInfo_1);
	 		}
		
	 		Log.d("commonSdk","copDataRespon------->" + dataJson.toString());
	 		MM_And = CommonBaseSdk.GetJsonValInt(dataJson, "sdkid", 1);
	 		
	 		recBuyStyle = CommonBaseSdk.GetJsonValInt(dataJson, "gifttype", 1);
	 		
	 		if(recBuyStyle > 10){
	 		recBuyStyle = recBuyStyle%10 + 1;
	 		}
	 		else { recBuyStyle = recBuyStyle/10 + 1; }
	 		
	 		Log.d("logoActivity","recBuyStyle ==== " + String.valueOf(recBuyStyle));
	 		
		}
		
		/*********************************cop*************************************/	
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
	
	//发送get请求
	public static String sendGet(String url) {
		String result = "";
		// String
		URL realURL = null;
		URLConnection conn = null;
		BufferedReader bufReader = null;
		String line = "";
		try {
			realURL = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("url 格式错误");
		}
		try {
			conn = realURL.openConnection();
			conn.setConnectTimeout(10000); // 10s timeout
			conn.connect(); // 连接就把参数送出去了 get方法
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("连接错误");
		}
		try {
			bufReader = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf-8"));
			while ((line = bufReader.readLine()) != null) {
				result += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("读取数据错误");
		} finally {
			if (bufReader != null) {
				try {
					bufReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		 
		super.onCreate(savedInstanceState);

		_self=this;
		
		Log.d("logoActivity","运营商信息::"+CommonTool.getProvidersName(this));
		if(CommonTool.cardType>CommonTool.CardType_NO){
			
			CommonBaseSdk.configFileName=String.format("cConfig_%d.json", CommonTool.cardType);
			initStartActivity();
			
			if(CommonTool.cardType==CommonTool.CardType_YD){//移动
				//logoImage.setImageResource(R.drawable.logo_1);	
				new Thread(new Runnable()
				{
					@Override
					public void run()
					{
						Log.d("logoActivity","getResult ==== 1  " + String.valueOf(MM_And));
						doCop();
						Log.d("logoActivity","getResult ==== 2  " + String.valueOf(MM_And));

					}
				}).start(); //这段代码在主线程中调用，开启一个线程
				onLoding_YD(savedInstanceState);;
			}
			else if(CommonTool.cardType==CommonTool.CardType_LT){//联通
				
				onLoding_LT(savedInstanceState);
				 
			}
			else if(CommonTool.cardType==CommonTool.CardType_DX){//电信
				onLoding_DX(savedInstanceState);
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
			if(CommonTool.cardType!=CommonTool.CardType_LT){
				
			if (CommonTool.cardType==CommonTool.CardType_YD){
					
				
				Log.d("logoActivity","mm_and ==== " + String.valueOf(MM_And));
					
				if (MM_And == 2 ){
					
				Log.d("logoActivity","useMM");
				
				try {
					Intent intent = new Intent();
					intent.setClass(LogoActivity.this, startActivity);
					startActivity(intent);
					finish();
				} catch (Exception e) {
					e.printStackTrace();
				}
				}
				else { 
					//todo 移动基地 
					try {
						Log.d("logoActivity","useAnd");
						CommonBaseSdk.configFileName=String.format("cConfig_%d.json", 4);
						Intent intent = new Intent();
						intent.setClass(LogoActivity.this, cn.cmgame.billing.api.GameOpenActivity.class);
						startActivity(intent);
						finish();
					} catch (Exception e) {
						e.printStackTrace();
					}	
				}
				
				}
				else {
					
					try {
						Intent intent = new Intent();
						intent.setClass(LogoActivity.this, startActivity);
						startActivity(intent);
						finish();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
			else{
				
				try {
					Intent intent = new Intent();
					intent.setClass(LogoActivity.this, com.unicom.dcLoader.welcomeview.class);
					startActivity(intent);
					finish();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			}
		});
	}
	
	
void onLoding_YD(Bundle savedInstanceState){
	Log.d("logoActivity","go into yd");
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
		
		Log.d("logoActivity","YD  mm_and" + String.valueOf(MM_And));
		
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
